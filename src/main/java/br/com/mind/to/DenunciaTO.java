package br.com.mind.to;

public class DenunciaTO {

	private int id;
	private String acusacao;
	private int consulta;
	
	public DenunciaTO() {
		super();
	}

	public DenunciaTO(int id, String acusacao, int consulta) {
		super();
		this.id = id;
		this.acusacao = acusacao;
		this.consulta = consulta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAcusacao() {
		return acusacao;
	}

	public void setAcusacao(String acusacao) {
		this.acusacao = acusacao;
	}

	public int getConsulta() {
		return consulta;
	}

	public void setConsulta(int consulta) {
		this.consulta = consulta;
	}

	
	
}
