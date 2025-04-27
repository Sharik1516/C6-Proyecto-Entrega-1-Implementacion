package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.IPS;
import uniandes.edu.co.proyecto.repositorio.IPSRepository;

@Controller
public class IPSController {
    
    @Autowired
    private IPSRepository ipsRepository;

    @GetMapping("/ipses")
    public String ipses(Model model) {
        model.addAttribute("ipses", ipsRepository.darIPSES());
        return "ipses";
    }
    
    @GetMapping("/ipses/new")
    public String ipsform(Model model) {
        model.addAttribute("ips", new IPS());
        return "ipsNuevo";
    }

    @PostMapping("/ipses/new/save")
    public String ipsGuardar(@ModelAttribute IPS ips) {
        ipsRepository.insertarIPS(ips.getNombre(), ips.getTelefono(), ips.getDireccion(), ips.getIdEps());
        return "redirect:/ipses";
    }
    
    @GetMapping("/ipses/{id}/edit")
    public String ipsEditarForm(@PathVariable("id") int id, Model model) {
        IPS ips = ipsRepository.darIPS(id);
        if(ips != null) {
            model.addAttribute("ips", ips);
            return "ipsEditar";
        }else {
            return "redirect:/ipses";
        }
        
    }

    @PostMapping("/ipses/{id}/edit/save")
    public String ipsEditarGuardar(@PathVariable("id") int id, @ModelAttribute IPS ips) {
        ipsRepository.actualizarIPS(id, ips.getNombre(), ips.getTelefono(), ips.getDireccion(), ips.getIdEps());
        return "redirect:/ipses";
    }

    @GetMapping("/ipses/{id}/delete")
    public String ipsEliminar(@PathVariable("id") int id) {
        ipsRepository.eliminarIPS(id);
        return "redirect:/ipses";
    }
}
