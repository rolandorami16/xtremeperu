package com.proyecto.xtreme.negocio;

import com.proyecto.xtreme.entidades.Actividad;
import com.proyecto.xtreme.repositorio.ActividadRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NegocioActividad {
    @Autowired
    private ActividadRepositorio actividadRepositorio;

    public List<Actividad> obtenerActividades(){
        return (List<Actividad>) actividadRepositorio.findAll();
    }

    public Actividad ObtenerActividad(Long codigo)throws Exception{
        return actividadRepositorio.findById(codigo).orElseThrow(() -> new Exception("No se encontro entidad"));
    }

    public Actividad crearActividad(Actividad actividad){
        return actividadRepositorio.save(actividad);
    }

    public Actividad actualizarActividad(Long codigo,Actividad actividad)throws Exception{
        Actividad a= actividadRepositorio.findById(codigo).orElseThrow(() -> new Exception("No se puede Actualizar"));
        a.setNombreDescriptivo(actividad.getNombreDescriptivo());
        return actividadRepositorio.save(a);
    }

    public Actividad borrarActividad(Long codigo)throws Exception{
        Actividad actividad = actividadRepositorio.findById(codigo).orElseThrow(() -> new Exception("No se puede eliminar"));
        actividadRepositorio.delete(actividad);
        return actividad;
    }
}
