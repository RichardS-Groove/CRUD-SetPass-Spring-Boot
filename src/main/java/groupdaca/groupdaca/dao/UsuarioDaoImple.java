package groupdaca.groupdaca.dao;

import groupdaca.groupdaca.model.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import groupdaca.groupdaca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImple implements UsuarioDao {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Usuario> getUsuario() {

        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();

    }

    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public boolean verificarCredenciales(Usuario usuario) {

        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();

        if (lista.isEmpty()) return false;

        String passwordHASHED = lista.get(0).getPassword();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return argon2.verify(passwordHASHED, usuario.getPassword());
    }

    @Override
    public String verificarRol(Usuario usuario) {
        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();

        if (lista.isEmpty()) return null;

        String res = lista.get(0).getRol();
        return res;
    }

    @Override
    public String obtenerTelefono(Usuario usuario) {
        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();

        if (lista.isEmpty()) return null;

        String res = lista.get(0).getTelefono();
        return res;
    }

    @Override
    public Long obtenerId(Usuario usuario) {
        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();

        if (lista.isEmpty()) return null;

        Long res = lista.get(0).getId();
        return res;
    }

    @Override
    public boolean verificarRoles(Usuario usuario) {
        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();

        if (lista.isEmpty()) return false;

        String res = lista.get(0).getRol();
        return res.equals(usuario.getRol());
    }

    @Override
    public boolean verificarEmail(Usuario usuario) {
        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();

        if (lista.isEmpty()) return false;

        String res = lista.get(0).getEmail();
        return res.equals(usuario.getEmail());
    }

    @Override
    public boolean verificarNombre(Usuario usuario) {
        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();

        if (lista.isEmpty()) return false;

        String res = lista.get(0).getNombre();
        return res.equals(usuario.getNombre());
    }

    @Override
    public boolean verificarApellido(Usuario usuario) {
        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();

        if (lista.isEmpty()) return false;

        String res = lista.get(0).getApellido();
        return res.equals(usuario.getApellido());
    }

    @Override
    public Usuario JWTtoken(Usuario usuario) {
        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();

        if (lista.isEmpty()) return null;

        Usuario res = lista.get(0);
        return res;
    }

}
