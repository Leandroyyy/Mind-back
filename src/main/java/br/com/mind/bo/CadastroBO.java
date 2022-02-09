package br.com.mind.bo;

import java.util.List;

import br.com.mind.dao.CadastroDAO;
import br.com.mind.to.CadastroTo;

public class CadastroBO {

	private CadastroDAO ct;
	
	public List<CadastroTo> listar() throws Exception{
		ct = new CadastroDAO();
		return ct.selectAll();
	}	
	
	public List<CadastroTo> listarUsuarios() throws Exception{
		ct = new CadastroDAO();
		return ct.selectUsers();
	}	
	
	public List<CadastroTo> listarPsicologos() throws Exception{
		ct = new CadastroDAO();
		return ct.selectPsi();
	}	
	
	public List<CadastroTo> listarEstagiarios() throws Exception{
		ct = new CadastroDAO();
		return ct.selectIntern();
	}	
	
	public void cadastrar(CadastroTo cto) throws Exception {
		ct = new CadastroDAO();
		 ct.insert(cto);
	}
	
/* 	public CadastroTo listar(int id) throws Exception {
		ct = new CadastroDAO();
		return ct.select(id);
	}
	
	
	
	public void atualiza(CadastroTo cto) throws Exception {
		ct = new CadastroDAO();
		ct.update(cto);
	}
	
	public void deletar(int id) throws Exception {
		ct = new CadastroDAO();
		ct.delete(id);
	}*/
}
