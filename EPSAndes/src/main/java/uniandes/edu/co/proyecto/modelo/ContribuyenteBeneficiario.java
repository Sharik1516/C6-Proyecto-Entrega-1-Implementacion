package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ContribuyenteBeneficiario")
public class ContribuyenteBeneficiario {

    @ManyToOne
    @JoinColumn(name = "idAfiliado")
    private Integer idBeneficiario;

    @ManyToOne
    @JoinColumn(name = "idAfiliado")
    private Integer idContribuyente;
    
    @ManyToOne
    @JoinColumn(name = "idParentesco")
    private Parentesco idParentesco;

    public ContribuyenteBeneficiario(Integer idBeneficiario, Integer idContribuyente, Parentesco idParentesco) {
        this.idBeneficiario = idBeneficiario;
        this.idContribuyente = idContribuyente;
        this.idParentesco = idParentesco;
    }

    public Integer getIdBeneficiario() {
        return idBeneficiario;
    }

    public void setIdBeneficiario(Integer idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
    }

    public Integer getIdContribuyente() {
        return idContribuyente;
    }

    public void setIdContribuyente(Integer idContribuyente) {
        this.idContribuyente = idContribuyente;
    }

    public Parentesco getIdParentesco() {
        return idParentesco;
    }

    public void setIdParentesco(Parentesco idParentesco) {
        this.idParentesco = idParentesco;
    }
    

}
