package groupdaca.groupdaca.controller;

import groupdaca.groupdaca.dao.UsuarioDao;
import groupdaca.groupdaca.model.Usuario;
import groupdaca.groupdaca.Utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario) {
        if (usuarioDao.verificarCredenciales(usuario)) {
            return "OK";
        }
        return "FAIL";
    }

    @RequestMapping(value = "api/rol", method = RequestMethod.POST)
    public String rol(@RequestBody Usuario usuario) {
        return usuarioDao.verificarRol(usuario);
    }

    @RequestMapping(value = "api/telefono", method = RequestMethod.POST)
    public String phone(@RequestBody Usuario usuario) {
        return usuarioDao.obtenerTelefono(usuario);
    }

    @RequestMapping(value = "api/id", method = RequestMethod.POST)
    public Long id(@RequestBody Usuario usuario) {
        return usuarioDao.obtenerId(usuario);
    }

    @RequestMapping(value = "api/email", method = RequestMethod.POST)
    public boolean email(@RequestBody Usuario usuario) {
        return usuarioDao.verificarEmail(usuario);

    }

    @RequestMapping(value = "api/nombre", method = RequestMethod.POST)
    public boolean nombre(@RequestBody Usuario usuario) {
        return usuarioDao.verificarNombre(usuario);
    }

    @RequestMapping(value = "api/apellido", method = RequestMethod.POST)
    public boolean apellido(@RequestBody Usuario usuario) {
        return usuarioDao.verificarApellido(usuario);
    }

    @RequestMapping(value = "api/roles", method = RequestMethod.POST)
    public boolean roles(@RequestBody Usuario usuario) {
        return usuarioDao.verificarRoles(usuario);
    }

    @RequestMapping(value = "api/token", method = RequestMethod.POST)
    public String token(@RequestBody Usuario usuario) {
        Usuario user = usuarioDao.JWTtoken(usuario);
        if (user != null) {
            return jwtUtil.create(String.valueOf(user.getId()), user.getEmail());
        }
        return "FAIL";
    }


}
