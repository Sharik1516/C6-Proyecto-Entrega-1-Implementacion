package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Medico")
public abstract class Medico {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    @ManyToOne
    @JoinColumn(name = "numeroDocumento")
    private Usuario idMedico;

    @ManyToOne
    @JoinColumn(name = "idEspecialidad")
    private Especialidad especialidad;

    private String registroMedico;

    @ManyToOne
    @JoinColumn(name = "idEPS")
    private EPS eps;

    public Medico(Especialidad especialidad, String registroMedico, EPS eps) {
        this.especialidad = especialidad;
        this.registroMedico = registroMedico;
        this.eps = eps;
    }
    public Medico(){;}
    public Usuario getIdMedico() {
        return idMedico;
    }
    public void setIdMedico(Usuario idMedico) {
        this.idMedico = idMedico;
    }
    public Especialidad getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
    public String getRegistroMedico() {
        return registroMedico;
    }
    public void setRegistroMedico(String registroMedico) {
        this.registroMedico = registroMedico;
    }
    public EPS getEps() {
        return eps;
    }
    public void setEps(EPS eps) {
        this.eps = eps;
    }

    
    

}
