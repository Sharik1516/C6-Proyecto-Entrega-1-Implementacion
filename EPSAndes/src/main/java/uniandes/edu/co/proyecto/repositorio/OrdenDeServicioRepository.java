package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.OrdenDeServicio;

public interface OrdenDeServicioRepository extends JpaRepository<OrdenDeServicio, Long> {

    @Query(value = "SELECT * FROM orden_de_servicio", nativeQuery = true)
    Collection<OrdenDeServicio> darOrdenesDeServicio();

    @Query(value = "SELECT * FROM orden_de_servicio WHERE id_orden = :idOrden", nativeQuery = true)
    OrdenDeServicio darOrdenPorId(@Param("idOrden") Long idOrden);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO orden_de_servicio (id_orden, fecha, estado, id_afiliado, id_medico, id_servicio) VALUES (:idOrden, :fecha, :estado, :idAfiliado, :idMedico, :idServicio)", nativeQuery = true)
    void insertarOrdenDeServicio(
        @Param("idOrden") Long idOrden,
        @Param("fecha") Date fecha,
        @Param("estado") String estado,
        @Param("idAfiliado") Long idAfiliado,
        @Param("idMedico") Long idMedico,
        @Param("idServicio") Long idServicio
    );

    @Modifying
    @Transactional
    @Query(value = "UPDATE orden_de_servicio SET fecha = :fecha, estado = :estado, id_afiliado = :idAfiliado, id_medico = :idMedico, id_servicio = :idServicio WHERE id_orden = :idOrden", nativeQuery = true)
    void actualizarOrdenDeServicio(
        @Param("idOrden") Long idOrden,
        @Param("fecha") Date fecha,
        @Param("estado") String estado,
        @Param("idAfiliado") Long idAfiliado,
        @Param("idMedico") Long idMedico,
        @Param("idServicio") Long idServicio
    );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM orden_de_servicio WHERE id_orden = :idOrden", nativeQuery = true)
    void eliminarOrdenDeServicio(@Param("idOrden") Long idOrden);
}
