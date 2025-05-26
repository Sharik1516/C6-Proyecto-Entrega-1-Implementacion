package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.Parentesco;
import uniandes.edu.co.proyecto.repositorio.ParentescoRepository;

import java.util.List;

@RestController
@RequestMapping("/parentescos")
public class ParentescoController {

    @Autowired
    private ParentescoRepository parentescoRepository;

    @GetMapping
    public ResponseEntity<List<Parentesco>> obtenerParentescos() {
        return ResponseEntity.ok(parentescoRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Parentesco> crearParentesco(@RequestBody Parentesco parentesco) {
        Parentesco nuevo = parentescoRepository.save(parentesco);
        return ResponseEntity.ok(nuevo);
    }
}
