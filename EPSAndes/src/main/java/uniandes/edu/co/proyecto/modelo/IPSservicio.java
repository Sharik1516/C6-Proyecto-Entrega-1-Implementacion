package uniandes.edu.co.proyecto.modelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "IPSservicio")
public class IPSservicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ManyToOne
    @JoinColumn(name = "idServicio")
    private Servicio idServicio;

    @ManyToOne
    @JoinColumn(name = "NIT")
    private IPS NIT;

    public IPSservicio() {;}

    public IPSservicio(IPS nIT) {
        NIT = nIT;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }
<<<<<<< HEAD

    public IPS getNIT() {
        return NIT;
    }

    public void setNIT(IPS nIT) {
        NIT = nIT;
    }

=======
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
>>>>>>> d22b9a153d2260b7e15b957fc03bb187a2fdf549
}
