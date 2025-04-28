package uniandes.edu.co.proyecto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Medico;
import uniandes.edu.co.proyecto.repositorio.MedicoRepository;

@RestController
public class RF3Service {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping("/medicos/registrar")
    public Medico registrarMedico(@RequestBody Medico medico) {
        return medicoRepository.save(medico);
    }
}
