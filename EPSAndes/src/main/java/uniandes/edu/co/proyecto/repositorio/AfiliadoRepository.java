package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Afiliado;
import uniandes.edu.co.proyecto.modelo.Usuario;

public interface AfiliadoRepository extends JpaRepository<Afiliado, Integer> {
    
    @Query(value = "SELECT * FROM Afiliado", nativeQuery = true)
    Collection<Afiliado> darAfiliados();

    @Query(value = "SELECT * FROM Afiliado WHERE idAfiliado = :idAfiliado", nativeQuery = true)
    Afiliado darAfiliado(@Param("idAfiliado") int idAfiliado);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Afiliado (idAfiliado, fechaNacimiento, direccion, telefono, tipoAfiliado, idUsuario) VALUES(parranderos_sequence.nextval, :fechaNacimiento, :direccion, :telefono, :tipoAfiliado, :idUsuario)", nativeQuery = true)
    void insertarAfiliado(@Param("fechaNacimiento") Date fechaNacimiento, @Param("direccion") String direccion, @Param("telefono") String telefono, @Param("tipoAfiliado") String tipoAfiliado, @Param("idUsuario") Usuario idUsuario);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Afiliado SET fechaNacimiento = :fechaNacimiento, direccion = :direccion, telefono = :telefono, tipoAfiliado = :tipoAfiliado, idUsuario = :idUsuario WHERE idAfiliado = :idAfiliado", nativeQuery = true)
    void actualizarAfiliado(@Param("idAfiliado") int idAfiliado, @Param("fechaNacimiento") Date fechaNacimiento, @Param("direccion") String direccion, @Param("telefono") String telefono, @Param("tipoAfiliado") String tipoAfiliado, @Param("idUsuario") Usuario idUsuario);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Afiliado WHERE idAfiliado = :idAfiliado", nativeQuery = true)
    void eliminarAfiliado(@Param("idAfiliado") int idAfiliado);
}
