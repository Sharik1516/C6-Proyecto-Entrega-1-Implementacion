package uniandes.edu.co.proyecto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniandes.edu.co.proyecto.modelo.OrdenDeServicio;
import uniandes.edu.co.proyecto.repositorio.OrdenDeServicioRepository;

@Service
public class RFC6Service {

    @Autowired
    private OrdenDeServicioRepository ordenDeServicioRepository;

    public boolean cambiarEstadoOrden(Integer idOrden, String nuevoEstado) {
        OrdenDeServicio orden = ordenDeServicioRepository.findById(idOrden).orElse(null);

        if (orden != null) {
            orden.setEstado(nuevoEstado);
            ordenDeServicioRepository.save(orden);
            return true;
        } else {
            return false;
        }
    }
}
