package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Parentesco;
import uniandes.edu.co.proyecto.repositorio.ParentescoRepository;

@Controller
public class ParentescoController {
    
    @Autowired
    private ParentescoRepository parentescoRepository;

    @GetMapping("/parentescos")
    public String parentescos(Model model) {
        model.addAttribute("parentescos", parentescoRepository.darParentescos());
        return "parentescos";
    }
    
    @GetMapping("/parentescos/new")
    public String parentescoform(Model model) {
        model.addAttribute("parentesco", new Parentesco());
        return "parentescoNuevo";
    }

    @PostMapping("/parentescos/new/save")
    public String parentescoGuardar(@ModelAttribute Parentesco parentesco) {
        parentescoRepository.insertarParentesco(parentesco.getDescripcion());
        return "redirect:/parentescos";
    }
    
    @GetMapping("/parentescos/{id}/edit")
    public String parentescoEditarForm(@PathVariable("id") int id, Model model) {
        Parentesco parentesco = parentescoRepository.darParentesco(id);
        if(parentesco != null) {
            model.addAttribute("parentesco", parentesco);
            return "parentescoEditar";
        }else {
            return "redirect:/parentescos";
        }
        
    }

    @PostMapping("/parentescos/{id}/edit/save")
    public String parentescoEditarGuardar(@PathVariable("id") int id, @ModelAttribute Parentesco parentesco) {
        parentescoRepository.actualizarParentesco(id, parentesco.getDescripcion());
        return "redirect:/parentescos";
    }

    @GetMapping("/parentescos/{id}/delete")
    public String parentescoEliminar(@PathVariable("id") int id) {
        parentescoRepository.eliminarParentesco(id);
        return "redirect:/parentescos";
    }
}
