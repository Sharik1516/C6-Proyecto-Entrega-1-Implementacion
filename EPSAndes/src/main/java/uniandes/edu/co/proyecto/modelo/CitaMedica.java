package uniandes.edu.co.proyecto.modelo;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "CitaMedica")
public class CitaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCita;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;

    @ManyToOne
    @JoinColumn(name = "idOrden")
    private OrdenDeServicio orden;

    @ManyToOne
    @JoinColumn(name = "idServicio")
    private IPSservicio servicio;

    public CitaMedica() {}

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public OrdenDeServicio getOrden() {
        return orden;
    }

    public void setOrden(OrdenDeServicio orden) {
        this.orden = orden;
    }

    public IPSservicio getServicio() {
        return servicio;
    }

    public void setServicio(IPSservicio servicio) {
        this.servicio = servicio;
    }
    @Service
    public class CitaMedicaService {
        @Autowired
        private CitaMedicaRepository citaMedicaRepository;
        @Autowired
        private OrdenServicioRepository ordenServicioRepository;
        @Autowired
        private IPSRepository ipsRepository;

        public CitaMedica agendarCita(Long ordenId, Long ipsId, LocalDateTime fechaHora) {
            OrdenServicio orden = ordenServicioRepository.findById(ordenId)
                    .orElseThrow(() -> new RuntimeException("Orden de servicio no encontrada"));
            IPS ips = ipsRepository.findById(ipsId)
                    .orElseThrow(() -> new RuntimeException("IPS no encontrada"));

            CitaMedica cita = new CitaMedica();
            cita.setOrden(orden);
            cita.setIps(ips);
            cita.setFechaHora(fechaHora);

            return citaMedicaRepository.save(cita);
        }
    }
    @Service
    public class CitaMedicaServiceRF8 {
        @Autowired
        private CitaMedicaRepository citaMedicaRepository;
        @Autowired
        private AfiliadoRepository afiliadoRepository;

        public List<CitaMedica> obtenerCitasPorAfiliado(Long afiliadoId) {
            Afiliado afiliado = afiliadoRepository.findById(afiliadoId)
                    .orElseThrow(() -> new RuntimeException("Afiliado no encontrado"));

            return citaMedicaRepository.findByOrden_Afiliado(afiliado);
        }
    }
}
