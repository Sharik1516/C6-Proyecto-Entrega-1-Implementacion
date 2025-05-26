package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "ordenes_servicio")
public class OrdenDeServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idOrden;

    private Date fecha;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_afiliado")
    private Afiliado afiliado;

    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;

    public OrdenDeServicio() {}

    public OrdenDeServicio(Date fecha, String estado, Afiliado afiliado, Medico medico) {
        this.fecha = fecha;
        this.estado = estado;
        this.afiliado = afiliado;
        this.medico = medico;
    }

    public Long getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Long idOrden) {
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
}
