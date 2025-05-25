package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.proyecto.modelo.OrdenDeServicio;

@Repository
public interface OrdenDeServicioRepository extends MongoRepository<OrdenDeServicio, String> {
}
