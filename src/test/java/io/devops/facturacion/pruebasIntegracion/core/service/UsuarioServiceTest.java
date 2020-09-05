package io.devops.facturacion.pruebasIntegracion.core.service;

import io.devops.facturacion.core.exception.FacturacionWebException;
import io.devops.facturacion.core.model.Usuario;
import io.devops.facturacion.core.service.UsuarioService;
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
public class UsuarioServiceTest {

	@Autowired
    UsuarioService usuarioService;
	
	private Usuario usuario;
	
	@Before
	public void setUp() {
		usuario = new Usuario("alexander", "avila", "alexander.avila@gmail.com");
	}
	
	@After
	public void destroy() {
		
		try {
			
			usuarioService.eliminar(usuario);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void a_creacionUsuarioConDatosValidos() {
		
		try {
			
			usuario = usuarioService.crear(usuario);
			
			Assert.assertNotNull(usuario.getId());
			Assert.assertTrue(usuario.getId() > 0);
			
		} catch (FacturacionWebException e) {
			e.printStackTrace();
			Assert.fail();
		}
		
	}
	
	
}
