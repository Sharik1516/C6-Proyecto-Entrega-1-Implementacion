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
public class Medico {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer idMedico;

    @ManyToOne
    @JoinColumn(name = "idEspecialidad")
    private Especialidad especialidad;

    private String registroMedico;

    @ManyToOne
    @JoinColumn(name = "idEPS")
    private EPS idEps;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;

    public Medico(Integer idMedico, Especialidad especialidad, String registroMedico, EPS idEps, Usuario idUsuario) {
        this.idMedico = idMedico;
        this.especialidad = especialidad;
        this.registroMedico = registroMedico;
        this.idEps = idEps;
        this.idUsuario = idUsuario;
    }

    public Medico() {;}

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
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

    public EPS getIdEps() {
        return idEps;
    }

    public void setIdEps(EPS idEps) {
        this.idEps = idEps;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
    
   
/* 
    @Service
    public class MedicoService {
        @Autowired
        private MedicoRepository medicoRepository;

        public Medico registrarMedico(Medico medico) {
            return medicoRepository.save(medico);
        }
    }
    
    */

}
