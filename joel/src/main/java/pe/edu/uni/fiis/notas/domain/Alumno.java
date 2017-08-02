package pe.edu.uni.fiis.notas.domain;

import java.math.BigDecimal;

/**
 * Created by Alumno on 20/05/2017.
 */
public class Alumno {
    private String codigo;
    private String nombres;
    private String paterno;
    private String materno;
    private Integer cicloRelativo;
    private BigDecimal ponderado;
    private String condicion;
    private String estadoMatricula;
    private String especialidad;
    private String clave;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public Integer getCicloRelativo() {
        return cicloRelativo;
    }

    public void setCicloRelativo(Integer cicloRelativo) {
        this.cicloRelativo = cicloRelativo;
    }

    public BigDecimal getPonderado() {
        return ponderado;
    }

    public void setPonderado(BigDecimal ponderado) {
        this.ponderado = ponderado;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getEstadoMatricula() {
        return estadoMatricula;
    }

    public void setEstadoMatricula(String estadoMatricula) {
        this.estadoMatricula = estadoMatricula;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

}
