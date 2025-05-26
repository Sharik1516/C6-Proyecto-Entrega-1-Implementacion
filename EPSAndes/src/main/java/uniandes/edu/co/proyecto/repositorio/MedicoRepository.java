package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

    @Query(value = "SELECT * FROM medicos", nativeQuery = true)
    Collection<Medico> darMedicos();

    @Query(value = "SELECT * FROM medicos WHERE id_usuario = :idUsuario", nativeQuery = true)
    Medico obtenerMedico(@Param("idUsuario") Long idUsuario);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO medicos (id_usuario, registro_medico, id_especialidad, id_eps) VALUES (:idUsuario, :registroMedico, :idEspecialidad, :idEPS)", nativeQuery = true)
    void insertarMedico(
        @Param("idUsuario") Long idUsuario,
        @Param("registroMedico") String registroMedico,
        @Param("idEspecialidad") Long idEspecialidad,
        @Param("idEPS") Long idEPS
    );

    @Modifying
    @Transactional
    @Query(value = "UPDATE medicos SET registro_medico = :registroMedico, id_especialidad = :idEspecialidad, id_eps = :idEPS WHERE id_usuario = :idUsuario", nativeQuery = true)
    void actualizarMedico(
        @Param("idUsuario") Long idUsuario,
        @Param("registroMedico") String registroMedico,
        @Param("idEspecialidad") Long idEspecialidad,
        @Param("idEPS") Long idEPS
    );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM medicos WHERE id_usuario = :idUsuario", nativeQuery = true)
    void eliminarMedico(@Param("idUsuario") Long idUsuario);
}
