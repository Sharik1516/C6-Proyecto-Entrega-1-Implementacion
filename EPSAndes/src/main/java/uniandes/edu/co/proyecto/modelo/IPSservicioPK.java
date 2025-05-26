package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class IPSservicioPK implements Serializable {

    private Long idServicio;
    private Integer nit;

    public IPSservicioPK() {
        // Constructor por defecto requerido por JPA
    }

    public IPSservicioPK(Long idServicio, Integer nit) {
        this.idServicio = idServicio;
        this.nit = nit;
    }

    public Long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }

    public Integer getNit() {
        return nit;
    }

    public void setNit(Integer nit) {
        this.nit = nit;
    }

    // Opcionalmente: equals() y hashCode() si vas a usar esta PK en operaciones de colección o JPA avanzadas

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IPSservicioPK)) return false;

        IPSservicioPK that = (IPSservicioPK) o;

        if (!idServicio.equals(that.idServicio)) return false;
        return nit.equals(that.nit);
    }

    @Override
    public int hashCode() {
        int result = idServicio.hashCode();
        result = 31 * result + nit.hashCode();
        return result;
    }
}
