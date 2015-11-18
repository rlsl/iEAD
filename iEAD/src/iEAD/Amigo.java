package iEAD;

public class Amigo {
	
	private boolean status;
	private String conta, amigo;
	
	public Amigo() {
		
	}
	
	public void setAmigo(String amigo) {
		this.amigo = amigo;
	}
	
	public String getAmigo() {
		return amigo;
	}
	
	public void setConta(String conta) {
		this.conta = conta;
	}
	
	public String getConta() {
		return conta;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public boolean getStatus() {
		return status;
	}
}
