package com.proyecto.xtreme.negocio;

import com.proyecto.xtreme.entidades.Empresa;
import com.proyecto.xtreme.repositorio.EmpresaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NegocioEmpresa {
    @Autowired
    private EmpresaRepositorio empresaRepositorio;

    public List<Empresa> obtenerEmpresas(){
        return (List<Empresa>) empresaRepositorio.findAll();
    }

    public  Empresa obtenerEmpresa(Long codigo)throws Exception{
        return empresaRepositorio.findById(codigo).orElseThrow(() -> new Exception("No se encontro entidad"));
    }

    public Empresa crearEmpresa(Empresa empresa){
        return empresaRepositorio.save(empresa);
    }

    public Empresa actualizarEmpresa(Long codigo,Empresa empresa)throws Exception{
        Empresa e = empresaRepositorio.findById(codigo).orElseThrow(() -> new Exception("No se puede actualizar"));
        e.setCorreoinfo(empresa.getCorreoinfo());
        e.setDepartamento(empresa.getDepartamento());
        e.setDireccion(empresa.getDireccion());
        e.setDistrito(empresa.getDistrito());
        e.setNombreComercial(empresa.getNombreComercial());
        e.setProvincia(empresa.getProvincia());
        e.setRazonSocial(empresa.getRazonSocial());
        e.setRuc(empresa.getRuc());
        e.setTelefono((empresa.getTelefono()));
        e.setWeb(empresa.getWeb());
        return empresaRepositorio.save(e);
    }

    public Empresa borrarEmpresa(Long codigo) throws Exception{
        Empresa empresa = empresaRepositorio.findById(codigo).orElseThrow(() -> new Exception("No se puede eliminar"));
        empresaRepositorio.delete(empresa);
        return empresa;
    }

}
