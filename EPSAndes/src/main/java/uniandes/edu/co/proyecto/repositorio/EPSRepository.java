package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.EPS;

public interface EPSRepository extends JpaRepository<EPS, Long> {

    @Query(value = "SELECT * FROM eps", nativeQuery = true)
    Collection<EPS> darEPS();

    @Query(value = "SELECT * FROM eps WHERE id_eps = :idEPS", nativeQuery = true)
    EPS darEPSPorId(@Param("idEPS") Long idEPS);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO eps (id_eps, nombre, tipo) VALUES (:idEPS, :nombre, :tipo)", nativeQuery = true)
    void insertarEPS(
        @Param("idEPS") Long idEPS,
        @Param("nombre") String nombre,
        @Param("tipo") String tipo
    );

    @Modifying
    @Transactional
    @Query(value = "UPDATE eps SET nombre = :nombre, tipo = :tipo WHERE id_eps = :idEPS", nativeQuery = true)
    void actualizarEPS(
        @Param("idEPS") Long idEPS,
        @Param("nombre") String nombre,
        @Param("tipo") String tipo
    );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM eps WHERE id_eps = :idEPS", nativeQuery = true)
    void eliminarEPS(@Param("idEPS") Long idEPS);
}
