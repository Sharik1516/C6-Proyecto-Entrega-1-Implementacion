package uniandes.edu.co.proyecto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.IPS;
import uniandes.edu.co.proyecto.repositorio.IPSRepository;

@RestController
public class RF1Service {

    @Autowired
    private IPSRepository ipsRepository;

    @PostMapping("/ips/registrar")
    public IPS registrarIPS(@RequestBody IPS ips) {
        return ipsRepository.save(ips);
    }
}
