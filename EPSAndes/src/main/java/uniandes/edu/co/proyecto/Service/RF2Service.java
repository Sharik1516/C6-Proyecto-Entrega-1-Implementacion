package uniandes.edu.co.proyecto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Afiliado;
import uniandes.edu.co.proyecto.repositorio.AfiliadoRepository;

@RestController
public class RF2Service {

    @Autowired
    private AfiliadoRepository afiliadoRepository;

    @PostMapping("/afiliados/registrar")
    public Afiliado registrarAfiliado(@RequestBody Afiliado afiliado) {
        return afiliadoRepository.save(afiliado);
    }
}

