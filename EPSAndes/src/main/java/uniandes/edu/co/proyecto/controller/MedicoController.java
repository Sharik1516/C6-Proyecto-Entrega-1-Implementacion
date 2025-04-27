package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Medico;
import uniandes.edu.co.proyecto.repositorio.MedicoRepository;

@Controller
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping("/medicos")
    public String medicos(Model model) {
        model.addAttribute("medicos", medicoRepository.darMedicos());
        return "medicos";
    }
    
    @GetMapping("/medicos/new")
    public String medicoform(Model model) {
        model.addAttribute("medico", new Medico());
        return "medicoNuevo";
    }

    @PostMapping("/medicos/new/save")
    public String medicoGuardar(@ModelAttribute Medico medico) {
        medicoRepository.insertarMedico(medico.getEspecialidad(), medico.getRegistroMedico(), medico.getIdEps(), medico.getIdUsuario());
        return "redirect:/medicos";
    }
    
    @GetMapping("/medicos/{id}/edit")
    public String medicoEditarForm(@PathVariable("id") int id, Model model) {
        Medico medico = medicoRepository.darMedico(id);
        if(medico != null) {
            model.addAttribute("medico", medico);
            return "medicoEditar";
        }else {
            return "redirect:/medicos";
        }
        
    }

    @PostMapping("/medicos/{id}/edit/save")
    public String medicoEditarGuardar(@PathVariable("id") int id, @ModelAttribute Medico medico) {
        medicoRepository.actualizarMedico(id, medico.getEspecialidad(), medico.getRegistroMedico(), medico.getIdEps(), medico.getIdUsuario());
        return "redirect:/medicos";
    }

    @GetMapping("/medicos/{id}/delete")
    public String medicoEliminar(@PathVariable("id") int id) {
        medicoRepository.eliminarMedico(id);
        return "redirect:/medicos";
    }
}
