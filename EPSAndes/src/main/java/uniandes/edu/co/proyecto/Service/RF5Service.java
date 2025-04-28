package uniandes.edu.co.proyecto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.repositorio.ServicioRepository;

@RestController
public class RF5Service {

    @Autowired
    private ServicioRepository servicioRepository;

    @PostMapping("/servicios/registrar")
    public Servicio registrarServicio(@RequestBody Servicio servicio) {
        return servicioRepository.save(servicio);
    }
}
