package uniandes.edu.co.proyecto.repositorio;

import java.sql.Timestamp;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Prestaciones;

public interface PrestacionesRepository extends JpaRepository<Prestaciones, Long> {

    @Query(value = "SELECT * FROM prestaciones", nativeQuery = true)
    Collection<Prestaciones> darPrestaciones();

    @Query(value = "SELECT * FROM prestaciones WHERE id_prestacion = :id", nativeQuery = true)
    Prestaciones darPrestacion(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO prestaciones (id_prestacion, fecha_hora, id_cita, id_servicio) VALUES (:id, :fechaHora, :idCita, :idServicio)", nativeQuery = true)
    void insertarPrestacion(
        @Param("id") Long id,
        @Param("fechaHora") Timestamp fechaHora,
        @Param("idCita") Long idCita,
        @Param("idServicio") Long idServicio
    );

    @Modifying
    @Transactional
    @Query(value = "UPDATE prestaciones SET fecha_hora = :fechaHora, id_cita = :idCita, id_servicio = :idServicio WHERE id_prestacion = :id", nativeQuery = true)
    void actualizarPrestacion(
        @Param("id") Long id,
        @Param("fechaHora") Timestamp fechaHora,
        @Param("idCita") Long idCita,
        @Param("idServicio") Long idServicio
    );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM prestaciones WHERE id_prestacion = :id", nativeQuery = true)
    void eliminarPrestacion(@Param("id") Long id);
}
