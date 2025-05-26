package uniandes.edu.co.proyecto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uniandes.edu.co.proyecto.modelo.OrdenDeServicio;
import uniandes.edu.co.proyecto.repositorio.OrdenDeServicioRepository;

import java.util.List;

@Service
public class RF4Service {

    @Autowired
    private OrdenDeServicioRepository repository;

    public OrdenDeServicio crearOrden(OrdenDeServicio orden) {
        return repository.save(orden);
    }

    public List<OrdenDeServicio> obtenerTodas() {
        return repository.findAll();
    }
}
