package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT * FROM usuarios", nativeQuery = true)
    Collection<Usuario> darUsuarios();

    @Query(value = "SELECT * FROM usuarios WHERE id_usuario = :id", nativeQuery = true)
    Usuario darUsuario(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuarios (id_usuario, nombre, tipo_documento, numero_documento) VALUES (:id, :nombre, :tipoDocumento, :numeroDocumento)", nativeQuery = true)
    void insertarUsuario(
        @Param("id") Long id,
        @Param("nombre") String nombre,
        @Param("tipoDocumento") String tipoDocumento,
        @Param("numeroDocumento") String numeroDocumento
    );

    @Modifying
    @Transactional
    @Query(value = "UPDATE usuarios SET nombre = :nombre, tipo_documento = :tipoDocumento, numero_documento = :numeroDocumento WHERE id_usuario = :id", nativeQuery = true)
    void actualizarUsuario(
        @Param("id") Long id,
        @Param("nombre") String nombre,
        @Param("tipoDocumento") String tipoDocumento,
        @Param("numeroDocumento") String numeroDocumento
    );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuarios WHERE id_usuario = :id", nativeQuery = true)
    void eliminarUsuario(@Param("id") Long id);
}
