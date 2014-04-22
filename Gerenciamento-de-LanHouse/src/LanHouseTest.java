import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LanHouseTest {

	private LanHouse lan; 

	@Before
	public void iniciar(){
		lan = new LanHouse(); 
	}

	@Test
	public void adicionarCliente() {
		Cliente cliente = new Cliente();
		cliente.setNome("Jefferson");
		cliente.setCpf("256.814393-21");
		cliente.setIdade(23);
		cliente.setEndereco(meuEndereco());
		cliente.setTelefone("9999-8888");
		lan.adicionarCliente(cliente);

		Cliente c = lan.getCliente(0);
		assertEquals(cliente, c);
	}
	
	@Test(expected = ClienteJaExisteException.class)
	public void adicionarClienteNovamente(){
		Cliente c = new Cliente();
		c.setNome("Jefferson");
		c.setCpf("256.814393-21");
		c.setIdade(23);
		c.setEndereco(meuEndereco());
		c.setTelefone("9999-8888");
		lan.adicionarCliente(c);
		lan.adicionarCliente(c);
	}
	
	@Test
	public void adicionarClienteDiferente() {
		Cliente c1 = new Cliente();
		c1.setNome("Jefferson");
		c1.setCpf("256.814393-21");
		c1.setIdade(23);
		c1.setEndereco(meuEndereco());
		c1.setTelefone("9999-8888");
		lan.adicionarCliente(c1);
		Cliente c2 = new Cliente();
		c2.setNome("Ligeirinho");
		c2.setCpf("915.161.843-51");
		c2.setIdade(24);
		c2.setEndereco(meuEndereco());
		c2.setTelefone("8888-9999");
		lan.adicionarCliente(c2);
		
		Cliente cliente= lan.getCliente(1);
		assertEquals("Espera-se que o c2 seja o cliente",
				c2, cliente);
	}
	
	@Test(expected = CampoInvalidoException.class)
	public void adicionarClienteSemNome(){
		Cliente cliente = new Cliente();
		cliente.setCpf("256.814393-21");
		cliente.setEndereco(meuEndereco());
		cliente.setTelefone("9999-8888");
		lan.adicionarCliente(cliente);
	}
	
	@Test(expected = CampoInvalidoException.class)
	public void adicionarClienteSemCpf(){
		Cliente cliente = new Cliente();
		cliente.setNome("Jefferson");
		cliente.setEndereco(meuEndereco());
		cliente.setTelefone("9999-8888");
		lan.adicionarCliente(cliente);
	}
	
	@Test(expected = CampoInvalidoException.class)
	public void adicionarClienteComCpfInvalido(){
		Cliente cliente = new Cliente();
		cliente.setNome("Jefferson");
		cliente.setCpf("12345");
		cliente.setEndereco(meuEndereco());
		cliente.setTelefone("9999-8888");
		lan.adicionarCliente(cliente);
	}

	@Test(expected = CampoInvalidoException.class)
	public void adicionarClienteSemIdade(){
		Cliente cliente = new Cliente();
		cliente.setNome("Jefferson");
		cliente.setCpf("256.814393-21");
		cliente.setEndereco(meuEndereco());
		cliente.setTelefone("9999-8888");
		lan.adicionarCliente(cliente);
	}
	
	@Test(expected = CampoInvalidoException.class)
	public void adicionarClienteSemEndereco(){
		Cliente cliente = new Cliente();
		cliente.setNome("Jefferson");
		cliente.setCpf("256.814393-21");
		cliente.setIdade(23);
		cliente.setTelefone("9999-8888");
		lan.adicionarCliente(cliente);
	}
	
	@Test(expected = CampoInvalidoException.class)
	public void adicionarClienteSemTelefone(){
		Cliente cliente = new Cliente();
		cliente.setNome("Jefferson");
		cliente.setCpf("256.814393-21");
		cliente.setIdade(23);
		cliente.setEndereco(meuEndereco());
		lan.adicionarCliente(cliente);
	}
	
	@Test
	public void removerCliente(){
		Cliente cliente = new Cliente();
		cliente.setNome("Jefferson");
		cliente.setCpf("256.814393-21");
		cliente.setIdade(23);
		cliente.setEndereco(meuEndereco());
		cliente.setTelefone("9999-8888");
		lan.adicionarCliente(cliente);
		lan.removeCliente(cliente);
		assertEquals("Esperasse que não tenha aluno",
				0,lan.quantidadeDeClientes());
	}

	@Test(expected = ClienteInexistenteException.class)
	public void removerClienteNovamente(){
		Cliente cliente = new Cliente();
		cliente.setNome("Jefferson");
		cliente.setCpf("256.814393-21");
		cliente.setIdade(23);
		cliente.setEndereco(meuEndereco());
		cliente.setTelefone("9999-8888");
		lan.adicionarCliente(cliente);
		lan.removeCliente(cliente);
		lan.removeCliente(cliente);
	}

	@Test
	public void removerClienteDiferente(){
		Cliente cliente1 = new Cliente();
		cliente1.setNome("Jefferson");
		cliente1.setCpf("256.814393-21");
		cliente1.setIdade(23);
		cliente1.setEndereco(meuEndereco());
		cliente1.setTelefone("9999-8888");
		lan.adicionarCliente(cliente1);
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Ligeirinho");
		cliente2.setCpf("915.161.843-51");
		cliente2.setIdade(24);
		cliente2.setEndereco(meuEndereco());
		cliente2.setTelefone("8888-9999");
		lan.adicionarCliente(cliente2);
		
		lan.removeCliente(cliente2);
		lan.removeCliente(cliente1);
		assertEquals(0, lan.quantidadeDeClientes());
	}

	@Test(expected = ClienteInexistenteException.class)
	public void removerClienteInexstente(){
		Cliente cliente = new Cliente();
		cliente.setNome("Jefferson");
		cliente.setCpf("256.814393-21");
		cliente.setIdade(23);
		cliente.setEndereco(meuEndereco());
		cliente.setTelefone("9999-8888");
		lan.adicionarCliente(cliente);
		
		cliente = new Cliente();
		cliente.setNome("Ligeirinho");
		cliente.setCpf("915.161.843-51");
		cliente.setIdade(24);
		cliente.setEndereco(meuEndereco());
		cliente.setTelefone("8888-9999");
		lan.removeCliente(cliente);
	}
	
	@Test
	public void adicionarFuncionario() {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Jhon");
		funcionario.setCpf("202.911.775-73");
		funcionario.setIdade(25);
		funcionario.setLogin("Jhon");
		funcionario.setTelefone("88888-7777");
		lan.adicionarFuncionario(funcionario);

		Funcionario f = lan.getFuncionario(0);
		assertEquals(funcionario, f);
	}
	
	@Test(expected = FuncionarioJaExisteException.class)
	public void adicionarFuncionarioNovamente(){
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Jhon");
		funcionario.setCpf("202.911.775-73");
		funcionario.setIdade(25);
		funcionario.setLogin("Jhon");
		funcionario.setTelefone("8888-7777");
		lan.adicionarFuncionario(funcionario);
		lan.adicionarFuncionario(funcionario);
	}
	
	@Test
	public void adicionarFuncionarioDiferente() {
		Funcionario funcionario1 = new Funcionario();
		funcionario1.setNome("Jhon");
		funcionario1.setCpf("202.911.775-73");
		funcionario1.setIdade(25);
		funcionario1.setLogin("Jhon");
		funcionario1.setTelefone("8888-7777");
		lan.adicionarFuncionario(funcionario1);
		Funcionario funcionario2 = new Funcionario();
		funcionario2.setNome("Rair");
		funcionario2.setCpf("176.892.318-37");
		funcionario2.setIdade(26);
		funcionario2.setLogin("Rair");
		funcionario2.setTelefone("8877-8877");
		lan.adicionarFuncionario(funcionario2);
		
		Funcionario f2 = lan.getFuncionario(1);
		assertEquals("Espera-se que o c2 seja o funcionario",
				f2, funcionario2);
	}
	
	@Test(expected = CampoInvalidoException.class)
	public void adicionarFuncionarioSemNome(){
		Funcionario funcionario = new Funcionario();
		funcionario.setCpf("176.892.318-37");
		funcionario.setIdade(26);
		funcionario.setLogin("Rair");
		funcionario.setTelefone("8877-8877");
		lan.adicionarFuncionario(funcionario);
	}
	
	@Test(expected = CampoInvalidoException.class)
	public void adicionarFuncionarioSemCpf(){
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Jefferson");
		funcionario.setLogin("Pelanka");
		funcionario.setTelefone("9999-8888");
		lan.adicionarFuncionario(funcionario);
	}
	
	@Test(expected = CampoInvalidoException.class)
	public void adicionarFuncionarioComCpfInvalido(){
		Funcionario f = new Funcionario();
		f.setNome("Jefferson");
		f.setCpf("12345");
		f.setLogin("Pelanka");
		f.setTelefone("9999-8888");
		lan.adicionarFuncionario(f);
	}

	@Test(expected = CampoInvalidoException.class)
	public void adicionarFuncionarioSemIdade(){
		Funcionario f = new Funcionario();
		f.setNome("Jefferson");
		f.setCpf("256.814393-21");
		f.setLogin("Pelanka");
		f.setTelefone("9999-8888");
		lan.adicionarFuncionario(f);
	}
	
	@Test(expected = CampoInvalidoException.class)
	public void adicionarFuncionarioSemLogin(){
		Funcionario f = new Funcionario();
		f.setNome("Jefferson");
		f.setCpf("256.814393-21");
		f.setIdade(23);
		f.setTelefone("9999-8888");
		lan.adicionarFuncionario(f);
	}
	
	@Test(expected = CampoInvalidoException.class)
	public void adicionarFuncionarioSemTelefone(){
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Jefferson");
		funcionario.setCpf("256.814393-21");
		funcionario.setIdade(23);
		funcionario.setLogin("Pelanka");
		lan.adicionarFuncionario(funcionario);
	}

	@Test(expected = ClienteInexistenteException.class)
	public void removerFuncionarioInexstente(){
		Funcionario f = new Funcionario();
		f.setNome("Jefferson");
		f.setCpf("256.814393-21");
		f.setIdade(23);
		f.setLogin("Pelanka");
		f.setTelefone("9999-8888");
		lan.adicionarFuncionario(f);
		
		f = new Funcionario();
		f.setNome("Ligeirinho");
		f.setCpf("915.161.843-51");
		f.setIdade(24);
		f.setLogin("Ligeirinho");
		f.setTelefone("8888-9999");
		lan.removeFuncionario(f);
	}
	
	private Endereco meuEndereco(){
		Endereco endereco = new Endereco();
		endereco.setRua("Av. Santa Elizabeth");
		endereco.setNumero("S/N");
		endereco.setBairro("Centro");
		endereco.setCidade("Rio Tinto");
		return endereco;
	}
}