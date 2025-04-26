package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "IPSservicio")
public class IPSservicio {
    @EmbeddedId
    private IPSservicioPK pk;

    public IPSservicio() {;}

    public IPSservicio(Servicio idServicio, IPS NIT) {
        this.pk = new IPSservicioPK(idServicio, NIT);
    }

    public IPSservicioPK getPk() {
        return pk;
    }

    public void setPk(IPSservicioPK pk) {
        this.pk = pk;
    }

    
/* 
    @Service
    public class IPSService {
        @Autowired
        private IPSRepository ipsRepository;
        @Autowired
        private ServicioSaludRepository servicioSaludRepository;

        public void asignarServicioAIPS(Long ipsId, Long servicioId) {
            IPS ips = ipsRepository.findById(ipsId)
                    .orElseThrow(() -> new RuntimeException("IPS no encontrada"));
            ServicioSalud servicio = servicioSaludRepository.findById(servicioId)
                    .orElseThrow(() -> new RuntimeException("Servicio de salud no encontrado"));

            ips.getServicios().add(servicio);
            ipsRepository.save(ips);
        }
    }
        */
}
