package io.devops.facturacion.pruebasUnitarias.core.model;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import io.devops.facturacion.core.model.Usuario;
import io.devops.facturacion.test.categoria.PruebaUnitaria;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(PruebaUnitaria.class)
public class UsuarioTest {

	private static Validator validator;
	
	@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Test
	public void creacionUsuarioExitoso() {
		Usuario usuario = new Usuario();
		usuario.setNombres("Alexander");
		usuario.setApellidos("Avila");
		usuario.setEmail("alexander.avila@gmail.com");
		
		Set<ConstraintViolation<Usuario>> 
		constraintViolations = validator.validate(usuario);
		
		assertThat(constraintViolations.size(), is(0));
	}
	
	@Test
	public void validacionCreacionUsuarioCuandoEmailEsVacio() {
		Usuario usuario = new Usuario();
		usuario.setNombres("Alexander");
		usuario.setApellidos("Avila");
		usuario.setEmail("");
		
		Set<ConstraintViolation<Usuario>> constraintViolations = validator.validate(usuario);
		assertThat(constraintViolations.size(), is(1));
	}
	
}
