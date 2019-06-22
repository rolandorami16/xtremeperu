package com.proyecto.xtreme.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="TP_REGISTRO")
public class Registro implements Serializable {
    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nombreRegistro;
    private String descripcion;
    private String provincia;
    private String telefono;
    private String Horario;
    private Integer cupos;
    private Date fecha_actividad;
    private String  itinerario;
    private String distrito;
    private double precio;
    @ManyToOne
    @JoinColumn(name = "codigo_actividad")
    @JsonIgnore
    private Actividad actividad;

    @ManyToOne
    @JoinColumn(name="codigo_empresa")
    @JsonIgnore
    private Empresa empresa;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreRegistro() {
        return nombreRegistro;
    }

    public void setNombreRegistro(String nombreRegistro) {
        this.nombreRegistro = nombreRegistro;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String horario) {
        Horario = horario;
    }

    public Integer getCupos() {
        return cupos;
    }

    public void setCupos(Integer cupos) {
        this.cupos = cupos;
    }

    public Date getFecha_actividad() {
        return fecha_actividad;
    }

    public void setFecha_actividad(Date fecha_actividad) {
        this.fecha_actividad = fecha_actividad;
    }

    public String getItinerario() {
        return itinerario;
    }

    public void setItinerario(String itinerario) {
        this.itinerario = itinerario;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
