package uniandes.edu.co.proyecto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import uniandes.edu.co.proyecto.modelo.Prestaciones;
import uniandes.edu.co.proyecto.repositorio.PrestacionesRepository;
import uniandes.edu.co.proyecto.repositorio.ServicioRepository;

public class RFC3Service {
    @Autowired
    private PrestacionesRepository prestacionesRepository;

    @Autowired
    private ServicioRepository servicioRepository;
    
    @GetMapping("/servicios/indice")
    public String prestaciones(Model model, @ModelAttribute Prestaciones prestacion) {
        var prestaciones = prestacionesRepository.darPrestacionesFecha(prestacion.getFechaInicio(), prestacion.getFechaFinal());
        long totalServiciosDistintos = prestaciones.stream()
            .map(Prestaciones::getIdServicio)
            .distinct()
            .count();
        long totalServiciosDisponibles = servicioRepository.darServicios().size();
        model.addAttribute("serviciosIndice", totalServiciosDisponibles/totalServiciosDistintos);
        return "serviciosIndice";
    }
}
