package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.IPSservicio;
import uniandes.edu.co.proyecto.modelo.IPSservicioPK;

public interface IPSservicioRepository extends JpaRepository<IPSservicio, IPSservicioPK> {

    @Query(value = "SELECT * FROM ips_servicio", nativeQuery = true)
    Collection<IPSservicio> darIPSServicios();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ips_servicio (nit, id_servicio, capacidad_atencion) VALUES (:nit, :idServicio, :capacidad)", nativeQuery = true)
    void insertarIPSServicio(
        @Param("nit") Long nit,
        @Param("idServicio") Long idServicio,
        @Param("capacidad") Integer capacidad
    );

    @Modifying
    @Transactional
    @Query(value = "UPDATE ips_servicio SET capacidad_atencion = :capacidad WHERE nit = :nit AND id_servicio = :idServicio", nativeQuery = true)
    void actualizarIPSServicio(
        @Param("nit") Long nit,
        @Param("idServicio") Long idServicio,
        @Param("capacidad") Integer capacidad
    );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ips_servicio WHERE nit = :nit AND id_servicio = :idServicio", nativeQuery = true)
    void eliminarIPSServicio(
        @Param("nit") Long nit,
        @Param("idServicio") Long idServicio
    );
}
