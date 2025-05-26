package uniandes.edu.co.proyecto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.*;
import uniandes.edu.co.proyecto.repositorio.*;

@RestController
public class RF6Service {

    @Autowired
    private IPSRepository ipsRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private IPSservicioRepository ipsservicioRepository;

    @PostMapping("/ips/asignar-servicio")
    public String asignarServicioAIPS(@RequestParam String nit, @RequestParam String idServicio) {

        IPS ips = ipsRepository.darIPS(Long.parseLong(nit));

        if (ips == null) throw new RuntimeException("IPS no encontrada");

        Servicio servicio = servicioRepository.darServicio(Long.parseLong(idServicio));
        if (servicio == null) throw new RuntimeException("Servicio no encontrado");

        IPSservicio ipsServicio = new IPSservicio();
        ipsServicio.setPk(new IPSservicioPK(servicio.getIdServicio(), ips.getNIT()));
        ipsServicio.setServicio(servicio);
        ipsServicio.setIps(ips);
        ipsServicio.setAgenda("[]"); // o un arreglo vacio u otra logica

        ipsservicioRepository.save(ipsServicio);

        return "Servicio asignado correctamente a la IPS.";
    }
}
