package uniandes.edu.co.proyecto.DTO;

import java.sql.Date;
import java.sql.Time;

public class RFC5DTO {
    private String nombreServicio;
    private Date fechaCita;
    private Time horaCita;
    private String nombreMedico;
    private String nombreIps;

    public RFC5DTO(String nombreServicio, Date fechaCita, Time horaCita, String nombreMedico, String nombreIps) {
        this.nombreServicio = nombreServicio;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.nombreMedico = nombreMedico;
        this.nombreIps = nombreIps;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Time getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(Time horaCita) {
        this.horaCita = horaCita;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getNombreIps() {
        return nombreIps;
    }

    public void setNombreIps(String nombreIps) {
        this.nombreIps = nombreIps;
    }

}
