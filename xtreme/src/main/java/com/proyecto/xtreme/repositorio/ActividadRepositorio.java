package com.proyecto.xtreme.repositorio;

import com.proyecto.xtreme.entidades.Actividad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ActividadRepositorio extends CrudRepository<Actividad, Long> {
    @Query("SELECT a FROM Actividad a WHERE a.nombreDescriptivo=:nombreDescriptivo")
    Actividad buscarActividad(@Param("nombreDescriptivo")String nombreDescriptivo);
}
