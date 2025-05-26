package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Long> {

    @Query(value = "SELECT * FROM servicio", nativeQuery = true)
    Collection<Servicio> darServicios();

    @Query(value = "SELECT * FROM servicio WHERE id_servicio = :id", nativeQuery = true)
    Servicio darServicio(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO servicio (id_servicio, nombre, descripcion) VALUES (:id, :nombre, :descripcion)", nativeQuery = true)
    void insertarServicio(
        @Param("id") Long id,
        @Param("nombre") String nombre,
        @Param("descripcion") String descripcion
    );

    @Modifying
    @Transactional
    @Query(value = "UPDATE servicio SET nombre = :nombre, descripcion = :descripcion WHERE id_servicio = :id", nativeQuery = true)
    void actualizarServicio(
        @Param("id") Long id,
        @Param("nombre") String nombre,
        @Param("descripcion") String descripcion
    );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM servicio WHERE id_servicio = :id", nativeQuery = true)
    void eliminarServicio(@Param("id") Long id);
}
