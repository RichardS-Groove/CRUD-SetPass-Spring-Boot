package groupdaca.groupdaca.dao;

import groupdaca.groupdaca.model.Usuario;

import java.util.List;

public interface UsuarioDao {


    List<Usuario> getUsuario();

    void registrar(Usuario usuario);

    boolean verificarCredenciales(Usuario usuario);

    String verificarRol(Usuario usuario);

    String obtenerTelefono(Usuario usuario);

    Long obtenerId(Usuario usuario);

    boolean verificarRoles(Usuario usuario);

    boolean verificarNombre(Usuario usuario);

    boolean verificarApellido(Usuario usuario);

    boolean verificarEmail(Usuario usuario);

    Usuario JWTtoken(Usuario usuario);
}
