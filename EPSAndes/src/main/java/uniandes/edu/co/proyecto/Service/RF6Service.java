package uniandes.edu.co.proyecto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.repositorio.IPSRepository;
import uniandes.edu.co.proyecto.repositorio.ServicioRepository;
import uniandes.edu.co.proyecto.repositorio.IPSservicioRepository;
import uniandes.edu.co.proyecto.modelo.IPS;
import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.modelo.IPSservicio;

@Service
public class RF6Service {

    @Autowired
    private IPSRepository ipsRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private IPSservicioRepository ipsservicioRepository;

    @PostMapping("/ips/asignar-servicio")
    public String asignarServicioAIPS(@RequestParam Integer nit, @RequestParam Integer idServicio) {

        IPS ips = ipsRepository.findById(nit)
                .orElseThrow(() -> new RuntimeException("IPS no encontrada"));

        Servicio servicio = servicioRepository.findById(idServicio)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));
//IPSservicio(servicio,IPS) no esta definida y tocaria hacerlo
        IPSservicio ipsservicio = new IPSservicio(servicio, ips);

        ipsservicioRepository.save(ipsservicio);

        return "Servicio asignado correctamente a la IPS.";
    }
}
