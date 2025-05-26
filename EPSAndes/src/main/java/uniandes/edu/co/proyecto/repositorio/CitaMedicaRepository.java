package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.CitaMedica;

public interface CitaMedicaRepository extends JpaRepository<CitaMedica, Long> {

    @Query(value = "SELECT * FROM cita_medica", nativeQuery = true)
    Collection<CitaMedica> darCitasMedicas();

    @Query(value = "SELECT * FROM cita_medica WHERE id_cita = :idCita", nativeQuery = true)
    CitaMedica darCitaMedica(@Param("idCita") Long idCita);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cita_medica (id_cita, fecha_hora, id_orden, nit) VALUES (:idCita, :fechaHora, :idOrden, :nit)", nativeQuery = true)
    void insertarCitaMedica(
        @Param("idCita") Long idCita,
        @Param("fechaHora") Date fechaHora,
        @Param("idOrden") Long idOrden,
        @Param("nit") Integer nit
    );

    @Modifying
    @Transactional
    @Query(value = "UPDATE cita_medica SET fecha_hora = :fechaHora, id_orden = :idOrden, nit = :nit WHERE id_cita = :idCita", nativeQuery = true)
    void actualizarCitaMedica(
        @Param("idCita") Long idCita,
        @Param("fechaHora") Date fechaHora,
        @Param("idOrden") Long idOrden,
        @Param("nit") Integer nit
    );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cita_medica WHERE id_cita = :idCita", nativeQuery = true)
    void eliminarCitaMedica(@Param("idCita") Long idCita);
}
