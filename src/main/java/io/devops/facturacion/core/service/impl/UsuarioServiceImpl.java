package io.devops.facturacion.core.service.impl;

import java.util.List;

import io.devops.facturacion.core.model.Usuario;
import io.devops.facturacion.core.repository.UsuarioRepository;
import io.devops.facturacion.core.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.devops.facturacion.core.exception.FacturacionWebException;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
    UsuarioRepository usuarioRepository;

	public Usuario crear(Usuario usuario) throws FacturacionWebException {
		return usuarioRepository.save(usuario);
	}
	
	public void eliminar(Usuario usuario) throws FacturacionWebException{
		
		usuarioRepository.deleteById(usuario.getId());
		
	}
	
	public List<Usuario> listarTodos() {
		
		return usuarioRepository.findAll();
		
	}
	
	

}
