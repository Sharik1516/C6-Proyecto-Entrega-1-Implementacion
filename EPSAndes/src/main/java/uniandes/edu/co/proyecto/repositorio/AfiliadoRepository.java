package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Afiliado;

public interface AfiliadoRepository extends JpaRepository<Afiliado, Integer> {
    
    @Query(value = "SELECT * FROM afiliados", nativeQuery = true)
    Collection<Afiliado> darAfiliados();

    @Query(value = "SELECT * FROM afiliados WHERE id = :id", nativeQuery = true)
    Afiliado darAfiliado(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO afiliados (fecha_nacimiento, tipo_afiliado, telefono, direccion, id) VALUES (:fechaNacimiento, :tipoAfiliado, :telefono, :direccion, :id)", nativeQuery = true)
    void insertarAfiliado(
        @Param("fechaNacimiento") Date fechaNacimiento,
        @Param("tipoAfiliado") String tipoAfiliado,
        @Param("telefono") String telefono,
        @Param("direccion") String direccion,
        @Param("id") Integer id
    );

    @Modifying
    @Transactional
    @Query(value = "UPDATE afiliados SET fecha_nacimiento = :fechaNacimiento, tipo_afiliado = :tipoAfiliado, telefono = :telefono, direccion = :direccion WHERE id = :id", nativeQuery = true)
    void actualizarAfiliado(
        @Param("id") int id,
        @Param("fechaNacimiento") Date fechaNacimiento,
        @Param("tipoAfiliado") String tipoAfiliado,
        @Param("telefono") String telefono,
        @Param("direccion") String direccion
    );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM afiliados WHERE id = :id", nativeQuery = true)
    void eliminarAfiliado(@Param("id") int id);
}
