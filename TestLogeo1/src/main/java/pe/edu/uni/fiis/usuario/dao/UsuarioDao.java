package pe.edu.uni.fiis.usuario.dao;


import pe.edu.uni.fiis.usuario.domain.Usuario;

import java.util.List;

/**
 * Created by furiusus on 6/27/17.
 */
public interface UsuarioDao {
    public Usuario agregarUsuario(Usuario usuario);

    public Usuario modificarUsuario(Usuario usuario);

    public void eliminarUsuario(Usuario usuario);

    public Usuario obtenerUsuario(Usuario usuario);

    public Usuario verificarUsuario(Usuario usuario);

    public List<Usuario> obtenerListaUsuario();
}