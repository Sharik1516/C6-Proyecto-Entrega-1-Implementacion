package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.CitaMedica;
import uniandes.edu.co.proyecto.modelo.IPS;
import uniandes.edu.co.proyecto.modelo.OrdenDeServicio;

public interface CitaMedicaRepository extends JpaRepository<CitaMedica, Integer>{

    @Query(value = "SELECT * FROM CitaMedica", nativeQuery = true)
    Collection<CitaMedica> darCitasMedicas();

    @Query(value = "SELECT * FROM CitaMedica WHERE idCita = :idCita", nativeQuery = true)
    CitaMedica darCitaMedica(@Param("idCita") int idCita);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CitaMedica (idCita, fechaHora, idOrden, NIT) VALUES(parranderos_sequence.nextval, :fechaHora, :idOrden, :NIT)", nativeQuery = true)
    void insertarCitaMedica(@Param("fechaHora") Date fechaHora, @Param("idOrden") OrdenDeServicio idOrden, @Param("NIT") IPS NIT);

    @Modifying
    @Transactional
    @Query(value = "UPDATE CitaMedica SET fechaHora= :fechaHora, idOrden= :idOrden, NIT= :NIT WHERE idCita = :idCita", nativeQuery = true)
    void actualizarCitaMedica(@Param("idCita") int idCita, @Param("fechaHora") Date fechaHora, @Param("idOrden") OrdenDeServicio idOrden, @Param("NIT") IPS NIT);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CitaMedica WHERE idCita = :idCita", nativeQuery = true)
    void eliminarCitaMedica(@Param("idCita") int idCita);
}
