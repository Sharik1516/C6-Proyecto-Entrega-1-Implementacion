package uniandes.edu.co.proyecto.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniandes.edu.co.proyecto.repositorio.CitaMedicaRepository;
import uniandes.edu.co.proyecto.modelo.CitaMedica;

@Service
public class RFC4Service {

    @Autowired
    private CitaMedicaRepository citaMedicaRepository;

    public List<CitaMedica> obtenerCitasPorAfiliadoYRangoFechas(Integer idAfiliado, Date fechaInicio, Date fechaFin) {
        return citaMedicaRepository.findByOrdenDeServicio_Afiliado_IdAfiliadoAndFechaHoraBetween(idAfiliado, fechaInicio, fechaFin);
    }
}
