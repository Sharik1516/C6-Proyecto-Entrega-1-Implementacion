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
// ERROR en RFC1:
// El método findByFechaHoraBetween(Date, Date) no existe en PrestacionesRepository.
// Solución: Se debe crear un método en el PrestacionesRepository con la anotación @Query, o corregir el nombre del método
// de acuerdo al atributo real sobre el que se quiere buscar (por ejemplo, usando correctamente fechaHora si aplica).
        return prestacionesRepository.findByFechaHoraBetween(fechaActual, fechaFutura);
    }
}
