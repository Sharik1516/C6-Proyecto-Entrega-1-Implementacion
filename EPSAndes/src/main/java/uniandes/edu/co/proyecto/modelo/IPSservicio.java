package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Document(collection = "ipsServicios")
public class IPSservicio {

    @EmbeddedId
    private IPSservicioPK pk;

    @ManyToOne
    @MapsId("idServicio")
    @JoinColumn(name = "idServicio")
    private Servicio servicio;

    @ManyToOne
    @MapsId("nit")
    @JoinColumn(name = "NIT")
    private IPS ips;

    private String agenda;

    public IPSservicio() {}
    public IPSservicio() {}

    public IPSservicio(Servicio servicio, IPS ips, String agenda) {
        this.pk = new IPSservicioPK(servicio.getIdServicio(), ips.getNIT());
        this.servicio = servicio;
        this.ips = ips;
        this.agenda = agenda;
    }

    public IPSservicioPK getPk() {
        return pk;
    }

    public void setPk(IPSservicioPK pk) {
        this.pk = pk;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public IPS getIps() {
        return ips;
    }

    public void setIps(IPS ips) {
        this.ips = ips;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }
}
