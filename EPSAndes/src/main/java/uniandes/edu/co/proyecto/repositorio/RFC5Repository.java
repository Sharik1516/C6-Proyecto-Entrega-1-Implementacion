package uniandes.edu.co.proyecto.repositorio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class RFC5Repository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Object[]> consultarDisponibilidad(Date fechaInicio, Date fechaFin, String codMedico, String codServicio, String codIps) {
        String sql = "SELECT s.NOMBRE_SERVICIO, c.FECHA_CITA, c.HORA_CITA, m.NOMBRE_MEDICO, i.NOMBRE_IPS " +
                     "FROM CITAMEDICA c " +
                     "JOIN MEDICO m ON c.ID_MEDICO = m.ID_MEDICO " +
                     "JOIN SERVICIO s ON c.ID_SERVICIO = s.ID_SERVICIO " +
                     "JOIN IPSSERVICIO ips ON s.ID_SERVICIO = ips.ID_SERVICIO " +
                     "JOIN IPS i ON ips.ID_IPS = i.ID_IPS " +
                     "WHERE c.ESTADO_CITA = 'Disponible' " +
                     "AND (:fechaInicio IS NULL OR c.FECHA_CITA >= :fechaInicio) " +
                     "AND (:fechaFin IS NULL OR c.FECHA_CITA <= :fechaFin) " +
                     "AND (:codMedico IS NULL OR m.ID_MEDICO = :codMedico) " +
                     "AND (:codServicio IS NULL OR s.ID_SERVICIO = :codServicio) " +
                     "AND (:codIps IS NULL OR i.ID_IPS = :codIps) " +
                     "ORDER BY c.FECHA_CITA, c.HORA_CITA";

        return entityManager.createNativeQuery(sql)
                .setParameter("fechaInicio", fechaInicio)
                .setParameter("fechaFin", fechaFin)
                .setParameter("codMedico", codMedico)
                .setParameter("codServicio", codServicio)
                .setParameter("codIps", codIps)
                .getResultList();
    }
}
