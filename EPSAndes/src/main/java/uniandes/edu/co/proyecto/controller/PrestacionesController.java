package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Prestaciones;
import uniandes.edu.co.proyecto.repositorio.PrestacionesRepository;

@Controller
public class PrestacionesController {
    
    @Autowired
    private PrestacionesRepository prestacionesRepository;

    @GetMapping("/prestaciones")
    public String prestaciones(Model model) {
        model.addAttribute("prestaciones", prestacionesRepository.darPrestaciones());
        return "prestaciones";
    }
    
    @GetMapping("/prestaciones/new")
    public String prestacionform(Model model) {
        model.addAttribute("prestacion", new Prestaciones());
        return "prestacionNuevo";
    }

    @PostMapping("/prestaciones/new/save")
    public String prestacionGuardar(@ModelAttribute Prestaciones prestacion) {
        prestacionesRepository.insertarPrestacion(prestacion.getIdCita(), prestacion.getIdServicio(), prestacion.getFechaHora());
        return "redirect:/prestaciones";
    }
    
    @GetMapping("/prestaciones/{id}/edit")
    public String prestacionEditarForm(@PathVariable("id") int id, Model model) {
        Prestaciones prestacion = prestacionesRepository.darPrestacion(id);
        if(prestacion != null) {
            model.addAttribute("prestacion", prestacion);
            return "prestacionEditar";
        }else {
            return "redirect:/prestaciones";
        }
        
    }

    @PostMapping("/prestaciones/{id}/edit/save")
    public String prestacionEditarGuardar(@PathVariable("id") int id, @ModelAttribute Prestaciones prestacion) {
        prestacionesRepository.actualizarPrestacion(id, prestacion.getIdCita(), prestacion.getIdServicio(), prestacion.getFechaHora());
        return "redirect:/prestaciones";
    }

    @GetMapping("/prestaciones/{id}/delete")
    public String prestacionEliminar(@PathVariable("id") int id) {
        prestacionesRepository.eliminarPrestacion(id);
        return "redirect:/prestaciones";
    }
}
