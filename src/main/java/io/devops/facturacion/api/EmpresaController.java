package io.devops.facturacion.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import io.devops.facturacion.core.exception.FacturacionWebException;
import io.devops.facturacion.core.model.Empresa;
import io.devops.facturacion.core.service.EmpresaService;

@Controller
public class EmpresaController {

	
	@Autowired
	private EmpresaService empresaService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/empresas")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		List<Empresa> empresas = empresaService.listarTodos();
		modelAndView.addObject("empresas", empresas);
		return modelAndView;
	}

	@PostMapping("/empresas/crear")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public Empresa crear(@RequestBody Empresa empresa) {
		logger.debug("Create note request: {}", empresa);
		try {
			return empresaService.crear(empresa);
			
		} catch (FacturacionWebException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
