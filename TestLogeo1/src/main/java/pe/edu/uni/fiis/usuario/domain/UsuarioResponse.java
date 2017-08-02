package pe.edu.uni.fiis.usuario.domain;

import java.util.List;

/**
 * Created by furiusus on 6/28/17.
 */
public class UsuarioResponse {
    private List<Usuario> lista;

    public List<Usuario> getLista() {
        return lista;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }
}
