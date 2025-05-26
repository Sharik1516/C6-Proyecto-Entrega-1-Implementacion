package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.IPSservicio;
import uniandes.edu.co.proyecto.repositorio.IPSservicioRepository;

import java.util.List;

@RestController
@RequestMapping("/ipsservicios")
public class IPSservicioController {


    @Autowired
    private IPSservicioRepository ipsServicioRepository;

    @GetMapping
    public ResponseEntity<List<IPSservicio>> obtenerIPSservicios() {
        return ResponseEntity.ok(ipsServicioRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<IPSservicio> crearIPSservicio(@RequestBody IPSservicio ipsservicio) {
        IPSservicio nuevo = ipsServicioRepository.save(ipsservicio);
        return ResponseEntity.ok(nuevo);
    }
}
