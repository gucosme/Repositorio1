package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

public class UC02ConsultarEmpresa {

	static Empresa empresa = new Empresa();
	static EmpresaDAO empresaDAO = new EmpresaDAO();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresa.setNomeDaEmpresa("Casas Bahia S/A");
		empresa.setCnpj("60430951000122");
		empresa.setNomeFantasia("Casas Bahia");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
	}
	
	@Before
	public void insereEmpresa() {
		empresaDAO.adiciona(empresa);
	}
	
	@Test
	public void consultarEmpresa_cnpj_valido() {
		System.out.println(empresaDAO.consultarEmpresa("60430951000122").toString());
		assertTrue(empresa.equals(empresaDAO.consultarEmpresa("60430951000122")));
	}

	@After
	public void tearDown() throws Exception {
		empresaDAO.exclui("60430951000122");
	}
}
