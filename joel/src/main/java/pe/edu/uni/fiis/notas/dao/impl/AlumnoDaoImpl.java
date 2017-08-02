package pe.edu.uni.fiis.notas.dao.impl;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pe.edu.uni.fiis.notas.dao.AlumnoDAO;
import pe.edu.uni.fiis.notas.dao.SimpleJdbc;
import pe.edu.uni.fiis.notas.domain.Alumno;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Alumno on 3/06/2017.
 */
@Repository
public class AlumnoDaoImpl extends SimpleJdbc implements AlumnoDAO{
    public Alumno agregarAlumno(Alumno alumno) {
        String sql = " INSERT INTO ALUMNO( CODIGO, NOMBRE, PATERNO, MATERNO, CICLO_RELATIVO, " +
                "  PONDERADO, CONDICION, ESTADO_MATRICULA, ESPECIALIDAD, CLAVE) " +
                " VALUES (?,?,?,?,?,?,?,?,?,?)";

        getJdbcTemplate().update(sql,
                new Object[]{
                    alumno.getCodigo(),alumno.getNombres(), alumno.getPaterno(),
                        alumno.getMaterno(),alumno.getCicloRelativo(), alumno.getPonderado(),
                        alumno.getCondicion(),alumno.getEstadoMatricula(),alumno.getEspecialidad(),
                        alumno.getClave()
                });

        return alumno;
    }

    public Alumno modificarAlumno(Alumno alumno) {
        String sql = " UPDATE ALUMNO " +
                " SET NOMBRE = ?, PATERNO = ?, MATERNO = ?, " +
                " CICLO_RELATIVO = ?, PONDERADO = ?, CONDICION = ?," +
                " ESTADO_MATRICULA = ?, ESPECIALIDAD = ?, CLAVE  = ?" +
                " WHERE CODIGO = ?";
        getJdbcTemplate().update(sql,
                new Object[]{
                        alumno.getNombres(), alumno.getPaterno(),
                        alumno.getMaterno(),alumno.getCicloRelativo(), alumno.getPonderado(),
                        alumno.getCondicion(),alumno.getEstadoMatricula(),alumno.getEspecialidad(),
                        alumno.getClave(),alumno.getCodigo()
                });
        return alumno;
    }

    public void eliminarAlumno(Alumno alumno) {
        String sql = " DELETE FROM ALUMNO WHERE CODIGO = ? ";
        getJdbcTemplate().update(sql,
                new Object[]{
                        alumno.getCodigo()
                });
    }

    public Alumno obtenerAlumno(Alumno alumno) {
        String sql = " SELECT CODIGO, NOMBRE, PATERNO, MATERNO, CICLO_RELATIVO, " +
                "  PONDERADO, CONDICION, ESTADO_MATRICULA, ESPECIALIDAD, CLAVE " +
                " FROM ALUMNO " +
                " WHERE CODIGO = ?";
        Alumno respuesta = getJdbcTemplate().queryForObject(sql,
                new Object[]{alumno.getCodigo()},
                new RowMapper<Alumno>() {
                    public Alumno mapRow(ResultSet resultSet, int i) throws SQLException {
                        Alumno objeto = new Alumno();
                        objeto.setCodigo(resultSet.getString("CODIGO"));
                        objeto.setPaterno(resultSet.getString("PATERNO"));
                        objeto.setMaterno(resultSet.getString("MATERNO"));
                        objeto.setPonderado(resultSet.getBigDecimal("PONDERADO"));
                        return objeto;
                    }
                }
        );
        return respuesta;
    }

    public List<Alumno> obtenerAlumnos() {
        String sql = " SELECT CODIGO, NOMBRE, PATERNO, MATERNO, CICLO_RELATIVO, " +
                "  PONDERADO, CONDICION, ESTADO_MATRICULA, ESPECIALIDAD, CLAVE " +
                " FROM ALUMNO ";
        List<Alumno> alumnos = new ArrayList<Alumno>();
        List<Map<String,Object>> lista = getJdbcTemplate().queryForList(sql);
        if(lista != null && lista.size()>0){
            for (int i = 0; i < lista.size(); i++) {
                Alumno alumno = new Alumno();
                alumno.setCodigo((String)lista.get(i).get("CODIGO"));
                alumno.setPaterno((String)lista.get(i).get("PATERNO"));
                alumno.setMaterno((String)lista.get(i).get("MATERNO"));
                alumno.setNombres((String)lista.get(i).get("NOMBRE"));
                alumnos.add(alumno);
            }
        }
        return alumnos;
    }

    public Alumno verificarUsuario(Alumno alumno) {
        Alumno response = null;
        String sql = " SELECT CODIGO, NOMBRE, PATERNO, MATERNO, CICLO_RELATIVO, " +
                "  PONDERADO, CONDICION, ESTADO_MATRICULA, ESPECIALIDAD, CLAVE " +
                " FROM ALUMNO " +
                " WHERE CODIGO = ? AND CLAVE = ?";
        response = getJdbcTemplate().queryForObject(sql, new Object[]{alumno.getCodigo(), alumno.getClave() },
                new RowMapper<Alumno>() {
            public Alumno mapRow(ResultSet resultSet, int i) throws SQLException {
                Alumno objeto = new Alumno();
                objeto.setCodigo(resultSet.getString("CODIGO"));
                objeto.setPaterno(resultSet.getString("PATERNO"));
                objeto.setMaterno(resultSet.getString("MATERNO"));
                objeto.setNombres(resultSet.getString("NOMBRE"));
                objeto.setCicloRelativo(resultSet.getInt("CICLO_RELATIVO"));
                objeto.setPonderado(resultSet.getBigDecimal("PONDERADO"));
                objeto.setCondicion(resultSet.getString("CONDICION"));
                objeto.setEstadoMatricula(resultSet.getString("ESTADO_MATRICULA"));
                objeto.setEspecialidad(resultSet.getString("ESPECIALIDAD"));
                objeto.setClave(resultSet.getString("CLAVE"));
                return objeto;
            }
        });

        return response;
    }
}
