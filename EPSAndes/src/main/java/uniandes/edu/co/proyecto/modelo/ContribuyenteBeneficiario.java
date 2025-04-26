package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ContribuyenteBeneficiario")
public class ContribuyenteBeneficiario {

    @EmbeddedId
    private ContribuyenteBeneficiarioPK pk;
    
    @ManyToOne
    @JoinColumn(name = "idParentesco")
    private Parentesco idParentesco;

    public ContribuyenteBeneficiario(Afiliado idBeneficiario, Afiliado idContribuyente, Parentesco idParentesco) {
        this.pk = new ContribuyenteBeneficiarioPK(idBeneficiario, idContribuyente);
        this.idParentesco = idParentesco;
    }

    public ContribuyenteBeneficiario() {;}

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
