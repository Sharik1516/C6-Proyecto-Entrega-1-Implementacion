package uniandes.edu.co.proyecto.modelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ServicoIPS")
public class ServicoIPS {

    @ManyToOne
    @JoinColumn(name = "idOrden")
    private OrdenDeServicio orden;

    @ManyToOne
    @JoinColumn(name = "NIT")
    private IPS ips;

    public ServicoIPS() {}

    public OrdenDeServicio getOrden() {
        return orden;
    }

    public void setOrden(OrdenDeServicio orden) {
        this.orden = orden;
    }

    public IPS getIps() {
        return ips;
    }

    public void setIps(IPS ips) {
        this.ips = ips;
    }
    @Service
    public class ServicioSaludService {
        @Autowired
        private ServicioSaludRepository servicioSaludRepository;

        public ServicioSalud registrarServicio(ServicioSalud servicio) {
            return servicioSaludRepository.save(servicio);
        }
    }
}
