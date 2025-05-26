package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.IPS;
import uniandes.edu.co.proyecto.repositorio.IPSRepository;

import java.util.List;

@RestController
@RequestMapping("/ips")
public class IPSController {

    @Autowired
    private IPSRepository ipsRepository;

    @GetMapping
    public ResponseEntity<List<IPS>> obtenerIPS() {
        return ResponseEntity.ok(ipsRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<IPS> crearIPS(@RequestBody IPS ips) {
        IPS nueva = ipsRepository.save(ips);
        return ResponseEntity.ok(nueva);
    }
}
