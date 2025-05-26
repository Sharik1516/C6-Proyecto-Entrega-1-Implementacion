package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Parentesco;

public interface ParentescoRepository extends JpaRepository<Parentesco, Long> {

    @Query(value = "SELECT * FROM parentesco", nativeQuery = true)
    Collection<Parentesco> darParentescos();

    @Query(value = "SELECT * FROM parentesco WHERE id_parentesco = :idParentesco", nativeQuery = true)
    Parentesco darParentescoPorId(@Param("idParentesco") Long idParentesco);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO parentesco (id_parentesco, descripcion) VALUES (:idParentesco, :descripcion)", nativeQuery = true)
    void insertarParentesco(
        @Param("idParentesco") Long idParentesco,
        @Param("descripcion") String descripcion
    );

    @Modifying
    @Transactional
    @Query(value = "UPDATE parentesco SET descripcion = :descripcion WHERE id_parentesco = :idParentesco", nativeQuery = true)
    void actualizarParentesco(
        @Param("idParentesco") Long idParentesco,
        @Param("descripcion") String descripcion
    );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM parentesco WHERE id_parentesco = :idParentesco", nativeQuery = true)
    void eliminarParentesco(@Param("idParentesco") Long idParentesco);
}
