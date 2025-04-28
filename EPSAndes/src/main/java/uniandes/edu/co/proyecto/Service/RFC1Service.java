package uniandes.edu.co.proyecto.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniandes.edu.co.proyecto.repositorio.PrestacionesRepository;
import uniandes.edu.co.proyecto.modelo.Prestaciones;

@Service
public class RFC1Service {

    @Autowired
    private PrestacionesRepository prestacionesRepository;

    public List<Prestaciones> obtenerPrestacionesProximas() {
        Date fechaActual = new Date();
        long cuatroSemanasEnMilisegundos = 28L * 24L * 60L * 60L * 1000L; // 28 días
        Date fechaFutura = new Date(fechaActual.getTime() + cuatroSemanasEnMilisegundos);

        return prestacionesRepository.findByFechaHoraBetween(fechaActual, fechaFutura);
    }
}
