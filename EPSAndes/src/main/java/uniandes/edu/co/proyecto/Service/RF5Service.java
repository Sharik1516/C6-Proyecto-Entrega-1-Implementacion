package uniandes.edu.co.proyecto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.Afiliado;
import uniandes.edu.co.proyecto.repositorio.AfiliadoRepository;

@RestController
@RequestMapping("/api/afiliados")
public class RF5Service {

    @Autowired
    private AfiliadoRepository afiliadoRepository;

    @PostMapping("/registrar")
    public Afiliado registrarAfiliado(@RequestBody Afiliado afiliado) {
        return afiliadoRepository.save(afiliado);
    }
}
