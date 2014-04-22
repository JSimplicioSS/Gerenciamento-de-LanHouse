
public class LanHouse implements LanHouseIF{

	Cliente [] clientes;
	Funcionario [] funcionarios;
	int contClientes = 0;
	int contFuncionarios = 0;

	public LanHouse(){
		clientes  = new Cliente[1000];
		funcionarios = new Funcionario[100];
	}

	public void adicionarCliente(Cliente cliente) {
		if(existeCliente(cliente)){
			throw new ClienteJaExisteException("Cliente ja cadastrado.");
		}
		if(cliente.getNome()==null){
			throw new CampoInvalidoException("Cliente sem nome.");
		}
		if(cliente.getCpf()==null){
			throw new CampoInvalidoException("Cliente sem CPF.");
		}
		if(!validaCPF(cliente.getCpf())){
			throw new CampoInvalidoException("CPF invalido.");
		}
		if(cliente.getIdade()==0){
			throw new CampoInvalidoException("Cliente sem idade.");
		}
		if(cliente.getEndereco()==null){
			throw new CampoInvalidoException("Cliente sem endereco.");
		}
		if(cliente.getTelefone()==null){
			throw new CampoInvalidoException("Cliente sem telefone.");
		}
		clientes[contClientes]=cliente;
		contClientes ++;
	}

	private boolean validaCPF(String strCpf){
		int iDigito1Aux = 0, iDigito2Aux = 0, iDigitoCPF;
		int iDigito1 = 0, iDigito2 = 0, iRestoDivisao = 0;
		String strDigitoVerificador, strDigitoResultado;

		if (! strCpf.substring(0,1).isEmpty()){
			try{
				strCpf = strCpf.replace('.',' ');
				strCpf = strCpf.replace('-',' ');
				strCpf = strCpf.replaceAll(" ","");
				for (int iCont = 1; iCont < strCpf.length() -1; iCont++) {
					iDigitoCPF = Integer.valueOf(strCpf.substring(iCont -1, iCont)).intValue();
					iDigito1Aux = iDigito1Aux + (11 - iCont) * iDigitoCPF;
					iDigito2Aux = iDigito2Aux + (12 - iCont) * iDigitoCPF;
				}
				iRestoDivisao = (iDigito1Aux % 11);
				if (iRestoDivisao < 2) {
					iDigito1 = 0;
				} else {
					iDigito1 = 11 - iRestoDivisao;
				}
				iDigito2Aux += 2 * iDigito1;
				iRestoDivisao = (iDigito2Aux % 11);
				if (iRestoDivisao < 2) {
					iDigito2 = 0;
				} else {
					iDigito2 = 11 - iRestoDivisao;
				}
				strDigitoVerificador = strCpf.substring(strCpf.length()-2, strCpf.length());
				strDigitoResultado = String.valueOf(iDigito1) + String.valueOf(iDigito2);
				return strDigitoVerificador.equals(strDigitoResultado);
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}

	public Cliente getCliente(int i) {
		return clientes[i];
	}

	public boolean existeCliente(Cliente cliente){
		boolean existe = false;
		for(Cliente c: clientes){
			if(c!=null){
				if(c.equals(cliente)){
					existe = true;
				}
			}
		}
		return existe;
	}

	public void removeCliente(Cliente cliente) {
		if(quantidadeDeClientes() == 0){
			throw new ClienteInexistenteException("Não existe cliente para remover.");
		}
		if(!existeCliente(cliente)){
			throw new ClienteInexistenteException("Cliente inexistente.");
		}
		remove(cliente);
	}

	private void remove(Cliente cliente) {
		for (int i = 0; i < quantidadeDeClientes(); i++) {
			if(clientes[i].equals(cliente)){
				clientes[i]=null;
				contClientes--;
				break;
			}
		}
	}

	public int quantidadeDeClientes() {
		return contClientes;
	}

	public void adicionarFuncionario(Funcionario funcionario) {
		if(existeFuncionario(funcionario)){
			throw new FuncionarioJaExisteException("Funcionario ja cadastrado.");
		}
		if(funcionario.getNome()==null){
			throw new CampoInvalidoException("Funcionario sem nome.");
		}
		if(funcionario.getCpf()==null){
			throw new CampoInvalidoException("Funcionario sem CPF.");
		}
		if(!validaCPF(funcionario.getCpf())){
			throw new CampoInvalidoException("CPF invalido.");
		}
		if(funcionario.getIdade()==0){
			throw new CampoInvalidoException("Funcionario sem idade.");
		}
		if(funcionario.getLogin()==null){
			throw new CampoInvalidoException("Funcionario sem login.");
		}
		if(funcionario.getTelefone()==null){
			throw new CampoInvalidoException("Funcionario sem telefone.");
		}
		funcionarios[contFuncionarios]=funcionario;
		contFuncionarios ++;
	}

	private boolean existeFuncionario(Funcionario funcionario) {
		boolean existe = false;
		for(Funcionario f: funcionarios){
			if(f!=null){
				if(f.equals(funcionario)){
					existe = true;
				}
			}
		}
		return existe;
	}

	public Funcionario getFuncionario(int i) {
		return funcionarios[i];
	}

	public void removeFuncionario(Funcionario f) {
		if(quantidadeDeClientes() == 0){
			throw new ClienteInexistenteException("Não existe funcionario para remover.");
		}
		if(!existeFuncionario(f)){
			throw new ClienteInexistenteException("Funcionario inexistente.");
		}
		removerFuncionario(f);	}

	private void removerFuncionario(Funcionario f) {
		for (int i = 0; i < quantidadeDeClientes(); i++) {
			if(funcionarios[i].equals(f)){
				funcionarios[i]=null;
				contFuncionarios--;
				break;
			}
		}	
	}

	public int quantidadeDeFuncionarios() {
		return contFuncionarios;
	}
}
