package pe.edu.uni.fiis.notas.dao;

import pe.edu.uni.fiis.notas.domain.Alumno;

import java.util.List;

/**
 * Created by Alumno on 3/06/2017.
 */
public interface AlumnoDAO {
    public Alumno agregarAlumno(Alumno alumno);
    public Alumno modificarAlumno(Alumno alumno);
    public void eliminarAlumno(Alumno alumno);
    public Alumno obtenerAlumno(Alumno alumno);
    public List<Alumno> obtenerAlumnos();
    public Alumno verificarUsuario(Alumno alumno);
}
