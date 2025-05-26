package uniandes.edu.co.proyecto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.IPS;
import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.modelo.IPSservicio;
import uniandes.edu.co.proyecto.repositorio.IPSRepository;
import uniandes.edu.co.proyecto.repositorio.ServicioRepository;
import uniandes.edu.co.proyecto.repositorio.IPSservicioRepository;

@Service
public class RF6Service {

    @Autowired
    private IPSRepository ipsRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private IPSservicioRepository ipsservicioRepository;

    @PostMapping("/ips/asignar-servicio")
    public String asignarServicioAIPS(@RequestParam String nit, @RequestParam String idServicio) {
        Integer nitInt = Integer.parseInt(nit);
        IPS ips = ipsRepository.findById(nitInt)
                .orElseThrow(() -> new RuntimeException("IPS no encontrada"));

        Integer idServicioInt = Integer.parseInt(idServicio);
        Servicio servicio = servicioRepository.findById(idServicioInt)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));

        IPSservicio ipsservicio = new IPSservicio();
        ipsservicio.setIdServicio(String.valueOf(servicio.getIdServicio()));
        ipsservicio.setNitIPS(String.valueOf(ips.getNIT()));
        ipsservicio.setActivo(true);
        ipsservicioRepository.save(ipsservicio);

        return "Servicio asignado correctamente a la IPS.";
    }
}


