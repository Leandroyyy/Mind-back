package br.com.mind.to;

public class ElogioTO {
	
	private int id;
	private String elogio;
	private int consulta;

	public ElogioTO() {
	}

	public ElogioTO(int id, String elogio) {
		super();
		this.id = id;
		this.elogio = elogio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getElogio() {
		return elogio;
	}

	public void setElogio(String elogio) {
		this.elogio = elogio;
	}

	public int getConsulta() {
		return consulta;
	}

	public void setConsulta(int consulta) {
		this.consulta = consulta;
	}
	
	
}
