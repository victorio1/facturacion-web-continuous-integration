package io.devops.facturacion.core.service;

import java.util.List;

import io.devops.facturacion.core.exception.FacturacionWebException;
import io.devops.facturacion.core.model.Usuario;

public interface UsuarioService {

	
	Usuario crear(Usuario usuario) throws FacturacionWebException;
	
	void eliminar(Usuario usuario) throws FacturacionWebException;
	
	List<Usuario> listarTodos();
	
}
