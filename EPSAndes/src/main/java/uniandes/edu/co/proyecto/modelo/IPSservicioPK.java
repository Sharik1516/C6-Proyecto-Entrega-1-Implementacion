package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class IPSservicioPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "idServicio", referencedColumnName = "idServicio")
    private Servicio idServicio;

    @ManyToOne
    @JoinColumn(name = "NIT", referencedColumnName = "NIT")
    private IPS NIT;

    public IPSservicioPK(Servicio idServicio, IPS NIT) {
        super();
        this.idServicio = idServicio;
        this.NIT = NIT;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    public void setNIT(IPS NIT) {
        this.NIT = NIT;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public IPS getNIT() {
        return NIT;
    }
    
}