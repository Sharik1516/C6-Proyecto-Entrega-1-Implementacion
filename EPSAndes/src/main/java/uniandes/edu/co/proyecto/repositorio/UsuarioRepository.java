package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query(value = "SELECT * FROM Usuario", nativeQuery = true)
    Collection<Usuario> darUsuarios();

    @Query( value = "SELECT EPSAndes_sequence.nextval FROM dual", nativeQuery = true )
    Integer obtenerSiguienteId( );
    @Query(value = "SELECT * FROM Usuario WHERE idUsuario = :idUsuario", nativeQuery = true)
    Usuario darUsuario(@Param("idUsuario") int idUsuario);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Usuario (idUsuario, tipoDocumento, numeroDocumento, nombre) VALUES(parranderos_sequence.nextval, :tipoDocumento, :numeroDocumento, :nombre)", nativeQuery = true)
    void insertarUsuario(@Param("tipoDocumento") String tipoDocumento, @Param("numeroDocumento") String numeroDocumento, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Usuario SET tipoDocumento= :tipoDocumento, numeroDocumento= :numeroDocumento, nombre= :nombre WHERE idUsuario = :idUsuario", nativeQuery = true)
    void actualizarUsuario(@Param("idUsuario") int idUsuario, @Param("tipoDocumento") String tipoDocumento, @Param("numeroDocumento") String numeroDocumento, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Usuario WHERE idUsuario = :idUsuario", nativeQuery = true)
    void eliminarUsuario(@Param("idUsuario") int idUsuario);
    
}
