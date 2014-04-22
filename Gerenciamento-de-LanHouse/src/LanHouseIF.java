
public interface LanHouseIF {
	
	public void adicionarCliente(Cliente cliente);
	
	public Cliente getCliente(int i);
	
	public boolean existeCliente(Cliente cliente);
	
	public void removeCliente(Cliente cliente);
	
	public int quantidadeDeClientes();
	
	public void adicionarFuncionario(Funcionario funcionario);
	
	public Funcionario getFuncionario(int i);
	
	public void removeFuncionario(Funcionario f);
	
	public int quantidadeDeFuncionarios();
	
}
