package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.CitaMedica;
import uniandes.edu.co.proyecto.repositorio.CitaMedicaRepository;

@Controller
public class CitaMedicaController {
    @Autowired
    private CitaMedicaRepository citaMedicaRepository;

    @GetMapping("/citasmedicas")
    public String citasmedicas(Model model) {
        model.addAttribute("citasmedicas", citaMedicaRepository.darCitasMedicas());
        return "citasmedicas";
    }
    
    @GetMapping("/citasmedicas/new")
    public String citamedicaform(Model model) {
        model.addAttribute("citaMedica", new CitaMedica());
        return "citaMedicaNuevo";
    }

    @PostMapping("/citasmedicas/new/save")
    public String citamedicaGuardar(@ModelAttribute CitaMedica citaMedica) {
        citaMedicaRepository.insertarCitaMedica(citaMedica.getFechaHora(), citaMedica.getIdOrden(), citaMedica.getNIT());
        return "redirect:/citasmedicas";
    }
    
    @GetMapping("/citasmedicas/{id}/edit")
    public String citamedicaEditarForm(@PathVariable("id") int id, Model model) {
        CitaMedica citaMedica = citaMedicaRepository.darCitaMedica(id);
        if(citaMedica != null) {
            model.addAttribute("citaMedica", citaMedica);
            return "citaMedicaEditar";
        }else {
            return "redirect:/citasmedicas";
        }
        
    }

    @PostMapping("/citasmedicas/{id}/edit/save")
    public String citamedicaEditarGuardar(@PathVariable("id") int id, @ModelAttribute CitaMedica citaMedica) {
        citaMedicaRepository.actualizarCitaMedica(id, citaMedica.getFechaHora(), citaMedica.getIdOrden(), citaMedica.getNIT());
        return "redirect:/citasmedicas";
    }

    @GetMapping("/citasmedicas/{id}/delete")
    public String citamedicaEliminar(@PathVariable("id") int id) {
        citaMedicaRepository.eliminarCitaMedica(id);
        return "redirect:/citasmedicas";
    }
}
