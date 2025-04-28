package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.EPS;
import uniandes.edu.co.proyecto.modelo.Especialidad;
import uniandes.edu.co.proyecto.modelo.Medico;
import uniandes.edu.co.proyecto.modelo.Usuario;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {

    @Query( value = "SELECT u.*, m.ESPECIALIDAD, m.REGISTRO_MEDICO FROM MEDICOS m RIGHT JOIN USUARIOS u ON m.id = u.id", nativeQuery = true )
    Collection<Medico> darMedicos( );

    @Query(value = "SELECT * FROM Medico WHERE idMedico = :idMedico", nativeQuery = true)
    Medico darMedico(@Param("idMedico") Integer idMedico);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Medico (idMedico, especialidad, registroMedico, idEps, idUsuario) VALUES(parranderos_sequence.nextval, :especialidad, :registroMedico, :idEps, :idUsuario)", nativeQuery = true)
    void insertarMedico(@Param("especialidad") Especialidad especialidad, @Param("registroMedico") String registroMedico, @Param("idEps") EPS idEps, @Param("idUsuario") Usuario idUsuario);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Medico SET especialidad= :especialidad, registroMedico= :registroMedico, idEps= :idEps, idUsuario= :idUsuario WHERE idMedico = :idMedico", nativeQuery = true)
    void actualizarMedico(@Param("idMedico") Integer idMedico, @Param("especialidad") String especialidad, @Param("registroMedico") String registroMedico);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Medico WHERE idMedico = :idMedico", nativeQuery = true)
    void eliminarMedico(@Param("idMedico") Integer idMedico);
    
}
