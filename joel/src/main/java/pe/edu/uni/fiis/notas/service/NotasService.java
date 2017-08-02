package pe.edu.uni.fiis.notas.service;

import pe.edu.uni.fiis.notas.domain.Alumno;

import java.util.List;

/**
 * Created by Alumno on 3/06/2017.
 */
public interface NotasService {
    public Alumno verificarUsuario(Alumno alumno);
    public List<Alumno> obtenerAlumnos();
    public Alumno registrarUsuario(Alumno alumno);

}
