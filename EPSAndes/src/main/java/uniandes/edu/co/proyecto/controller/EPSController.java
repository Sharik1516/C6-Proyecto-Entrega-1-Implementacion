package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.EPS;
import uniandes.edu.co.proyecto.repositorio.EPSRepository;

@Controller
public class EPSController {
    
    @Autowired
    private EPSRepository epsRepository;

    @GetMapping("/epses")
    public String epses(Model model) {
        model.addAttribute("epses", epsRepository.darEPSES());
        return "epses";
    }
    
    @GetMapping("/epses/new")
    public String epsform(Model model) {
        model.addAttribute("eps", new EPS());
        return "epsNuevo";
    }

    @PostMapping("/epses/new/save")
    public String epsGuardar(@ModelAttribute EPS eps) {
        epsRepository.insertarEPS(eps.getNombre(), eps.getTelefono(), eps.getDireccion());
        return "redirect:/epses";
    }
    
    @GetMapping("/epses/{id}/edit")
    public String epsEditarForm(@PathVariable("id") int id, Model model) {
        EPS eps = epsRepository.darEPS(id);
        if(eps != null) {
            model.addAttribute("eps", eps);
            return "epsEditar";
        }else {
            return "redirect:/epses";
        }
        
    }

    @PostMapping("/epses/{id}/edit/save")
    public String epsEditarGuardar(@PathVariable("id") int id, @ModelAttribute EPS eps) {
        epsRepository.actualizarEPS(id, eps.getNombre(), eps.getTelefono(), eps.getDireccion());
        return "redirect:/epses";
    }

    @GetMapping("/epses/{id}/delete")
    public String epsEliminar(@PathVariable("id") int id) {
        epsRepository.eliminarEPS(id);
        return "redirect:/epses";
    }
}
