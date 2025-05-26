package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "ContribuyenteBeneficiario")
public class ContribuyenteBeneficiario {

    @EmbeddedId
    private ContribuyenteBeneficiarioPK pk;

    @ManyToOne
    @JoinColumn(name = "idParentesco")
    private Parentesco idParentesco;

    public ContribuyenteBeneficiario() {}

    public ContribuyenteBeneficiario(Afiliado beneficiario, Afiliado contribuyente, Parentesco parentesco) {
        this.pk = new ContribuyenteBeneficiarioPK(beneficiario, contribuyente);
        this.idParentesco = parentesco;
    }

    public ContribuyenteBeneficiarioPK getPk() {
        return pk;
    }

    public void setPk(ContribuyenteBeneficiarioPK pk) {
        this.pk = pk;
    }

    public Parentesco getIdParentesco() {
        return idParentesco;
    }

    public void setIdParentesco(Parentesco idParentesco) {
        this.idParentesco = idParentesco;
    }

}
