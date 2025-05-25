package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.IPSservicio;
import uniandes.edu.co.proyecto.repositorio.IPSservicioRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ips-servicios")
public class IPSservicioController {

    @Autowired
    private IPSservicioRepository ipsservicioRepository;

    @GetMapping
    public List<IPSservicio> getAll() {
        return ipsservicioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<IPSservicio> getById(@PathVariable String id) {
        return ipsservicioRepository.findById(id);
    }

    @PostMapping
    public IPSservicio create(@RequestBody IPSservicio ipsservicio) {
        return ipsservicioRepository.save(ipsservicio);
    }

    @PutMapping("/{id}")
    public IPSservicio update(@PathVariable String id, @RequestBody IPSservicio updated) {
        updated.setId(id);
        return ipsservicioRepository.save(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        ipsservicioRepository.deleteById(id);
    }
}
