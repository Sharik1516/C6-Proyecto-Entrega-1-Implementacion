package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.CitaMedica;
import uniandes.edu.co.proyecto.repositorio.CitaMedicaRepository;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaMedicaController {

    @Autowired
    private CitaMedicaRepository citaMedicaRepository;

    @GetMapping
    public ResponseEntity<List<CitaMedica>> obtenerCitas() {
        return ResponseEntity.ok(citaMedicaRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<CitaMedica> crearCita(@RequestBody CitaMedica cita) {
        CitaMedica nueva = citaMedicaRepository.save(cita);
        return ResponseEntity.ok(nueva);
    }
}
