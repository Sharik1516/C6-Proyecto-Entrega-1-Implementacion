package uniandes.edu.co.proyecto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniandes.edu.co.proyecto.repositorio.CitaMedicaRepository;
import uniandes.edu.co.proyecto.modelo.CitaMedica;

@Service
public class RF8Service {

    @Autowired
    private CitaMedicaRepository citaMedicaRepository;

    public String cancelarCita(Integer idCita) {
        CitaMedica cita = citaMedicaRepository.findById(idCita).orElse(null);

        if (cita != null) {
            citaMedicaRepository.delete(cita);
            return "Cita médica cancelada exitosamente.";
        } else {
            return "Cita médica no encontrada.";
        }
    }
}
