package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "medicos")
@PrimaryKeyJoinColumn(name = "idUsuario")
public class Medico extends Usuario {

    private String registroMedico;

    @ManyToOne
    @JoinColumn(name = "idEspecialidad")
    private Especialidad especialidad;

    @ManyToOne
    @JoinColumn(name = "idEPS")
    private EPS eps;

    public Medico() {}

    public Medico(String nombre, String tipoDocumento, String numeroDocumento,
                  String registroMedico, Especialidad especialidad, EPS eps) {
        super(nombre, tipoDocumento, numeroDocumento);
        this.registroMedico = registroMedico;
        this.especialidad = especialidad;
        this.eps = eps;
    }

    public String getRegistroMedico() {
        return registroMedico;
    }

    public void setRegistroMedico(String registroMedico) {
        this.registroMedico = registroMedico;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public EPS getEps() {
        return eps;
    }

    public void setEps(EPS eps) {
        this.eps = eps;
    }
}
