package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import uniandes.edu.co.proyecto.modelo.Afiliado;
import uniandes.edu.co.proyecto.repositorio.AfiliadoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class AfiliadoController {

    @Autowired
    private AfiliadoRepository afiliadoRepository;

    @GetMapping("/afiliados")
    public String afiliados(Model model) {
        model.addAttribute("afiliados", afiliadoRepository.darAfiliados());
        return "afiliados";
    }
    
    @GetMapping("/afiliados/new")
    public String afiliadoform(Model model) {
        model.addAttribute("afiliado", new Afiliado());
        return "afiliadoNuevo";
    }

    @PostMapping("/afiliados/new/save")
    public String afiliadoGuardar(@ModelAttribute Afiliado afiliado) {
        afiliadoRepository.insertarAfiliado(afiliado.getFechaNacimiento(), afiliado.getTipoAfiliado(), 
        afiliado.getTelefono(), afiliado.getDireccion(), afiliado.getIdUsuario());
        return "redirect:/afiliados";
    }
    
    @GetMapping("/afiliados/{id}/edit")
    public String afiliadoEditarForm(@PathVariable("id") int id, Model model) {
        Afiliado afiliado = afiliadoRepository.darAfiliado(id);
        if(afiliado != null) {
            model.addAttribute("afiliado", afiliado);
            return "afiliadoEditar";
        }else {
            return "redirect:/afiliados";
        }
        
    }

    @PostMapping("/afiliados/{id}/edit/save")
    public String afiliadoEditarGuardar(@PathVariable("id") int id, @ModelAttribute Afiliado afiliado) {
        afiliadoRepository.actualizarAfiliado(id, afiliado.getFechaNacimiento(), afiliado.getTipoAfiliado(), afiliado.getTelefono(), afiliado.getDireccion(), afiliado.getIdUsuario());
        return "redirect:/afiliados";
    }

    @GetMapping("/afiliados/{id}/delete")
    public String afiliadoEliminar(@PathVariable("id") int id) {
        afiliadoRepository.eliminarAfiliado(id);
        return "redirect:/afiliados";
    }
}
