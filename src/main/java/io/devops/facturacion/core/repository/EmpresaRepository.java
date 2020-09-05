package io.devops.facturacion.core.repository;

import java.util.Optional;

import io.devops.facturacion.core.exception.FacturacionWebException;
import io.devops.facturacion.core.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

	Optional<Empresa> findByRuc(String ruc) throws FacturacionWebException;
	
}
