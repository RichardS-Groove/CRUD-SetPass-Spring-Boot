package groupdaca.groupdaca.service;

import groupdaca.groupdaca.model.Usuario;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UsuarioService {


    List<Usuario> getAllUsuario();

    void saveUsuario(Usuario usuario);

    Usuario getUsuarioById(long id);

    void deleteUsuarioById(long id);

    Page<Usuario> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
