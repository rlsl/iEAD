package iEAD;

public class Mensagem {
	
	private boolean leitura;
	private String remetente,
					destinatario,
					recado;
	
	public Mensagem() {
		
	}
	
	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}
	
	public String getRemetente() {
		return remetente;
	}
	
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	
	public String getDestinatario() {
		return destinatario;
	}
	
	public void setRecado(String recado) {
		this.recado = recado;
	}
	
	public String getRecado() {
		return recado;
	}
	
	public void setLeitura(boolean leitura) {
		this.leitura = leitura;
	}
	
	public boolean getLeitura() {
		return leitura;
	}

}
