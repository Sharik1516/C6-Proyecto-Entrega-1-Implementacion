package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Afiliado;
import uniandes.edu.co.proyecto.modelo.Medico;
import uniandes.edu.co.proyecto.modelo.OrdenDeServicio;

public interface OrdenDeServicioRepository extends JpaRepository<OrdenDeServicio, Integer> {
    @Query(value = "SELECT * FROM OrdenDeServicio", nativeQuery = true)
    Collection<OrdenDeServicio> darOrdenesDeServicio();

    @Query(value = "SELECT * FROM OrdenDeServicio WHERE idOrden = :idOrden", nativeQuery = true)
    OrdenDeServicio darOrdenDeServicio(@Param("idOrden") int idOrden);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OrdenDeServicio (idOrden, fecha, estado, idAfiliado, idMedico) VALUES(parranderos_sequence.nextval, :fecha, :estado, :idAfiliado, :idMedico)", nativeQuery = true)
    void insertarOrdenDeServicio(@Param("fecha") Date fecha, @Param("estado") String estado, @Param("idAfiliado") Afiliado idAfiliado, @Param("idMedico") Medico idMedico);

    @Modifying
    @Transactional
    @Query(value = "UPDATE OrdenDeServicio SET fecha= :fecha, estado= :estado, idAfiliado= :idAfiliado, idMedico= :idMedico WHERE idOrden = :idOrden", nativeQuery = true)
    void actualizarOrdenDeServicio(@Param("idOrden") int idOrden, @Param("fecha") Date fecha, @Param("estado") String estado, @Param("idAfiliado") Afiliado idAfiliado, @Param("idMedico") Medico idMedico);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM OrdenDeServicio WHERE idOrden = :idOrden", nativeQuery = true)
    void eliminarOrdenDeServicio(@Param("idOrden") int idOrden);
    
}
