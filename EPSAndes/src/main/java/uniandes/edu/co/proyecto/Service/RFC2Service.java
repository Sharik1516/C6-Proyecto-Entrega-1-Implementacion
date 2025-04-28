package uniandes.edu.co.proyecto.Service;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import uniandes.edu.co.proyecto.modelo.Prestaciones;
import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.repositorio.PrestacionesRepository;

public class RFC2Service {
    @Autowired
    private PrestacionesRepository prestacionesRepository;
    
    @GetMapping("/servicios/porFecha")
    public String prestaciones(Model model, @ModelAttribute Prestaciones prestacion) {
        var prestaciones = prestacionesRepository.darPrestacionesFecha(prestacion.getFechaInicio(), prestacion.getFechaFinal());
        Map<Servicio, Long> idServicioCount = prestaciones.stream()
            .collect(Collectors.groupingBy(Prestaciones::getIdServicio, Collectors.counting()));

        prestaciones = prestaciones.stream()
            .sorted((p1, p2) -> Long.compare(idServicioCount.get(p2.getIdServicio()), idServicioCount.get(p1.getIdServicio())))
            .distinct()
            .collect(Collectors.toList());

        if (prestaciones.size() <= 20) {
            model.addAttribute("serviciosFecha", prestaciones);
        } else {
            model.addAttribute("serviciosFecha", new ArrayList<>(prestaciones).subList(0, 20));
        }
        return "serviciosFecha";
    }
}
