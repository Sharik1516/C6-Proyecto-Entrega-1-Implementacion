package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.ContribuyenteBeneficiario;
import uniandes.edu.co.proyecto.modelo.ContribuyenteBeneficiarioPK;
import uniandes.edu.co.proyecto.repositorio.ContribuyenteBeneficiarioRepository;

@Controller
public class ContribuyenteBeneficiarioController {
    
    @Autowired
    private ContribuyenteBeneficiarioRepository contribuyenteBeneficiarioRepository;

    @GetMapping("/ContribuyentesBeneficiarios")
    public String contribuyentesbeneficiarios(Model model) {
        model.addAttribute("contribuyentesbeneficiarios", contribuyenteBeneficiarioRepository.darContribuyentesBeneficiarios());
        return "contribuyentesbeneficiarios";
    }
    
    @GetMapping("/ContribuyentesBeneficiarios/new")
    public String contribuyentebeneficiarioform(Model model) {
        model.addAttribute("contribuyentebeneficiario", new ContribuyenteBeneficiario());
        return "contribuyentebeneficiarioNuevo";
    }

    @PostMapping("/ContribuyentesBeneficiarios/new/save")
    public String contribuyentebeneficiarioGuardar(@ModelAttribute ContribuyenteBeneficiario contribuyenteBeneficiario) {
        contribuyenteBeneficiarioRepository.insertarContribuyenteBeneficiario(contribuyenteBeneficiario.getIdParentesco());
        return "redirect:/ContribuyentesBeneficiarios";
    }
    
    @GetMapping("/ContribuyentesBeneficiarios/{id}/edit")
    public String contribuyentebeneficiarioEditarForm(@PathVariable("id") ContribuyenteBeneficiarioPK id, Model model) {
        ContribuyenteBeneficiario contribuyenteBeneficiario = contribuyenteBeneficiarioRepository.darContribuyenteBeneficiario(id);
        if(contribuyenteBeneficiario != null) {
            model.addAttribute("contribuyenteBeneficiario", contribuyenteBeneficiario);
            return "contribuyenteBeneficiarioEditar";
        }else {
            return "redirect:/ContribuyentesBeneficiarios";
        }
        
    }

    @PostMapping("/ContribuyentesBeneficiarios/{id}/edit/save")
    public String contribuyenteBeneficiarioEditarGuardar(@PathVariable("id") ContribuyenteBeneficiarioPK id, @ModelAttribute ContribuyenteBeneficiario contribuyenteBeneficiario) {
        contribuyenteBeneficiarioRepository.actualizarContribuyenteBeneficiario(id, contribuyenteBeneficiario.getIdParentesco());
        return "redirect:/ContribuyentesBeneficiarios";
    }

    @GetMapping("/ContribuyentesBeneficiarios/{id}/delete")
    public String contribuyenteBeneficiarioEliminar(@PathVariable("id") ContribuyenteBeneficiarioPK id) {
        contribuyenteBeneficiarioRepository.eliminarContribuyenteBeneficiario(id);
        return "redirect:/ContribuyentesBeneficiarios";
    }
}
