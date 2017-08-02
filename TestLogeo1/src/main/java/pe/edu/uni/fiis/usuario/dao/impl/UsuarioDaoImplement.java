package pe.edu.uni.fiis.usuario.dao.impl;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pe.edu.uni.fiis.usuario.dao.SimpleJdbc;
import pe.edu.uni.fiis.usuario.dao.UsuarioDao;
import pe.edu.uni.fiis.usuario.domain.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by furiusus on 6/27/17.
 */
@Repository
public class UsuarioDaoImplement extends SimpleJdbc implements UsuarioDao{
    public Usuario agregarUsuario(Usuario usuario) {
        String sql="INSERT INTO USUARIO(USUARIO, PASS, NOMBRE, APELLIDO, CORREO)\n" +
                "     VALUES (?,?,?,?,?);";
        getJdbcTemplate().update(sql,
                new Object[]{
                    usuario.getUsuario(),usuario.getPass(),usuario.getNombre(),usuario.getApellido(),
                        usuario.getCorreo()
                }
                );
        return usuario;
    }

    public Usuario modificarUsuario(Usuario usuario) {
        String sql="UPDATE USUARIO SET USUARIO=?,PASS=?,NOMBRE=?,APELLIDO=?,CORREO=? WHERE USUARIO=? ";
        getJdbcTemplate().update(sql,
                    new Object[]{
                        usuario.getUsuario(), usuario.getPass(),usuario.getNombre(),usuario.getApellido(),usuario.getCorreo()
                    }
                );
        return usuario;
    }

    public void eliminarUsuario(Usuario usuario) {
        String sql="DELETE FROM USUARIO WHERE USUARIO=? ";
        getJdbcTemplate().update(sql,
                new Object[]{
                    usuario.getUsuario()
                });
    }

    public Usuario obtenerUsuario(Usuario usuario) {
        String sql="SELECT USUARIO,NOMBRE,APELLIDO,CORREO FROM USUARIO WHERE USUARIO=?";
        Usuario respuesta=getJdbcTemplate().queryForObject(sql,
                new Object[]{usuario.getUsuario()},
                 new RowMapper<Usuario>() {
                    public Usuario mapRow(ResultSet resultSet, int i) throws SQLException {
                        Usuario usuarioObj= new Usuario();
                        usuarioObj.setUsuario(resultSet.getString("USUARIO"));
                        usuarioObj.setNombre(resultSet.getString("NOMBRE"));
                        usuarioObj.setApellido(resultSet.getString("APELLIDO"));
                        usuarioObj.setCorreo(resultSet.getString("CORREO"));
                        return usuarioObj;
                    }
                }
        );
        return respuesta;
    }

    public List<Usuario> obtenerListaUsuario() {
        String sql="SELECT USUARIO,NOMBRE,APELLIDO,CORREO FROM USUARIO ";
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        List<Map<String,Object>> lista = getJdbcTemplate().queryForList(sql);
            if(lista!=null && lista.size()>0) {
                for(int i=0;i<lista.size();i++) {
                    Usuario usuarioObj = new Usuario();
                    usuarioObj.setUsuario((String) lista.get(i).get("USUARIO"));
                    usuarioObj.setNombre((String) lista.get(i).get("NOMBRE"));
                    usuarioObj.setApellido((String) lista.get(i).get("APELLIDO"));
                    usuarioObj.setCorreo((String) lista.get(i).get("CORREO"));
                    listaUsuarios.add(usuarioObj);
                }
            }
        return listaUsuarios;
    }

    public Usuario verificarUsuario(Usuario usuario) {
        Usuario response;
        String sql="SELECT USUARIO,NOMBRE,APELLIDO,CORREO FROM USUARIO WHERE USUARIO=? AND PASS=?";
        response=getJdbcTemplate().queryForObject(sql,
                new Object[]{usuario.getUsuario(), usuario.getPass()},
                new RowMapper<Usuario>() {
                    public Usuario mapRow(ResultSet resultSet, int i) throws SQLException {
                        Usuario usuarioObj= new Usuario();
                        usuarioObj.setUsuario(resultSet.getString("USUARIO"));
                        usuarioObj.setNombre(resultSet.getString("NOMBRE"));
                        usuarioObj.setApellido(resultSet.getString("APELLIDO"));
                        usuarioObj.setCorreo(resultSet.getString("CORREO"));
                        return usuarioObj;
                    }
                }
        );
        return response;
    }
}

