package pe.edu.uni.fiis.notas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.uni.fiis.notas.domain.Alumno;
import pe.edu.uni.fiis.notas.domain.AlumnosResponse;
import pe.edu.uni.fiis.notas.service.NotasService;

@Controller
public class NotasController {
    @Autowired
    private NotasService notasService;
    @RequestMapping(value = "/validarUsuario",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody Alumno validarUsuario(@RequestBody Alumno alumno){
        return notasService.verificarUsuario(alumno);
    }
    @RequestMapping(value = "/registrarUsuario",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody Alumno registrarUsuario(@RequestBody Alumno alumno){
        return notasService.registrarUsuario(alumno);
    }
    @RequestMapping(value = "/mostrarAlumnos",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody AlumnosResponse validarUsuario(){
        AlumnosResponse response = new AlumnosResponse();
        response.setLista(notasService.obtenerAlumnos());
        return response;
    }
}
