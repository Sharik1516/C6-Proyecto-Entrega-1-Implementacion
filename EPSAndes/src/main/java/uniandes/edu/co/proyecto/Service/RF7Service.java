package uniandes.edu.co.proyecto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.CitaMedica;
import uniandes.edu.co.proyecto.modelo.OrdenDeServicio;
import uniandes.edu.co.proyecto.modelo.IPS;
import uniandes.edu.co.proyecto.repositorio.CitaMedicaRepository;
import uniandes.edu.co.proyecto.repositorio.OrdenDeServicioRepository;
import uniandes.edu.co.proyecto.repositorio.IPSRepository;

import java.util.Date;

@Service
public class RF7Service {

    @Autowired
    private CitaMedicaRepository citaMedicaRepository;

    @Autowired
    private OrdenDeServicioRepository ordenDeServicioRepository;

    @Autowired
    private IPSRepository ipsRepository;

    @PostMapping("/citas/agendar")
    public String agendarCitaMedica(
            @RequestParam String idOrden,
            @RequestParam String nitIPS,
            @RequestParam Date fechaHora) {

        OrdenDeServicio orden = ordenDeServicioRepository.findById(idOrden)
                .orElseThrow(() -> new RuntimeException("Orden de servicio no encontrada"));

        IPS ips = ipsRepository.findById(Integer.parseInt(nitIPS))
                .orElseThrow(() -> new RuntimeException("IPS no encontrada"));

        CitaMedica cita = new CitaMedica();
        cita.setFechaHora(new java.sql.Date(fechaHora.getTime()));
        cita.setIdOrden(orden);
        cita.setNIT(ips);

        citaMedicaRepository.save(cita);

        return "Cita médica agendada correctamente.";
    }
}
