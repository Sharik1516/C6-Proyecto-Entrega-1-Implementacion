package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.IPS;

public interface IPSRepository extends JpaRepository<IPS, Long> {

    @Query(value = "SELECT * FROM ips", nativeQuery = true)
    Collection<IPS> darIPS();

    @Query(value = "SELECT * FROM ips WHERE nit = :nit", nativeQuery = true)
    IPS darIPS(@Param("nit") Long nit);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ips (nit, nombre, direccion, telefono, id_eps) VALUES (:nit, :nombre, :direccion, :telefono, :idEps)", nativeQuery = true)
    void insertarIPS(
        @Param("nit") Long nit,
        @Param("nombre") String nombre,
        @Param("direccion") String direccion,
        @Param("telefono") String telefono,
        @Param("idEps") Long idEps
    );

    @Modifying
    @Transactional
    @Query(value = "UPDATE ips SET nombre = :nombre, direccion = :direccion, telefono = :telefono, id_eps = :idEps WHERE nit = :nit", nativeQuery = true)
    void actualizarIPS(
        @Param("nit") Long nit,
        @Param("nombre") String nombre,
        @Param("direccion") String direccion,
        @Param("telefono") String telefono,
        @Param("idEps") Long idEps
    );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ips WHERE nit = :nit", nativeQuery = true)
    void eliminarIPS(@Param("nit") Long nit);
}
