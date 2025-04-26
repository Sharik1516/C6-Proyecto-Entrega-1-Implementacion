package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ContribuyenteBeneficiarioPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "idAfiliado", referencedColumnName = "idAfiliado")
    private Afiliado idBeneficiario;

    @ManyToOne
    @JoinColumn(name = "idAfiliado", referencedColumnName = "idAfiliado")
    private Afiliado idContribuyente;

    public ContribuyenteBeneficiarioPK(Afiliado idBeneficiario, Afiliado idContribuyente) {
        super();
        this.idBeneficiario = idBeneficiario;
        this.idContribuyente = idContribuyente;
    }

    public void setIdBeneficiario(Afiliado idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
    }

    public void setIdContribuyente(Afiliado idContribuyente) {
        this.idContribuyente = idContribuyente;
    }

    public Afiliado getIdBeneficiario() {
        return idBeneficiario;
    }

    public Afiliado getIdContribuyente() {
        return idContribuyente;
    }
    
}