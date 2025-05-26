package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.EPS;
import uniandes.edu.co.proyecto.repositorio.EPSRepository;

import java.util.List;

@RestController
@RequestMapping("/eps")
public class EPSController {

    @Autowired
    private EPSRepository epsRepository;

    @GetMapping
    public ResponseEntity<List<EPS>> obtenerTodas() {
        return ResponseEntity.ok(epsRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<EPS> crearEPS(@RequestBody EPS eps) {
        EPS nueva = epsRepository.save(eps);
        return ResponseEntity.ok(nueva);
    }
}
