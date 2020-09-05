package io.devops.facturacion.core.service;

import java.util.List;

import io.devops.facturacion.core.exception.FacturacionWebException;
import io.devops.facturacion.core.model.Empresa;

public interface EmpresaService {

	
	Empresa crear(Empresa empresa) throws FacturacionWebException;
	
	void eliminar(Empresa empresa) throws FacturacionWebException;
	
	List<Empresa> listarTodos();
	
}
