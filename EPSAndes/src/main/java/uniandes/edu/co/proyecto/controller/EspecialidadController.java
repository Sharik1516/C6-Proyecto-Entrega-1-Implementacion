package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.Especialidad;
import uniandes.edu.co.proyecto.repositorio.EspecialidadRepository;

import java.util.List;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadController {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @GetMapping
    public ResponseEntity<List<Especialidad>> obtenerTodas() {
        return ResponseEntity.ok(especialidadRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Especialidad> crearEspecialidad(@RequestBody Especialidad especialidad) {
        Especialidad nueva = especialidadRepository.save(especialidad);
        return ResponseEntity.ok(nueva);
    }
}
