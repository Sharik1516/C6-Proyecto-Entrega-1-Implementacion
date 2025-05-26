package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import uniandes.edu.co.proyecto.modelo.Prestaciones;
import java.util.Date;
import java.util.List;

public interface PrestacionesRepository extends JpaRepository<Prestaciones, Long> {
    List<Prestaciones> findByFechaInicioBetween(Date fechaInicio, Date fechaFin);
}