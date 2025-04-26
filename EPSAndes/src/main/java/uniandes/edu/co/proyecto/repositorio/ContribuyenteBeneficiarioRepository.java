package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ContribuyenteBeneficiario;
import uniandes.edu.co.proyecto.modelo.ContribuyenteBeneficiarioPK;
import uniandes.edu.co.proyecto.modelo.Parentesco;

public interface ContribuyenteBeneficiarioRepository extends JpaRepository<ContribuyenteBeneficiario, ContribuyenteBeneficiarioPK>{
    
    @Query(value = "SELECT * FROM ContribuyenteBeneficiario", nativeQuery = true)
    Collection<ContribuyenteBeneficiario> darContribuyentesBeneficiarios();

    @Query(value = "SELECT * FROM ContribuyenteBeneficiario WHERE pk = :pk", nativeQuery = true)
    ContribuyenteBeneficiario darContribuyenteBeneficiario(@Param("pk") ContribuyenteBeneficiarioPK pk);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ContribuyenteBeneficiario (pk, idParentesco) VALUES(parranderos_sequence.nextval, :idParentesco)", nativeQuery = true)
    void insertarContribuyenteBeneficiario(@Param("idParentesco") Parentesco idParentesco);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ContribuyenteBeneficiario SET idParentesco= :idParentesco WHERE pk = :pk", nativeQuery = true)
    void actualizarContribuyenteBeneficiario(@Param("pk") ContribuyenteBeneficiarioPK pk, @Param("idParentesco") Parentesco idParentesco);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ContribuyenteBeneficiario WHERE pk = :pk", nativeQuery = true)
    void eliminarContribuyenteBeneficiario(@Param("pk") ContribuyenteBeneficiarioPK pk);
}
