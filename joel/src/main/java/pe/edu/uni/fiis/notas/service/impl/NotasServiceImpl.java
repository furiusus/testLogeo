package pe.edu.uni.fiis.notas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.uni.fiis.notas.dao.AlumnoDAO;
import pe.edu.uni.fiis.notas.domain.Alumno;
import pe.edu.uni.fiis.notas.service.NotasService;

import java.util.List;

/**
 * Created by Alumno on 3/06/2017.
 */
@Service
public class NotasServiceImpl implements NotasService{
    @Autowired
    private AlumnoDAO alumnoDAO;
    public Alumno verificarUsuario(Alumno alumno) {
        return alumnoDAO.verificarUsuario(alumno);
    }
    public Alumno registrarUsuario(Alumno alumno) {
        return alumnoDAO.agregarAlumno(alumno);
    }
    @Override
    public List<Alumno> obtenerAlumnos() {
        return alumnoDAO.obtenerAlumnos();
    }
}
