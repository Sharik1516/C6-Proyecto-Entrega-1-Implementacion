package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.Prestaciones;
import uniandes.edu.co.proyecto.repositorio.PrestacionesRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/prestaciones")
public class PrestacionesController {

    @Autowired
    private PrestacionesRepository prestacionesRepository;

    @GetMapping
    public List<Prestaciones> getAll() {
        return prestacionesRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Prestaciones> getById(@PathVariable String id) {
        return prestacionesRepository.findById(id);
    }

    @PostMapping
    public Prestaciones create(@RequestBody Prestaciones prestacion) {
        return prestacionesRepository.save(prestacion);
    }

    @PutMapping("/{id}")
    public Prestaciones update(@PathVariable String id, @RequestBody Prestaciones nueva) {
        nueva.setId(id);
        return prestacionesRepository.save(nueva);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        prestacionesRepository.deleteById(id);
    }
}
