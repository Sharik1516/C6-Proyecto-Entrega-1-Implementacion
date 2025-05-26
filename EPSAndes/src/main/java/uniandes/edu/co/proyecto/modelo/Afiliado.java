package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "afiliados")
@PrimaryKeyJoinColumn(name = "idUsuario")
public class Afiliado extends Usuario {

    private String nombre;
    private String tipoDocumento;
    private String numeroDocumento;
    private Date fechaNacimiento;
    private String direccion;
    private String telefono;
    private String tipoAfiliado;

    @ManyToOne
    @JoinColumn(name = "id_eps")
    private EPS eps;

    @ManyToOne
    @JoinColumn(name = "nit_ips")
    private IPS ips;

    public Afiliado() {}

    public Afiliado(String nombre, String tipoDocumento, String numeroDocumento,
                    Date fechaNacimiento, String direccion, String telefono,
                    String tipoAfiliado, EPS eps, IPS ips) {
        super(nombre, tipoDocumento, numeroDocumento);
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipoAfiliado = tipoAfiliado;
        this.eps = eps;
        this.ips = ips;
    }


    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(String tipoDocumento) { this.tipoDocumento = tipoDocumento; }

    public String getNumeroDocumento() { return numeroDocumento; }
    public void setNumeroDocumento(String numeroDocumento) { this.numeroDocumento = numeroDocumento; }

    public Date getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getTipoAfiliado() { return tipoAfiliado; }
    public void setTipoAfiliado(String tipoAfiliado) { this.tipoAfiliado = tipoAfiliado; }

    public EPS getEps() { return eps; }
    public void setEps(EPS eps) { this.eps = eps; }

    public IPS getIps() { return ips; }
    public void setIps(IPS ips) { this.ips = ips; }
}
