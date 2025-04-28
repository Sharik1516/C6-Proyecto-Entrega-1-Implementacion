package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table( name = "usuarios" )
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario
{
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Integer id;
    
    private String nombre;
    private String tipoDocumento;
    private String numeroDocumento;

    public Usuario( String nombre, String tipoDocumento, String numeroDocumento )
    {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
    }

    public Usuario( ){
        
    }

    public Integer getId( ) {
        return id;
    }
    public void setId( Integer id ) {
        this.id = id;
    }

    public String getNombre( ) {
        return nombre;
    }
    public void setNombre( String nombre ) {
        this.nombre = nombre;
    }

    public String getTipoDocumento( ) {
        return tipoDocumento;
    }
    public void setTipoDocumento( String tipoDocumento ) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento( ) {
        return numeroDocumento;
    }
    public void setNumeroDocumento( String numeroDocumento ) {
        this.numeroDocumento = numeroDocumento;
    }
}