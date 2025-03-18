package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "AfiliadoBeneficiario")
public class AfiliadoBeneficiario {

    @Id
    @ManyToOne
    @JoinColumn(name = "idAfiliado", nullable = false)
    private Afiliado afiliado;

    @Id
    @ManyToOne
    @JoinColumn(name = "idBeneficiario", nullable = false)
    private Beneficiario beneficiario;

    public AfiliadoBeneficiario() {
        ;
    }

    public AfiliadoBeneficiario(Afiliado afiliado, Beneficiario beneficiario) {
        this.afiliado = afiliado;
        this.beneficiario = beneficiario;
    }

    public Afiliado getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(Afiliado afiliado) {
        this.afiliado = afiliado;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }
}
