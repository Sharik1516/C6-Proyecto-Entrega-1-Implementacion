package uniandes.edu.co.proyecto.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.DTO.RFC5DTO;
import uniandes.edu.co.proyecto.Service.RFC5Service;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/RFC5")
public class RFC5Controller {

    private final RFC5Service rfc5Service;

    public RFC5Controller(RF5Service rfc5Service) {
        this.rfc5Service = rfc5Service;
    }

    @GetMapping("/consultaRFC5")
    public List<RFC5DTO> consultarDisponibilidad(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio, @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin, @RequestParam(required = false) String idMedico, @RequestParam(required = false) String idServicio, @RequestParam(required = false) String NIT) throws InterruptedException {
        return rfc5Service.consultarDisponibilidad(fechaInicio, fechaFin, idMedico, idServicio, NIT);
    }
}

