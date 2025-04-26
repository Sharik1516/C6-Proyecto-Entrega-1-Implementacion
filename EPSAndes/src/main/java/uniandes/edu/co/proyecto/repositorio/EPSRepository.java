package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.EPS;

public interface EPSRepository extends JpaRepository<EPS, Integer>{

    @Query(value = "SELECT * FROM EPS", nativeQuery = true)
    Collection<EPS> darEPSES();

    @Query(value = "SELECT * FROM EPS WHERE idEPS = :idEPS", nativeQuery = true)
    EPS darEPS(@Param("idEPS") int idEPS);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO EPS (idEPS, nombre, direccion, telefono) VALUES(parranderos_sequence.nextval, :nombre, :direccion, :telefono)", nativeQuery = true)
    void insertarEPS(@Param("nombre") String nombre, @Param("direccion") String direccion, @Param("telefono") String telefono);

    @Modifying
    @Transactional
    @Query(value = "UPDATE EPS SET nombre= :nombre, direccion= :direccion, telefono= :telefono WHERE idEPS = :idEPS", nativeQuery = true)
    void actualizarEPS(@Param("idEPS") int idEPS, @Param("nombre") String nombre, @Param("direccion") String direccion, @Param("telefono") String telefono);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM EPS WHERE idEPS = :idEPS", nativeQuery = true)
    void eliminarEPS(@Param("idEPS") int idEPS);
    
}
