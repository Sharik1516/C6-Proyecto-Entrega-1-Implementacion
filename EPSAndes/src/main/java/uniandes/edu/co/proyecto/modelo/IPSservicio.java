package uniandes.edu.co.proyecto.modelo;

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

    public IPS getNIT() {
        return NIT;
    }

    public void setNIT(IPS nIT) {
        NIT = nIT;
    }

}
