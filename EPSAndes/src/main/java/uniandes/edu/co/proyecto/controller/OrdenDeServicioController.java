package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import uniandes.edu.co.proyecto.modelo.OrdenDeServicio;
import uniandes.edu.co.proyecto.repositorio.OrdenDeServicioRepository;

@Controller
@RequestMapping( "/" )
public class OrdenDeServicioController {
    
    @Autowired
    private OrdenDeServicioRepository ordenDeServicioRepository;

    @GetMapping("/ordenesDeServicio")
    public String ordenesDeServicio(Model model) {
        model.addAttribute("ordenesDeServicio", ordenDeServicioRepository.darOrdenesDeServicio());
        return "ordenesDeServicio";
    }
    
    @GetMapping("/ordenesDeServicio/new")
    public String ordenDeServicioform(Model model) {
        model.addAttribute("ordenDeServicio", new OrdenDeServicio());
        return "ordenDeServicioNuevo";
    }

    @PostMapping("/ordenesDeServicio/new/save")
    public String ordenDeServicioGuardar(@ModelAttribute OrdenDeServicio ordenDeServicio) {
        ordenDeServicioRepository.insertarOrdenDeServicio(ordenDeServicio.getFecha(), ordenDeServicio.getEstado(), ordenDeServicio.getIdAfiliado(), ordenDeServicio.getIdMedico());
        return "redirect:/ordenesDeServicio";
    }
    
    @GetMapping("/ordenesDeServicio/{id}/edit")
    public String ordenDeServicioEditarForm(@PathVariable("id") int id, Model model) {
        OrdenDeServicio ordenDeServicio = ordenDeServicioRepository.darOrdenDeServicio(id);
        if(ordenDeServicio != null) {
            model.addAttribute("ordenDeServicio", ordenDeServicio);
            return "ordenDeServicioEditar";
        }else {
            return "redirect:/ordenesDeServicio";
        }
        
    }

    @PostMapping("/ordenesDeServicio/{id}/edit/save")
    public String ordenDeServicioEditarGuardar(@PathVariable("id") int id, @ModelAttribute OrdenDeServicio ordenDeServicio) {
        ordenDeServicioRepository.actualizarOrdenDeServicio(id, ordenDeServicio.getFecha(), ordenDeServicio.getEstado(), ordenDeServicio.getIdAfiliado(), ordenDeServicio.getIdMedico());
        return "redirect:/ordenesDeServicio";
    }

    @GetMapping("/ordenesDeServicio/{id}/delete")
    public String ordenDeServicioEliminar(@PathVariable("id") int id) {
        ordenDeServicioRepository.eliminarOrdenDeServicio(id);
        return "redirect:/ordenesDeServicio";
    }
}
