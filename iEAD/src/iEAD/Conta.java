package iEAD;

public class Conta {
	private long telefone,
					cpf;
	private String login,
					nome,
					senha,
					endereco;
	
	public Conta() {
		
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setEndereco(String endereço) {
		this.endereco = endereco;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
	
	public long getTelefone(){
		return telefone;
	}
	
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	
	public long getCpf(){
		return cpf;
	}
}
