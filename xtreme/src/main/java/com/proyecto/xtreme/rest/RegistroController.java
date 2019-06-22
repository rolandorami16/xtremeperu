package com.proyecto.xtreme.rest;


import com.proyecto.xtreme.entidades.Registro;
import com.proyecto.xtreme.negocio.NegocioRegistro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api3")
public class RegistroController {
    @Autowired
    private NegocioRegistro negocioRegistro;
    Logger logger = LoggerFactory.getLogger(RegistroController.class);

    @GetMapping("/registros")
    public List<Registro> obtenerRegistro(){
        return negocioRegistro.ObtenerRegistros();
    }
}
