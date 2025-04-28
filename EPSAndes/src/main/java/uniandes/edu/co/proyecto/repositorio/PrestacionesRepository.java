package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.CitaMedica;
import uniandes.edu.co.proyecto.modelo.Prestaciones;
import uniandes.edu.co.proyecto.modelo.Servicio;

public interface PrestacionesRepository extends JpaRepository<Prestaciones, Integer> {
    
    @Query(value = "SELECT * FROM Prestaciones", nativeQuery = true)
    Collection<Prestaciones> darPrestaciones();

    @Query(value = "SELECT * FROM Prestaciones WHERE idPrestacion = :idPrestacion", nativeQuery = true)
    Prestaciones darPrestacion(@Param("idPrestacion") int idPrestacion);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Prestaciones (idPrestacion, idCita, idServicio, fechaHora) VALUES(parranderos_sequence.nextval, :idCita, :idServicio, :fechaHora)", nativeQuery = true)
    void insertarPrestacion(@Param("idCita") CitaMedica idCita, @Param("idServicio") Servicio idServicio, @Param("fechaInicio") Date fechaInicio, @Param("fechaFinal") Date fechaFinal);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Prestaciones SET idCita = :idCita, idServicio = :idServicio, fechaHora = :fechaHora WHERE idPrestacion = :idPrestacion", nativeQuery = true)
    void actualizarPrestacion(@Param("idPrestacion") int idPrestacion, @Param("idCita") CitaMedica idCita, @Param("idServicio") Servicio idServicio, @Param("fechaInicio") Date fechaInicio, @Param("fechaFinal") Date fechaFinal);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Prestaciones WHERE idPrestacion = :idPrestacion", nativeQuery = true)
    void eliminarPrestacion(@Param("idPrestacion") int idPrestacion);

    @Query(value = "SELECT * FROM Prestaciones WHERE fechaInicio >= :fechaInico AND fechaFinal<= :fechaFinal", nativeQuery = true)
    Collection<Prestaciones> darPrestacionesFecha(@Param("fechaInico") Date fechaInico, @Param("fechaFinal") Date fechaFinal);
}
