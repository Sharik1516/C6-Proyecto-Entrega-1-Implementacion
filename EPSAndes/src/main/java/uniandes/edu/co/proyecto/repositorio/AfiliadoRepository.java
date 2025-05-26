package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Afiliado;

public interface AfiliadoRepository extends JpaRepository<Afiliado, Long> {

    @Query(value = "SELECT * FROM afiliados", nativeQuery = true)
    Collection<Afiliado> darAfiliados();

    @Query(value = "SELECT * FROM afiliados WHERE id_usuario = :idUsuario", nativeQuery = true)
    Afiliado darAfiliado(@Param("idUsuario") Long idUsuario);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO afiliados (id_usuario, fecha_nacimiento, direccion, telefono, tipo_afiliado) VALUES (:idUsuario, :fechaNacimiento, :direccion, :telefono, :tipoAfiliado)", nativeQuery = true)
    void insertarAfiliado(
        @Param("idUsuario") Long idUsuario,
        @Param("fechaNacimiento") Date fechaNacimiento,
        @Param("direccion") String direccion,
        @Param("telefono") String telefono,
        @Param("tipoAfiliado") String tipoAfiliado
    );

    @Modifying
    @Transactional
    @Query(value = "UPDATE afiliados SET fecha_nacimiento = :fechaNacimiento, direccion = :direccion, telefono = :telefono, tipo_afiliado = :tipoAfiliado WHERE id_usuario = :idUsuario", nativeQuery = true)
    void actualizarAfiliado(
        @Param("idUsuario") Long idUsuario,
        @Param("fechaNacimiento") Date fechaNacimiento,
        @Param("direccion") String direccion,
        @Param("telefono") String telefono,
        @Param("tipoAfiliado") String tipoAfiliado
    );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM afiliados WHERE id_usuario = :idUsuario", nativeQuery = true)
    void eliminarAfiliado(@Param("idUsuario") Long idUsuario);
}
