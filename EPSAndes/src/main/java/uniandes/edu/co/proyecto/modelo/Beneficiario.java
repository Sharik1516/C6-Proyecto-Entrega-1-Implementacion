package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Beneficiario")
public class Beneficiario {

    @Id
    private Integer idBeneficiario;

    @Column(nullable = false)
    private String parentesco;

    @OneToOne
    @JoinColumn(name = "idBeneficiario") // Mapea la PK como FK a Afiliado
    private Afiliado afiliado;

    @ManyToOne
    @JoinColumn(name = "idContribuyente", nullable = false)
    private Contribuyente contribuyente;

    public Beneficiario() {
        ;
    }

    public Beneficiario(Integer idBeneficiario, String parentesco, Afiliado afiliado, Contribuyente contribuyente) {
        this.idBeneficiario = idBeneficiario;
        this.parentesco = parentesco;
        this.afiliado = afiliado;
        this.contribuyente = contribuyente;
    }

    public Integer getIdBeneficiario() {
        return idBeneficiario;
    }

    public void setIdBeneficiario(Integer idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public Afiliado getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(Afiliado afiliado) {
        this.afiliado = afiliado;
    }

    public Contribuyente getContribuyente() {
        return contribuyente;
    }

    public void setContribuyente(Contribuyente contribuyente) {
        this.contribuyente = contribuyente;
    }
}
