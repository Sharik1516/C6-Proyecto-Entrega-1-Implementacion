package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.Medico;
import uniandes.edu.co.proyecto.repositorio.MedicoRepository;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping
    public ResponseEntity<List<Medico>> obtenerMedicos() {
        return ResponseEntity.ok(medicoRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Medico> crearMedico(@RequestBody Medico medico) {
        Medico nuevo = medicoRepository.save(medico);
        return ResponseEntity.ok(nuevo);
    }
}
