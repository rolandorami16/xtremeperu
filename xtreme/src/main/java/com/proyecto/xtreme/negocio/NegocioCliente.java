package com.proyecto.xtreme.negocio;

import com.proyecto.xtreme.entidades.Cliente;
import com.proyecto.xtreme.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NegocioCliente {

    @Autowired

    private ClienteRepositorio clienteRepositorio;

    public List<Cliente> obtenerCliente() {return (List<Cliente>) clienteRepositorio.findAll();}
    public Cliente obtenerCliente (Long codigo) throws Exception{
        return clienteRepositorio.findById(codigo).orElseThrow(() -> new Exception("No se encontro entidad"));
    }

    public Cliente crearCliente(Cliente cliente) {return clienteRepositorio.save(cliente);}

    public Cliente actualizarCliente(Long codigo, Cliente cliente) throws Exception{
        Cliente e = clienteRepositorio.findById(codigo).orElseThrow(() -> new Exception("No se puede actualizar"));
        e.setApellido(cliente.getApellido());
        e.setDni(cliente.getDni());
        e.setMail(cliente.getMail());
        e.setNombre(cliente.getNombre());
        e.setPassword(cliente.getPassword());
        e.setDepartamento(cliente.getDepartamento());
        e.setDireccion(cliente.getDireccion());
        e.setFecha_nacimiento(cliente.getFecha_nacimiento());
        return clienteRepositorio.save(e);
    }
    public Cliente borrarCliente(Long codigo) throws Exception{
        Cliente cliente = clienteRepositorio.findById(codigo).orElseThrow(() -> new Exception("No se puede eliminar"));
        clienteRepositorio.delete(cliente);
        return cliente;
    }
}
