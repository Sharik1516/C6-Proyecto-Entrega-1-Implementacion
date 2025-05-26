package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ContribuyenteBeneficiario;
import uniandes.edu.co.proyecto.modelo.ContribuyenteBeneficiarioPK;

public interface ContribuyenteBeneficiarioRepository extends JpaRepository<ContribuyenteBeneficiario, ContribuyenteBeneficiarioPK> {

    @Query(value = "SELECT * FROM contribuyente_beneficiario", nativeQuery = true)
    Collection<ContribuyenteBeneficiario> darContribuyentesBeneficiarios();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO contribuyente_beneficiario (id_contribuyente, id_beneficiario, id_parentesco) VALUES (:idContribuyente, :idBeneficiario, :idParentesco)", nativeQuery = true)
    void insertarContribuyenteBeneficiario(
        @Param("idContribuyente") Long idContribuyente,
        @Param("idBeneficiario") Long idBeneficiario,
        @Param("idParentesco") Long idParentesco
    );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM contribuyente_beneficiario WHERE id_contribuyente = :idContribuyente AND id_beneficiario = :idBeneficiario", nativeQuery = true)
    void eliminarContribuyenteBeneficiario(
        @Param("idContribuyente") Long idContribuyente,
        @Param("idBeneficiario") Long idBeneficiario
    );
}
