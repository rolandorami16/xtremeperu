package com.proyecto.xtreme.repositorio;

import com.proyecto.xtreme.entidades.Empresa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EmpresaRepositorio extends CrudRepository<Empresa, Long> {
    @Query("SELECT e FROM Empresa e WHERE e.ruc=:ruc")
    Empresa buscarEmpresa(@Param("ruc")String ruc);
}
