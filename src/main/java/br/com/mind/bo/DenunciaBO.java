package br.com.mind.bo;

import java.util.List;

import br.com.mind.dao.DenunciaDAO;
import br.com.mind.to.DenunciaTO;

public class DenunciaBO {

	private DenunciaDAO ct;
	
	public List<DenunciaTO> listar() throws Exception{
		ct = new DenunciaDAO();
		return ct.select();
	}	
	
	public void cadastrar(DenunciaTO cto) throws Exception {
		ct = new DenunciaDAO();
		ct.insert(cto);
	}

}
