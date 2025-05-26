package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.proyecto.modelo.Prestaciones;

import java.util.Date;
import java.util.List;

@Repository
public interface PrestacionesRepository extends MongoRepository<Prestaciones, String> {
    List<Prestaciones> findByFechaInicioBetween(Date fechaInicio, Date fechaFinal);
}
