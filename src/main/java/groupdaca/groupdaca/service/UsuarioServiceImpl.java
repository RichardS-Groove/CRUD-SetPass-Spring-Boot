package groupdaca.groupdaca.service;

import groupdaca.groupdaca.model.Usuario;
import groupdaca.groupdaca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getAllUsuario() {
        return usuarioRepository.findAll();
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        this.usuarioRepository.save(usuario);
    }

    @Override
    public Usuario getUsuarioById(long id) {
        Optional<Usuario> optional = usuarioRepository.findById(id);
        Usuario usuario = null;
        if (optional.isPresent()) {
            usuario = optional.get();
        } else {
            throw new RuntimeException(" Usuario not found for id :: " + id);
        }
        return usuario;
    }

    @Override
    public void deleteUsuarioById(long id) {
        this.usuarioRepository.deleteById(id);
    }

    @Override
    public Page<Usuario> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.usuarioRepository.findAll(pageable);
    }
}
