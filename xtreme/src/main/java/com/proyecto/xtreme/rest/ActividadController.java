package com.proyecto.xtreme.rest;

import com.proyecto.xtreme.entidades.Actividad;
import com.proyecto.xtreme.negocio.NegocioActividad;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;



@RestController
@RequestMapping("/api2")
public class ActividadController {
    @Autowired
    private NegocioActividad negocioActividad;
    Logger logger = LoggerFactory.getLogger(ActividadController.class);

    @GetMapping("/actividades")
    public List<Actividad> obtenerActividad(){
        return negocioActividad.obtenerActividades();
    }

    @PostMapping("/actividad")
    public Actividad crearActividad(@RequestBody Actividad actividad){
        Actividad a;
        logger.debug("creando actividad");
        a = negocioActividad.crearActividad(actividad);
        return a;
    }

    @PutMapping("/actividad/{codigo}")
    public Actividad actualizarActividad(@PathVariable(value = "codigo")Long codigo,@RequestBody Actividad actividad){
        Actividad a;
        try {
            logger.debug("Actualizando actividad");
            a = negocioActividad.actualizarActividad(codigo, actividad);
            }catch (Exception e){
            logger.error("Error de actualizacion",e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Lo sentimos no se pudo actualizar");
            }
        return a;
    }

    @DeleteMapping("/actividad/{codigo}")
    public Actividad borraractividad(@PathVariable(value = "codigo")Long codigo){
        logger.debug("Eliminado Actividad");
        try {
            return negocioActividad.borrarActividad(codigo);
            }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"lo sentimos no se puede eliminar");
            }
    }

    @GetMapping("/actividad/{codigo}")
    public Actividad onternerActividad(@PathVariable(value = "codigo")Long codigo){
        Actividad a;
        try {
            logger.debug("Buscando Actividad");
            a = negocioActividad.ObtenerActividad(codigo);
        }catch (Exception e){
            logger.error("Error buscando",e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Lo sentimos no se pudo encontrar");
        }
        return a;
    }


}
