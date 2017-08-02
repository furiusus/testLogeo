package pe.edu.uni.fiis.usuario.service;

import pe.edu.uni.fiis.usuario.domain.Usuario;

import java.util.List;

/**
 * Created by furiusus on 6/29/17.
 */
public interface DatosService {
        public Usuario verificarUsuario(Usuario usuario);
        public List<Usuario> obtenerListaUsuario(Usuario usuario);
        public Usuario obtenerUsuario(Usuario usuario);
}