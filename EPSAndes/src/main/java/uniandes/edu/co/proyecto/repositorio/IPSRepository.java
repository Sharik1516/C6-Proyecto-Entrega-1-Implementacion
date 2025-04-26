package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.EPS;
import uniandes.edu.co.proyecto.modelo.IPS;

public interface IPSRepository extends JpaRepository<IPS, Integer>{
    
    @Query(value = "SELECT * FROM IPS", nativeQuery = true)
    Collection<EPS> darIPSES();

    @Query(value = "SELECT * FROM IPS WHERE NIT = :NIT", nativeQuery = true)
    IPS darIPS(@Param("NIT") int NIT);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO IPS (NIT, nombre, direccion, telefono, idEPS) VALUES(parranderos_sequence.nextval, :nombre, :direccion, :telefono, :idEPS)", nativeQuery = true)
    void insertarIPS(@Param("nombre") String nombre, @Param("direccion") String direccion, @Param("telefono") String telefono, @Param("idEPS") EPS idEPS);

    @Modifying
    @Transactional
    @Query(value = "UPDATE IPS SET nombre= :nombre, direccion= :direccion, telefono= :telefono, idEPS= :idEPS WHERE NIT = :NIT", nativeQuery = true)
    void actualizarIPS(@Param("NIT") int NIT, @Param("nombre") String nombre, @Param("direccion") String direccion, @Param("telefono") String telefono, @Param("idEPS") EPS idEPS);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM IPS WHERE NIT = :NIT", nativeQuery = true)
    void eliminarIPS(@Param("NIT") int NIT);
}
