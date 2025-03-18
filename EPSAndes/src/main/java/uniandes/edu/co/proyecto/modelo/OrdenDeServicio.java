package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Sirve
@Entity
@Table(name = "OrdenDeServicio")
public class OrdenDeServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idOrden;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private String estado;

    @ManyToOne
    @JoinColumn(name = "idAfiliado")
    private Afiliado afiliado;

    @ManyToOne
    @JoinColumn(name = "idMedico")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "idServicio")
    private IPSservicio servicio;

    public OrdenDeServicio() {}

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Afiliado getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(Afiliado afiliado) {
        this.afiliado = afiliado;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public IPSservicio getServicio() {
        return servicio;
    }

    public void setServicio(IPSservicio servicio) {
        this.servicio = servicio;
    }

    @Service
    public class OrdenServicioService {
        @Autowired
        private OrdenServicioRepository ordenServicioRepository;

        public OrdenServicio registrarOrden(OrdenServicio orden) {
            return ordenServicioRepository.save(orden);
        }
    }
}
