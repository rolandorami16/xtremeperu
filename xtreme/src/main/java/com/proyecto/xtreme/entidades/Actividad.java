package com.proyecto.xtreme.entidades;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "TP_ACTIVIDAD")
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nombreDescriptivo;

    @OneToMany(mappedBy = "actividad", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Registro> registro;


    public String getNombreDescriptivo() {
        return nombreDescriptivo;
    }

    public void setNombreDescriptivo(String nombreDescriptivo) {
        this.nombreDescriptivo = nombreDescriptivo;
    }

    public List<Registro> getRegistro() {
        return registro;
    }

    public void setRegistro(List<Registro> registro) {
        this.registro = registro;
    }



    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }



}
