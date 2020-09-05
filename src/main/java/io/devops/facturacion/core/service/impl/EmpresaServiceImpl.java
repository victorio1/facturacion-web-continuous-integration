package io.devops.facturacion.core.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import io.devops.facturacion.core.model.Empresa;
import io.devops.facturacion.core.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.devops.facturacion.core.exception.FacturacionWebException;
import io.devops.facturacion.core.exception.RucEmpresaExisteException;
import io.devops.facturacion.core.repository.EmpresaRepository;

@Service
public class EmpresaServiceImpl implements EmpresaService {
	
	@Autowired
	EmpresaRepository empresaRepository;

	public Empresa crear(Empresa empresa) throws RucEmpresaExisteException, FacturacionWebException {
		
		if( existeRucEmpresa(empresa.getRuc()) ) {
			
			throw new RucEmpresaExisteException();
			
		}
		
		return empresaRepository.save(empresa);
	}
	
	public void eliminar(Empresa empresa) throws FacturacionWebException{
		
		empresaRepository.deleteById(empresa.getId());
//		empresaRepository.delete(empresa.getId());
		
	}
	
	public List<Empresa> listarTodos() {
		
		return empresaRepository.findAll();
		
	}
	
	private boolean existeRucEmpresa(String ruc) throws FacturacionWebException {
			
		try {
			
			empresaRepository.findByRuc(ruc).get();
			
			return true;
			
		} catch (NoSuchElementException e) {
			
			return false;
		}
		
		
	}
	

}
