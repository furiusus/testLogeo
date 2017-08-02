package pe.edu.uni.fiis.usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.condition.MediaTypeExpression;
import pe.edu.uni.fiis.usuario.domain.Usuario;
import pe.edu.uni.fiis.usuario.domain.UsuarioResponse;
import pe.edu.uni.fiis.usuario.service.DatosService;

/**
 * Created by furiusus on 6/29/17.
 */
@Controller
public class DatosController {
    @Autowired
    private DatosService datosService;
    @RequestMapping(value = "/validarUsuario",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody Usuario validarUsuario(@RequestBody Usuario usuario){
        return datosService.verificarUsuario(usuario);
    }
    @RequestMapping(value = "/mostrarListaUsuario",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody UsuarioResponse mostrarListaUsuario(@RequestBody Usuario usuario){
        UsuarioResponse response= new UsuarioResponse();
        response.setLista(datosService.obtenerListaUsuario(usuario));
        return response;
    }
    @RequestMapping(value = "/obtenerUsuario",
        method = RequestMethod.POST,
            produces =MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody Usuario mostrarUsuario(@RequestBody Usuario usuario){
        return datosService.obtenerUsuario(usuario);
    }

}
