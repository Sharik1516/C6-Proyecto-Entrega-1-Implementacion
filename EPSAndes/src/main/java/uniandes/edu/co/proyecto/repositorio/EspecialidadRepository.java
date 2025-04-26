package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.EPS;
import uniandes.edu.co.proyecto.modelo.Especialidad;

public interface EspecialidadRepository extends JpaRepository<Especialidad, Integer>{

    @Query(value = "SELECT * FROM Especialidad", nativeQuery = true)
    Collection<Especialidad> darEspecialidades();

    @Query(value = "SELECT * FROM Especialidad WHERE idEspecialidad = :idEspecialidad", nativeQuery = true)
    EPS darEspecialidad(@Param("idEspecialidad") int idEspecialidad);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Especialidad (idEspecialidad, nombre) VALUES(parranderos_sequence.nextval, :nombre)", nativeQuery = true)
    void insertarEspecialidad(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Especialidad SET nombre= :nombre WHERE idEspecialidad = :idEspecialidad", nativeQuery = true)
    void actualizarEspecialidad(@Param("idEspecialidad") int idEspecialidad, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Especialidad WHERE idEspecialidad = :idEspecialidad", nativeQuery = true)
    void eliminarEspecialidad(@Param("idEspecialidad") int idEspecialidad);
    
}
