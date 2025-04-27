package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;
import java.sql.Date;

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
    private Afiliado idAfiliado;

    @ManyToOne
    @JoinColumn(name = "idMedico")
    private Medico idMedico;

    public OrdenDeServicio(Integer idOrden, Date fecha, String estado, Afiliado idAfiliado, Medico idMedico) {
        this.idOrden = idOrden;
        this.fecha = fecha;
        this.estado = estado;
        this.idAfiliado = idAfiliado;
        this.idMedico = idMedico;
    }

    public OrdenDeServicio() {;}

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

    public Afiliado getIdAfiliado() {
        return idAfiliado;
    }

    public void setIdAfiliado(Afiliado idAfiliado) {
        this.idAfiliado = idAfiliado;
    }

    public Medico getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Medico idMedico) {
        this.idMedico = idMedico;
    }

    /* 
    @Service
    public class OrdenServicioService {
        @Autowired
        private OrdenServicioRepository ordenServicioRepository;

        public OrdenServicio registrarOrden(OrdenServicio orden) {
            return ordenServicioRepository.save(orden);
        }
    }
        */
}
