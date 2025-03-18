package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Contribuyente")
public class Contribuyente {

    @Id
    private Integer idContribuyente;

    @Column(nullable = false, length = 50)
    private String nombreEmpresa;

    @OneToOne
    @JoinColumn(name = "idContribuyente") // Mapea la PK como FK a Afiliado
    private Afiliado afiliado;

    public Contribuyente() {
        ;
    }

    public Contribuyente(Integer idContribuyente, String nombreEmpresa, Afiliado afiliado) {
        this.idContribuyente = idContribuyente;
        this.nombreEmpresa = nombreEmpresa;
        this.afiliado = afiliado;
    }

    public Integer getIdContribuyente() {
        return idContribuyente;
    }

    public void setIdContribuyente(Integer idContribuyente) {
        this.idContribuyente = idContribuyente;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public Afiliado getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(Afiliado afiliado) {
        this.afiliado = afiliado;
    }
}
