package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.ContribuyenteBeneficiario;
import uniandes.edu.co.proyecto.repositorio.ContribuyenteBeneficiarioRepository;

import java.util.List;

@RestController
@RequestMapping("/contribuciones")
public class ContribuyenteBeneficiarioController {

    @Autowired
    private ContribuyenteBeneficiarioRepository repository;

    @GetMapping
    public ResponseEntity<List<ContribuyenteBeneficiario>> obtenerContribuciones() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<ContribuyenteBeneficiario> crearContribucion(@RequestBody ContribuyenteBeneficiario contribucion) {
        ContribuyenteBeneficiario nueva = repository.save(contribucion);
        return ResponseEntity.ok(nueva);
    }
}
