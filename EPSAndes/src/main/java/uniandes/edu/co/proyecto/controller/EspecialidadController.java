package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Especialidad;
import uniandes.edu.co.proyecto.repositorio.EspecialidadRepository;

@Controller
public class EspecialidadController {
    
    @Autowired
    private EspecialidadRepository especialidadRepository;

    @GetMapping("/especialidades")
    public String especialidad(Model model) {
        model.addAttribute("especialidades", especialidadRepository.darEspecialidades());
        return "especialidades";
    }
    
    @GetMapping("/especialidades/new")
    public String especialidadesform(Model model) {
        model.addAttribute("especialidad", new Especialidad());
        return "especialidadNuevo";
    }

    @PostMapping("/especialidades/new/save")
    public String especialidadGuardar(@ModelAttribute Especialidad especialidad) {
        especialidadRepository.insertarEspecialidad(especialidad.getNombre());
        return "redirect:/especialidades";
    }
    
    @GetMapping("/especialidades/{id}/edit")
    public String especialidadEditarForm(@PathVariable("id") int id, Model model) {
        Especialidad especialidad = especialidadRepository.darEspecialidad(id);
        if(especialidad != null) {
            model.addAttribute("especialidad", especialidad);
            return "especialidadEditar";
        }else {
            return "redirect:/especialidades";
        }
        
    }

    @PostMapping("/especialidades/{id}/edit/save")
    public String especialidadEditarGuardar(@PathVariable("id") int id, @ModelAttribute Especialidad especialidad) {
        especialidadRepository.actualizarEspecialidad(id, especialidad.getNombre());
        return "redirect:/especialidades";
    }

    @GetMapping("/especialidades/{id}/delete")
    public String especialidadEliminar(@PathVariable("id") int id) {
        especialidadRepository.eliminarEspecialidad(id);
        return "redirect:/especialidades";
    }
}
