package com.proyecto.xtreme.entidades;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TP_EMPRESA")
public class Empresa implements Serializable {
    private static final long serialVersionUID = 54646546464161653L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String razonSocial;
    private String nombreComercial;
    private String ruc;
    private String correoinfo;
    private String telefono;
    private String web;
    private String direccion;
    private String departamento;
    private String provincia;
    private String distrito;
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Registro> registros;

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getCorreoinfo() {
        return correoinfo;
    }

    public void setCorreoinfo(String correoinfo) {
        this.correoinfo = correoinfo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }
}
