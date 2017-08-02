package pe.edu.uni.fiis.usuario.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.uni.fiis.usuario.dao.UsuarioDao;
import pe.edu.uni.fiis.usuario.domain.Usuario;
import pe.edu.uni.fiis.usuario.service.DatosService;

import java.util.List;

/**
 * Created by furiusus on 6/29/17.
 */
@Service
public class DatosServiceImplement implements DatosService{
    @Autowired
    private UsuarioDao usuarioDao;
    public Usuario verificarUsuario(Usuario usuario) {
        return usuarioDao.verificarUsuario(usuario);
    }

    @Override
    public Usuario obtenerUsuario(Usuario usuario) {
        return usuarioDao.obtenerUsuario(usuario);
    }

    @Override
    public List<Usuario> obtenerListaUsuario(Usuario usuario) {
        return usuarioDao.obtenerListaUsuario();
    }

}
