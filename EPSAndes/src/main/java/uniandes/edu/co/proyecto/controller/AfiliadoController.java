package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.Afiliado;
import uniandes.edu.co.proyecto.repositorio.AfiliadoRepository;

import java.util.List;

@RestController
@RequestMapping("/afiliados")
public class AfiliadoController {

    @Autowired
    private AfiliadoRepository afiliadoRepository;

    @GetMapping
    public ResponseEntity<List<Afiliado>> obtenerAfiliados() {
        return ResponseEntity.ok(afiliadoRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Afiliado> crearAfiliado(@RequestBody Afiliado afiliado) {
        Afiliado nuevo = afiliadoRepository.save(afiliado);
        return ResponseEntity.ok(nuevo);
    }
}
