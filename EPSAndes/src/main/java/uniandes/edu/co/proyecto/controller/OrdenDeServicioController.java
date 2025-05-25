package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.OrdenDeServicio;
import uniandes.edu.co.proyecto.repositorio.OrdenDeServicioRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenDeServicioController {

    @Autowired
    private OrdenDeServicioRepository ordenRepository;

    @GetMapping
    public List<OrdenDeServicio> getAll() {
        return ordenRepository.findAll();
    }

 @GetMapping("/{id}")
public Optional<OrdenDeServicio> getById(@PathVariable String id) {
    return ordenRepository.findById(id);
}

    @PostMapping
    public OrdenDeServicio create(@RequestBody OrdenDeServicio orden) {
        return ordenRepository.save(orden);
    }

    @PutMapping("/{id}")
    public OrdenDeServicio update(@PathVariable String id, @RequestBody OrdenDeServicio nuevaOrden) {
        nuevaOrden.setId(id);
        return ordenRepository.save(nuevaOrden);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        ordenRepository.deleteById(id);
    }
}
