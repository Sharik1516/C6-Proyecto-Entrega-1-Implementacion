package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
    
    @Query(value = "SELECT * FROM Servicio", nativeQuery = true)
    Collection<Servicio> darServicios();

    @Query(value = "SELECT * FROM Servicio WHERE idServicio = :idServicio", nativeQuery = true)
    Servicio darServicio(@Param("idServicio") int idServicio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Servicio (idServicio, nombre, Descripcion) VALUES(parranderos_sequence.nextval, :nombre, :Descripcion)", nativeQuery = true)
    void insertarServicio(@Param("nombre") String nombre, @Param("Descripcion") String Descripcion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Servicio SET nombre= :nombre, Descripcion= :Descripcion WHERE idServicio = :idServicio", nativeQuery = true)
    void actualizarServicio(@Param("idServicio") int idServicio, @Param("nombre") String nombre, @Param("Descripcion") String Descripcion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Servicio WHERE idServicio = :idServicio", nativeQuery = true)
    void eliminarServicio(@Param("idServicio") int idServicio);
    
}
