package uniandes.edu.co.proyecto.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import uniandes.edu.co.proyecto.repositorio.PrestacionesRepository;

public class RFC2Service {
    @Autowired
    private PrestacionesRepository prestacionesRepository;
    
    @GetMapping("/prestaciones/porFecha")
    public String prestaciones(Model model) {
        var prestaciones = prestacionesRepository.darPrestacionesFecha();
        if (prestaciones.size() <= 20) {
            model.addAttribute("prestacionesFecha", prestaciones);
        } else {
            model.addAttribute("prestacionesFecha", new ArrayList<>(prestaciones).subList(0, 20));
        }
        return "prestacionesFecha";
    }
}
