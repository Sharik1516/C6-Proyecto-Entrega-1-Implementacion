package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Especialidad;

public interface EspecialidadRepository extends JpaRepository<Especialidad, Long> {

    @Query(value = "SELECT * FROM especialidad", nativeQuery = true)
    Collection<Especialidad> darEspecialidades();

    @Query(value = "SELECT * FROM especialidad WHERE id_especialidad = :idEspecialidad", nativeQuery = true)
    Especialidad darEspecialidad(@Param("idEspecialidad") Long idEspecialidad);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO especialidad (id_especialidad, nombre) VALUES (:idEspecialidad, :nombre)", nativeQuery = true)
    void insertarEspecialidad(
        @Param("idEspecialidad") Long idEspecialidad,
        @Param("nombre") String nombre
    );

    @Modifying
    @Transactional
    @Query(value = "UPDATE especialidad SET nombre = :nombre WHERE id_especialidad = :idEspecialidad", nativeQuery = true)
    void actualizarEspecialidad(
        @Param("idEspecialidad") Long idEspecialidad,
        @Param("nombre") String nombre
    );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM especialidad WHERE id_especialidad = :idEspecialidad", nativeQuery = true)
    void eliminarEspecialidad(@Param("idEspecialidad") Long idEspecialidad);
}
