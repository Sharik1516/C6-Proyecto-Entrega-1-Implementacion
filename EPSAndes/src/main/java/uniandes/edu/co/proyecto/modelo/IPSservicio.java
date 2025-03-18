package uniandes.edu.co.proyecto.modelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "IPSservicio")
public class IPSservicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idServicio;

    public IPSservicio() {}

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }
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
}
