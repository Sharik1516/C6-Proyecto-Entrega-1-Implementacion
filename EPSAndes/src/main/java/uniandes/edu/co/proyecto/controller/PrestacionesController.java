package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.Prestaciones;
import uniandes.edu.co.proyecto.repositorio.PrestacionesRepository;

import java.util.List;

@RestController
@RequestMapping("/prestaciones")
public class PrestacionesController {

    @Autowired
    private PrestacionesRepository prestacionesRepository;

    @GetMapping
    public ResponseEntity<List<Prestaciones>> obtenerPrestaciones() {
        return ResponseEntity.ok(prestacionesRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Prestaciones> crearPrestacion(@RequestBody Prestaciones prestacion) {
        Prestaciones nueva = prestacionesRepository.save(prestacion);
        return ResponseEntity.ok(nueva);
    }
}
