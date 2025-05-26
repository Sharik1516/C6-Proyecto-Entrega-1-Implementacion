package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Objects;

@Embeddable
public class ContribuyenteBeneficiarioPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idBeneficiario")
    private Afiliado idBeneficiario;

    @ManyToOne
    @JoinColumn(name = "idContribuyente")
    private Afiliado idContribuyente;

    public ContribuyenteBeneficiarioPK() {}

    public ContribuyenteBeneficiarioPK(Afiliado idBeneficiario, Afiliado idContribuyente) {
        this.idBeneficiario = idBeneficiario;
        this.idContribuyente = idContribuyente;
    }

    // Getters, setters, equals y hashCode
    public Afiliado getIdBeneficiario() {
        return idBeneficiario;
    }

    public void setIdBeneficiario(Afiliado idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
    }

    public Afiliado getIdContribuyente() {
        return idContribuyente;
    }

    public void setIdContribuyente(Afiliado idContribuyente) {
        this.idContribuyente = idContribuyente;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContribuyenteBeneficiarioPK)) return false;
        ContribuyenteBeneficiarioPK that = (ContribuyenteBeneficiarioPK) o;
        return Objects.equals(idBeneficiario, that.idBeneficiario) &&
               Objects.equals(idContribuyente, that.idContribuyente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBeneficiario, idContribuyente);
    }
}
