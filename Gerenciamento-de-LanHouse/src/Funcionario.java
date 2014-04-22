
public class Funcionario {

	private String nome;
	private String cpf;
	private int idade;
	private String login;
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
	
	public String getLogin(){
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getTelefone(){
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
