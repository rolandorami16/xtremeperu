package com.proyecto.xtreme.rest;

import com.proyecto.xtreme.entidades.Empresa;
import com.proyecto.xtreme.negocio.NegocioEmpresa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmpresaController {
    @Autowired
    private NegocioEmpresa negocioEmpresa;
    Logger logger = LoggerFactory.getLogger(EmpresaController.class);

    @GetMapping("/empresas")
    public List<Empresa> obtenerEmpresa(){
        return negocioEmpresa.obtenerEmpresas();
    }

     @PostMapping("/empresa")
    public Empresa crearEmpresa(@RequestBody Empresa empresa){
         Empresa e;
         logger.debug("Creando la empresa");
         e = negocioEmpresa.crearEmpresa(empresa);
         return e;
     }

     @PutMapping("/empresa/{codigo}")
    public Empresa actualizarEmpresa(@PathVariable(value = "codigo")Long codigo,@RequestBody Empresa empresa) {
         Empresa e;
         try {
             logger.debug("Actualizando empresa");
             e = negocioEmpresa.actualizarEmpresa(codigo, empresa);
             logger.debug("empresa actualizada");
         } catch (Exception x) {
             logger.error("Error de actualizacion", x);
             throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lo sentimos no se pudo actualizar");
         }
         return e;
     }

     @DeleteMapping("/empresa/{codigo}")
    public Empresa borrarEmpresa(@PathVariable(value = "codigo")Long codigo) {
         logger.debug("Eliminado  objeto");
         try {
             return negocioEmpresa.borrarEmpresa(codigo);
         } catch (Exception x) {
             logger.error("Error Eliminado", x);
             throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lo sentimos no se pudo eliminar");
         }
     }

     @GetMapping("/empresa/{codigo}")
    public Empresa obtenerEmpresa(@PathVariable(value = "codigo")Long codigo){
    Empresa e;
    try {
        logger.debug("buscando Empresa");
        e = negocioEmpresa.obtenerEmpresa(codigo);
         }catch (Exception x){
        logger.error("Error buscando",x);
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Lo sentimos no se pudo encontrar");
        }
    return e;
    }

}
