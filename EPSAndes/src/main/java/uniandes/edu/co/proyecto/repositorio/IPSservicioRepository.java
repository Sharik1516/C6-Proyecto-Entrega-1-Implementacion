package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.IPSservicio;
import uniandes.edu.co.proyecto.modelo.IPSservicioPK;

public interface IPSservicioRepository extends JpaRepository<IPSservicio, IPSservicioPK> {
    @Query(value = "SELECT * FROM IPSservicio", nativeQuery = true)
    Collection<IPSservicio> darIPSESservicio();

    @Query(value = "SELECT * FROM IPSservicio WHERE pk = :pk", nativeQuery = true)
    IPSservicio darIPSservicio(@Param("pk") IPSservicioPK pk);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO IPSservicio (pk) VALUES(parranderos_sequence.nextval)", nativeQuery = true)
    void insertarIPSservicio();

    @Modifying
    @Transactional
    @Query(value = "UPDATE IPSservicio WHERE pk = :pk", nativeQuery = true)
    void actualizarIPSservicio(@Param("pk") IPSservicioPK pk);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM IPSservicio WHERE pk = :pk", nativeQuery = true)
    void eliminarIPSservicio(@Param("pk") IPSservicioPK pk);
    
}
