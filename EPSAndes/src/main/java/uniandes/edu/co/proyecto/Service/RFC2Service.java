package uniandes.edu.co.proyecto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uniandes.edu.co.proyecto.modelo.Prestaciones;
import uniandes.edu.co.proyecto.repositorio.PrestacionesRepository;

import java.util.Date;
import java.util.List;

@Service
public class RFC2Service {

    @Autowired
    private PrestacionesRepository prestacionesRepository;

    public List<Prestaciones> obtenerPrestacionesEntreFechas(Date inicio, Date fin) {
        return prestacionesRepository.findByFechaInicioBetween(inicio, fin);
    }
}
