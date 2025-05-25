package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.proyecto.modelo.IPSservicio;

@Repository
public interface IPSservicioRepository extends MongoRepository<IPSservicio, String> {
}
