package uniandes.edu.co.proyecto.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.DTO.RFC5DTO;
import uniandes.edu.co.proyecto.repositorio.RFC5Repository;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Service
public class RFC5Service {

    private final RFC5Repository rfc5Repository;

    public RFC5Service(RFC5Repository rfc5Repository) {
        this.rfc5Repository = rfc5Repository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public List<RFC5DTO> consultarDisponibilidad(Date fechaInicio, Date fechaFin, String idMedico, String idServicio, String NIT) throws InterruptedException {
        Thread.sleep(30000); // Temporizador de 30 segundos
        List<Object[]> resultados = rfc5Repository.consultarDisponibilidad(fechaInicio, fechaFin, idMedico, idServicio, NIT);

        List<RFC5DTO> rfc5DTOList = new ArrayList<>();
        for (Object[] row : resultados) {
            RFC5DTO dto = new RFC5DTO(
                    (String) row[0],
                    (Date) row[1],
                    (Time) row[2],
                    (String) row[3],
                    (String) row[4]
            );
            rfc5DTOList.add(dto);
        }
        return rfc5DTOList;
    }
}
