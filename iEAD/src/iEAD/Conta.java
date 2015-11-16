package iEAD;

public class Conta {
	private int telefone;
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
	
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	public int getTelefone(){
		return telefone;
	}

}
