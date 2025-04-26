package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Parentesco;

public interface ParentescoRepository extends JpaRepository<Parentesco, Integer> {
    
    @Query(value = "SELECT * FROM Parentesco", nativeQuery = true)
    Collection<Parentesco> darParentescos();

    @Query(value = "SELECT * FROM Parentesco WHERE idParentesco = :idParentesco", nativeQuery = true)
    Parentesco darParentesco(@Param("idParentesco") int idParentesco);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Parentesco (idParentesco, Descripcion) VALUES(parranderos_sequence.nextval, :Descripcion)", nativeQuery = true)
    void insertarParentesco(@Param("Descripcion") String Descripcion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Parentesco SET Descripcion= :Descripcion WHERE idParentesco = :idParentesco", nativeQuery = true)
    void actualizarParentesco(@Param("idParentesco") int idParentesco, @Param("Descripcion") String Descripcion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Parentesco WHERE idParentesco = :idParentesco", nativeQuery = true)
    void eliminarParentesco(@Param("idParentesco") int idParentesco);
    
}
