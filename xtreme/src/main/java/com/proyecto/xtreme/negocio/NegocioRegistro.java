package com.proyecto.xtreme.negocio;


import com.proyecto.xtreme.entidades.Actividad;
import com.proyecto.xtreme.entidades.Empresa;
import com.proyecto.xtreme.entidades.Registro;
import com.proyecto.xtreme.repositorio.ActividadRepositorio;
import com.proyecto.xtreme.repositorio.EmpresaRepositorio;
import com.proyecto.xtreme.repositorio.RegistroRepositario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NegocioRegistro {
    @Autowired
    private RegistroRepositario registroRepositario;
    @Autowired
    private ActividadRepositorio actividadRepositorio;
    @Autowired
    private EmpresaRepositorio empresaRepositorio;

    public List<Registro> ObtenerRegistros(){
        return (List<Registro>) registroRepositario.findAll();
    }

    public Registro obtenerRegistro(Long codigo)throws Exception{
        return registroRepositario.findById(codigo).orElseThrow(() -> new Exception("No se encontro registro"));
    }

    public Registro crearRegistro(String ruc,String nombreDescriptivo,Registro registro){
        Empresa empresa = empresaRepositorio.buscarEmpresa(ruc);
        Actividad actividad = actividadRepositorio.buscarActividad(nombreDescriptivo);
        if (empresa != null && actividad != null)
            registro.setActividad(actividad);
            registro.setEmpresa(empresa);
            return registroRepositario.save(registro);
    }


   /* public Registro actualizarRegistro(Long codigo,Registro registro)throws Exception{
        Registro r = registroRepositario.findById(codigo).orElseThrow(() -> new Exception("No se puede Registrar"));
        r.se
    }



    public Registro registrarActividad(Empresa empresa, Actividad actividad){
        Registro registro=new Registro();
        registro.setCodigo(0L);
        registro.setEmpresa(empresa);
        registro.setActividad(actividad);
        return registroRepositario.save(registro);
    }

    public List<Registro> obtenerRegistros(){
        return (List)registroRepositario.findAll();
    }  */

}
