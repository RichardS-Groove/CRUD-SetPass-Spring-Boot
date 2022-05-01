package groupdaca.groupdaca.controller;

import groupdaca.groupdaca.model.Usuario;
import groupdaca.groupdaca.dao.UsuarioDao;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import groupdaca.groupdaca.service.UsuarioService;
import groupdaca.groupdaca.Utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/usuario", method = RequestMethod.GET)
    public List<Usuario> getUsuario(@RequestHeader(value = "Authorization") String token) {
        if (!validarToken(token)) return null;
        return usuarioDao.getUsuario();
    }

    private boolean validarToken(String token) {
        return jwtUtil.getKey(token) != null;
    }

    @RequestMapping(value = "api/usuario", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
        usuario.setPassword(hash);
        usuarioDao.registrar(usuario);
    }

    @GetMapping("/listusuario")
    public String viewHomePage(Model model) {
        return findPaginated(1, "nombre", "asc", model);
    }

    @GetMapping("/showNewUsuarioForm")
    public String showNewUsuarioForm(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "new_usuario";
    }

    @GetMapping("/showFormUserForUpdate/{id}")
    public String showFormUserForUpdate(@PathVariable(value = "id") long id, Model model) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        model.addAttribute("usuario", usuario);
        return "update_usuario";
    }

    @PostMapping("/saveUsuario")
    public String saveUsuario(@ModelAttribute("usuario") Usuario usuario) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
        usuario.setPassword(hash);
        usuarioService.saveUsuario(usuario);
        return "redirect:/listusuario";
    }

    @GetMapping("/deleteUsuario/{id}")
    public String deleteUsuario(@PathVariable(value = "id") long id) {
        this.usuarioService.deleteUsuarioById(id);
        return "redirect:/listusuario";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Usuario> page = usuarioService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Usuario> listUsuarios = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listUsuarios", listUsuarios);
        return "list_usuario";
    }
}
