package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.IPSservicio;
import uniandes.edu.co.proyecto.modelo.IPSservicioPK;
import uniandes.edu.co.proyecto.repositorio.IPSservicioRepository;

@Controller
public class IPSservicioController {
    
    @Autowired
    private IPSservicioRepository ipsservicioRepository;

    @GetMapping("/ipsservicios")
    public String ipsservicios(Model model) {
        model.addAttribute("ipsservicios", ipsservicioRepository.darIPSESservicio());
        return "ipsservicios";
    }
    
    @GetMapping("/ipsservicios/new")
    public String ipsservicioform(Model model) {
        model.addAttribute("ipsservicio", new IPSservicio());
        return "ipsservicioNuevo";
    }

    @PostMapping("/ipsservicios/new/save")
    public String ipsservicioGuardar(@ModelAttribute IPSservicio ipsservicio) {
        ipsservicioRepository.insertarIPSservicio();
        return "redirect:/ipsservicios";
    }
    
    @GetMapping("/ipsservicios/{id}/edit")
    public String ipsservicioEditarForm(@PathVariable("id") IPSservicioPK id, Model model) {
        IPSservicio ipsservicio = ipsservicioRepository.darIPSservicio(id);
        if(ipsservicio != null) {
            model.addAttribute("ipsservicio", ipsservicio);
            return "ipsservicioEditar";
        }else {
            return "redirect:/ipsservicios";
        }
        
    }

    @PostMapping("/ipsservicios/{id}/edit/save")
    public String ipsservicioEditarGuardar(@PathVariable("id") IPSservicioPK id, @ModelAttribute IPSservicio ipsservicio) {
        ipsservicioRepository.actualizarIPSservicio(id);
        return "redirect:/ipsservicios";
    }

    @GetMapping("/ipsservicios/{id}/delete")
    public String ipsservicioEliminar(@PathVariable("id") IPSservicioPK id) {
        ipsservicioRepository.eliminarIPSservicio(id);
        return "redirect:/ipsservicios";
    }
}
