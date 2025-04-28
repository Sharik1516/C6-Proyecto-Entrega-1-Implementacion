package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table( name = "medicos" )
public class Medico extends Usuario
{
    private String especialidad;
    private String registroMedico;

    public Medico( String nombre, String tipoDocumento, String numeroDocumento, String especialidad, String registroMedico ) 
    {
        super( nombre, tipoDocumento, numeroDocumento );

        this.especialidad = especialidad;
        this.registroMedico = registroMedico;
    }

    public Medico( ){

        
    }

    public String getEspecialidad( ) {
        return especialidad;
    }
    public void setEspecialidad( String especialidad ) {
        this.especialidad = especialidad;
    }

    public String getRegistroMedico( ) {
        return registroMedico;
    }
    public void setRegistroMedico( String registroMedico ) {
        this.registroMedico = registroMedico;
    }
}
