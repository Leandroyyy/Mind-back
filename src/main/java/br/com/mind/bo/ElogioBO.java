package br.com.mind.bo;

import java.util.List;

import br.com.mind.dao.ElogioDAO;
import br.com.mind.to.ElogioTO;

public class ElogioBO {

private ElogioDAO ct;
	
	public List<ElogioTO> listar() throws Exception{
		ct = new ElogioDAO();
		return ct.select();
	}	
	
	public void cadastrar(ElogioTO cto) throws Exception {
		ct = new ElogioDAO();
		ct.insert(cto);
	}

}
