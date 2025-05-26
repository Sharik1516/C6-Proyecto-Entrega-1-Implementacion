package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.OrdenDeServicio;
import uniandes.edu.co.proyecto.repositorio.OrdenDeServicioRepository;

import java.util.List;

@RestController
@RequestMapping("/ordenes")
public class OrdenDeServicioController {


    @Autowired
    private OrdenDeServicioRepository ordenRepository;
    private OrdenDeServicioRepository ordenRepository;

    @GetMapping
    public ResponseEntity<List<OrdenDeServicio>> obtenerOrdenes() {
        return ResponseEntity.ok(ordenRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<OrdenDeServicio> crearOrden(@RequestBody OrdenDeServicio orden) {
        OrdenDeServicio nueva = ordenRepository.save(orden);
        return ResponseEntity.ok(nueva);
    }
}
