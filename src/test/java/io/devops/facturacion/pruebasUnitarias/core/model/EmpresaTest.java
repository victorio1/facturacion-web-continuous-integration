package io.devops.facturacion.pruebasUnitarias.core.model;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import io.devops.facturacion.core.model.Empresa;
import io.devops.facturacion.test.categoria.PruebaUnitaria;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(PruebaUnitaria.class)
public class EmpresaTest {

	private static Validator validator;
	
	@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Test
	public void creacionEmpresaConRucyRazonSocial() {
		Empresa empresa = new Empresa();
		empresa.setRuc("20604665770");
		empresa.setRazonSocial("AGILE LEARNING PERU");
		empresa.setRazonSocialComercial("ALP");
		empresa.setDireccion("SAN ISIDRO");
		empresa.setCelular("123456789");
		
		
		Set<ConstraintViolation<Empresa>> 
		constraintViolations = validator.validate(empresa);
		
		assertThat(constraintViolations.size(), is(0));
	}
	
	@Test
	public void validacionCreacionEmpresaCuandoRucEsVacio() {
		Empresa empresa = new Empresa();
		empresa.setRuc("");
		empresa.setRazonSocial("AGILE LEARNING PERU");
		
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertThat(constraintViolations.size(), is(2));
	}
	
	@Test
	public void validacionCreacionEmpresaCuandoRucNoTieneOnceDigitos() {
		Empresa empresa = new Empresa();
		empresa.setRuc("123");
		empresa.setRazonSocial("AGILE LEARNING PERU");
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertThat(constraintViolations.size(), is(1));
	}

	@Test
	public void validacionCreacionEmpresaCuandoRazonSocialEsVacio() {
		Empresa empresa = new Empresa();
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertThat(constraintViolations.size(), is(2));
	}

	@Test
	public void validacionCreacionEmpresaCuandoCelularNoTieneNueveDigitos() {
		Empresa empresa = new Empresa();
		empresa.setCelular("");
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertThat(constraintViolations.size(), is(3));
	}

}
