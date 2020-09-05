package io.devops.facturacion.pruebasIntegracion.core.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import io.devops.facturacion.core.exception.FacturacionWebException;
import io.devops.facturacion.core.exception.RucEmpresaExisteException;
import io.devops.facturacion.core.model.Empresa;
import io.devops.facturacion.core.service.EmpresaService;
import io.devops.facturacion.test.categoria.PruebaIntegracion;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Category(PruebaIntegracion.class)
public class EmpresaServiceTest {

	@Autowired
    EmpresaService empresaService;
	
	private Empresa empresa;
	
	@Before
	public void setUp() {
		empresa = new Empresa("22552255123", "MI EMPRESA S.A.C");
	}
	
	@After
	public void destroy() {
		
		try {
			
			empresaService.eliminar(empresa);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void a_creacionEmpresaConDatosValidos() {
		
		try {
			
			empresa = empresaService.crear(empresa);
			
			Assert.assertNotNull(empresa.getId());
			Assert.assertTrue(empresa.getId() > 0);
			
		} catch (FacturacionWebException e) {
			e.printStackTrace();
			Assert.fail();
		}
		
	}
	
	@Test
	public void b_creacionEmpresaCuandoRucExiste() {
		
		try {

			empresa = empresaService.crear(empresa);
			
			
		} catch (RucEmpresaExisteException e) {
			assertThat(e.getMessage(), is(RucEmpresaExisteException.MENSAJE_DEFAULT));
		} catch (FacturacionWebException e) {
			Assert.fail();
		}
		
	}
	
	
}
