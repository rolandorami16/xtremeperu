package com.proyecto.xtreme.rest;

import com.proyecto.xtreme.entidades.Cliente;
import com.proyecto.xtreme.negocio.NegocioCliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/api1")
public class ClienteController {

    @Autowired
    private NegocioCliente negocioCliente;

    Logger logger = LoggerFactory.getLogger(ClienteController.class);

    //ListarClientes
    @GetMapping("/clientes")
    public List<Cliente> obtenerClientes(){
        return  negocioCliente.obtenerCliente();
    }

    //Crear Cliente
    @PostMapping("/cliente")
    public Cliente crearCliente (@RequestBody Cliente cliente){
        Cliente e;
        logger.debug("Creando la cliente");
        e = negocioCliente.crearCliente(cliente);
        return e;
    }

    @PutMapping("/cliente/{codigo}")
    public Cliente actualizarCliente(@PathVariable(value = "codigo")Long codigo, @RequestBody Cliente cliente) {
        Cliente e;
        try {
            logger.debug("Actualizando cliente");
            e = negocioCliente.actualizarCliente(codigo, cliente);
            logger.debug("cliente actualizada");
        } catch (Exception x) {
            logger.error("Error de actualizacion", x);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lo sentimos no se pudo actualizar");
        }
        return e;
    }

    @DeleteMapping("/cliente/{codigo}")
    public Cliente borrarCliente(@PathVariable(value = "codigo")Long codigo) {
        logger.debug("Eliminado  objeto");
        try {
            return negocioCliente.borrarCliente(codigo);
        } catch (Exception x) {
            logger.error("Error Eliminado", x);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lo sentimos no se pudo eliminar");
        }
    }

    @GetMapping("/cliente/{codigo}")
    public Cliente obtenerCliente(@PathVariable(value = "codigo")Long codigo){
        Cliente e;
        try {
            logger.debug("buscando Cliente");
            e = negocioCliente.obtenerCliente(codigo);
        }catch (Exception x){
            logger.error("Error buscando",x);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Lo sentimos no se pudo encontrar");
        }
        return e;
    }



}
