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

    @Query( value = "SELECT u.*, m.ESPECIALIDAD, m.REGISTRO_MEDICO FROM MEDICOS m RIGHT JOIN USUARIOS u ON m.id = u.id WHERE u.id = :id", nativeQuery = true )
    Medico obtenerMedico( @Param("id") Integer id );

    @Modifying
    @Transactional
    @Query( value = "INSERT INTO medicos( id, especialidad, registro_medico ) VALUES( :id, :especialidad, :registroMedico )", nativeQuery = true )
    void insertarMedico( @Param("id") Integer id, @Param("especialidad") String especialidad, @Param("registroMedico") String registroMedico );

    @Modifying
    @Transactional
    @Query( value = "UPDATE medicos SET especialidad = :especialidad, registro_medico = :registroMedico WHERE id = :id", nativeQuery = true )
    void actualizarMedico( @Param("id") Integer id, @Param("especialidad") String especialidad, @Param("registroMedico") String registroMedico );

    @Modifying
    @Transactional
    @Query( value = "DELETE FROM medicos WHERE id = :id", nativeQuery = true )
    void eliminarMedico( @Param("id") Integer id );
    
}
