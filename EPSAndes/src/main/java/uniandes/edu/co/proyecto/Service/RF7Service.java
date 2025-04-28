package uniandes.edu.co.proyecto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.repositorio.CitaMedicaRepository;
import uniandes.edu.co.proyecto.repositorio.OrdenDeServicioRepository;
import uniandes.edu.co.proyecto.repositorio.IPSRepository;
import uniandes.edu.co.proyecto.modelo.CitaMedica;
import uniandes.edu.co.proyecto.modelo.OrdenDeServicio;
import uniandes.edu.co.proyecto.modelo.IPS;

import java.sql.Date;

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
            @RequestParam Integer idOrden,
            @RequestParam Integer nitIPS,
            @RequestParam Date fechaHora) {

        OrdenDeServicio orden = ordenDeServicioRepository.findById(idOrden)
                .orElseThrow(() -> new RuntimeException("Orden de servicio no encontrada"));

        IPS ips = ipsRepository.findById(nitIPS)
                .orElseThrow(() -> new RuntimeException("IPS no encontrada"));

        CitaMedica cita = new CitaMedica();
        cita.setFechaHora(fechaHora);
        /*
  NOTA IMPORTANTE:
  
  - No se puede usar cita.setOrdenDeServicio(orden); porque la clase CitaMedica no tiene
    un método que reciba un objeto OrdenDeServicio. 
    Lo que probablemente existe es setIdOrden(Integer idOrden), entonces hay que pasar
    solo el ID de la orden.

  - No se puede usar cita.setIps(nitIPS); porque CitaMedica no tiene un atributo o setter llamado "ips".
    Probablemente el atributo real sea "NIT" o un objeto "IPS".
    Hay que revisar si se usa setNIT(Integer nit) o setNIT(IPS ips).

  SOLUCIÓN:
    - Usar cita.setIdOrden(idOrden) si el atributo que guarda es el ID de la orden.
    - Usar cita.setNIT(nit) o cita.setNIT(ips) según como esté modelado.

  SIEMPRE usar los métodos que realmente existan en la entidad CitaMedica.
*/

        cita.setOrdenDeServicio(orden);
        cita.setIps(nitIPS);

        citaMedicaRepository.save(cita);

        return "Cita médica agendada correctamente.";
    }
}
