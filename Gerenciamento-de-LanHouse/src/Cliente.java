
public class Cliente {

	private String nome;
	private String cpf;
	private int idade;
	private Endereco endereco;
	private String telefone;
	
	public String getNome(){
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf){
		this.cpf = cpf;
	}
	
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade){
		this.idade = idade;
	}
	
	public Endereco getEndereco(){
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public String getTelefone(){
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
