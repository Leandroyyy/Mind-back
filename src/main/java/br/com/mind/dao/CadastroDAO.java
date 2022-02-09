package br.com.mind.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import br.com.mind.to.CadastroTo;
import oracle.jdbc.pool.OracleDataSource;

public class CadastroDAO{
	
	
	private String connString = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	private Connection conn;
	public static List<CadastroTo> cadastros;
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException exception) { /* Ignored */ }
	}
	
	public CadastroDAO() throws Exception{
		OracleDataSource ods = new OracleDataSource();
		ods.setURL(connString);
		ods.setUser("rm86866");
		ods.setPassword("290396");
		
		conn = ods.getConnection();
	}
	
	public List<CadastroTo> selectAll() throws Exception{
			cadastros = new ArrayList<CadastroTo>();
			String sqlUser = "SELECT * FROM T_CLG_USUARIO";
			String sqlPsi = "SELECT * FROM T_CLG_PSICOLOGO";
			String sqlInt = "SELECT * FROM T_CLG_ESTAGIARIO";
			PreparedStatement psUser = conn.prepareStatement(sqlUser);
			PreparedStatement psPsi = conn.prepareStatement(sqlPsi);
			PreparedStatement psInt = conn.prepareStatement(sqlInt);

			ResultSet rsUser = psUser.executeQuery();
			ResultSet rsPsi = psPsi.executeQuery();
			ResultSet rsInt = psInt.executeQuery();
			
			while(rsUser.next()) {
				int id = rsUser.getInt("CD_USUARIO");
				String nome = rsUser.getString("NM_USUARIO");
				String senha = rsUser.getString("DS_SENHA");
				String email = rsUser.getString("DS_EMAIL");
				String genero = rsUser.getString("DS_GENERO");
				String nascimento = rsUser.getString("DT_NASCIMENTO");
				
				CadastroTo usuario = new CadastroTo();
				usuario.setId(id);
				usuario.setNome(nome);
				usuario.setSenha(senha);
				usuario.setEmail(email);
				usuario.setGenero(genero);
				usuario.setDataNascimento(nascimento);
				cadastros.add(usuario);
			}
			
			while(rsPsi.next()) {
				int id = rsPsi.getInt("CD_PSICOLOGO");
				String nome = rsPsi.getString("NM_NOME");
				String senha = rsPsi.getString("DS_SENHA");
				String email = rsPsi.getString("DS_EMAIL");
				String genero = rsPsi.getString("DS_GENERO");
				String nascimento = rsPsi.getString("DT_NASCIMENTO");
				String crp = rsPsi.getString("NR_CRP");
				Long cpf = rsPsi.getLong("NR_CPF");
				Long telefone = rsPsi.getLong("NR_TELEFONE");
				String tempoConversa = rsPsi.getString("VL_DURACAO");
				String linhaTerapeutica = rsPsi.getString("DS_ABORDAGEM");
				String tempoUso = rsPsi.getString("DS_TEMPO_USO");
				
				CadastroTo psicologo = new CadastroTo();
				psicologo.setId(id);
				psicologo.setNome(nome);
				psicologo.setSenha(senha);
				psicologo.setEmail(email);
				psicologo.setGenero(genero);
				psicologo.setDataNascimento(nascimento);
				psicologo.setCrp(crp);
				psicologo.setCpf(cpf);
				psicologo.setTelefone(telefone);
				psicologo.setTempoConversa(tempoConversa);
				psicologo.setLinhaTerapeutica(linhaTerapeutica);
				psicologo.setTempoUso(tempoUso);
				cadastros.add(psicologo);
			}
			while(rsInt.next()) {
				int id = rsInt.getInt("CD_ESTAGIARIO");
				String nome = rsInt.getString("NM_NOME");
				String senha = rsInt.getString("DS_SENHA");
				String email = rsInt.getString("DS_EMAIL");
				String genero = rsInt.getString("DS_GENERO");
				String nascimento = rsInt.getString("DT_NASCIMENTO");
				String rm = rsInt.getString("DS_REGISTRO_MATRICULA");
				String instituicao = rsInt.getString("DS_INSTITUICAO");
				Long cpf = rsInt.getLong("NR_CPF");
				Long telefone = rsInt.getLong("NR_TELEFONE");
				String tempoConversa = rsInt.getString("VL_DURACAO");
				String linhaTerapeutica = rsInt.getNString("DS_ABORDAGEM");
				String tempoUso = rsInt.getString("DS_TEMPO_USO");
				
				CadastroTo estagiario = new CadastroTo();
				estagiario.setId(id);
				estagiario.setNome(nome);
				estagiario.setSenha(senha);
				estagiario.setEmail(email);
				estagiario.setGenero(genero);
				estagiario.setDataNascimento(nascimento);
				estagiario.setRm(rm);
				estagiario.setNomeInstituicao(instituicao);
				estagiario.setCpf(cpf);
				estagiario.setTelefone(telefone);
				estagiario.setTempoConversa(tempoConversa);
				estagiario.setLinhaTerapeutica(linhaTerapeutica);
				estagiario.setTempoUso(tempoUso);
				
				cadastros.add(estagiario);
			}
			
			return cadastros;
	}
	
	public List<CadastroTo> selectUsers() throws Exception{
		cadastros = new ArrayList<CadastroTo>();
		String sql = "SELECT * FROM T_CLG_USUARIO";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("CD_USUARIO");
			String nome = rs.getString("NM_USUARIO");
			String senha = rs.getString("DS_SENHA");
			String email = rs.getString("DS_EMAIL");
			String genero = rs.getString("DS_GENERO");
			String nascimento = rs.getString("DT_NASCIMENTO");
			
			CadastroTo usuario = new CadastroTo();
			usuario.setId(id);
			usuario.setNome(nome);
			usuario.setSenha(senha);
			usuario.setEmail(email);
			usuario.setGenero(genero);
			usuario.setDataNascimento(nascimento);
			cadastros.add(usuario);
		}
		return cadastros;
	}

	public List<CadastroTo> selectPsi() throws Exception{
		cadastros = new ArrayList<CadastroTo>();
		String sql = "SELECT * FROM T_CLG_PSICOLOGO";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("CD_PSICOLOGO");
			String nome = rs.getString("NM_NOME");
			String senha = rs.getString("DS_SENHA");
			String email = rs.getString("DS_EMAIL");
			String genero = rs.getString("DS_GENERO");
			String nascimento = rs.getString("DT_NASCIMENTO");
			String crp = rs.getString("NR_CRP");
			Long cpf = rs.getLong("NR_CPF");
			Long telefone = rs.getLong("NR_TELEFONE");
			String tempoConversa = rs.getString("VL_DURACAO");
			String linhaTerapeutica = rs.getString("DS_ABORDAGEM");
			String tempoUso = rs.getString("DS_TEMPO_USO");
			
			CadastroTo psicologo = new CadastroTo();
			psicologo.setId(id);
			psicologo.setNome(nome);
			psicologo.setSenha(senha);
			psicologo.setEmail(email);
			psicologo.setGenero(genero);
			psicologo.setDataNascimento(nascimento);
			psicologo.setCrp(crp);
			psicologo.setCpf(cpf);
			psicologo.setTelefone(telefone);
			psicologo.setTempoConversa(tempoConversa);
			psicologo.setLinhaTerapeutica(linhaTerapeutica);
			psicologo.setTempoUso(tempoUso);
			cadastros.add(psicologo);
		}
		return cadastros;
	}
	
	public List<CadastroTo> selectIntern() throws Exception{
		cadastros = new ArrayList<CadastroTo>();
		String sql = "SELECT * FROM T_CLG_ESTAGIARIO";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("CD_ESTAGIARIO");
			String nome = rs.getString("NM_NOME");
			String senha = rs.getString("DS_SENHA");
			String email = rs.getString("DS_EMAIL");
			String genero = rs.getString("DS_GENERO");
			String nascimento = rs.getString("DT_NASCIMENTO");
			String rm = rs.getString("DS_REGISTRO_MATRICULA");
			String instituicao = rs.getString("DS_INSTITUICAO");
			Long cpf = rs.getLong("NR_CPF");
			Long telefone = rs.getLong("NR_TELEFONE");
			String tempoConversa = rs.getString("VL_DURACAO");
			String linhaTerapeutica = rs.getNString("DS_ABORDAGEM");
			String tempoUso = rs.getString("DS_TEMPO_USO");
			
			CadastroTo estagiario = new CadastroTo();
			estagiario.setId(id);
			estagiario.setNome(nome);
			estagiario.setSenha(senha);
			estagiario.setEmail(email);
			estagiario.setGenero(genero);
			estagiario.setDataNascimento(nascimento);
			estagiario.setRm(rm);
			estagiario.setNomeInstituicao(instituicao);
			estagiario.setCpf(cpf);
			estagiario.setTelefone(telefone);
			estagiario.setTempoConversa(tempoConversa);
			estagiario.setLinhaTerapeutica(linhaTerapeutica);
			estagiario.setTempoUso(tempoUso);
			
			cadastros.add(estagiario);
		}
		return cadastros;
	}
	
		public void insert(CadastroTo c) throws Exception {

		  String sql;
		  
		  if(c.getCrp() == null && c.getRm() == null){
			  
			  sql = "INSERT INTO T_CLG_USUARIO (CD_USUARIO,NM_USUARIO, DS_SENHA, DS_EMAIL, DS_GENERO, DT_NASCIMENTO) "
			  		+ "VALUES (SQ_SLG_USUARIO.NEXTVAL, ?, ?, ?, ?, to_date(? ,'dd/mm/yyyy'))";
			  PreparedStatement ps = conn.prepareStatement(sql);
			    
			    ps.setString(1, c.getNome());
			    ps.setString(2, c.getSenha());
			    ps.setString(3, c.getEmail());
			    ps.setString(4, c.getGenero());
			    ps.setString(5, c.getDataNascimento());
			    
			    ps.execute();
		  }else if (c.getCrp() != null && c.getRm() == null){
			  sql = "INSERT INTO T_CLG_PSICOLOGO (CD_PSICOLOGO, "
			  		+ "NM_NOME, DS_SENHA, DS_EMAIL, DS_GENERO, NR_TELEFONE, NR_CPF, NR_CRP, VL_DURACAO, DS_TEMPO_USO, DT_NASCIMENTO, DS_ABORDAGEM"
			  		+ ") VALUES (SQ_SLG_PSICOLOGO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, to_date(? ,'dd/mm/yyyy'), ?)";
			  
			  PreparedStatement ps = conn.prepareStatement(sql);
			    
			    ps.setString(1, c.getNome());
			    ps.setString(2, c.getSenha());
			    ps.setString(3, c.getEmail());
			    ps.setString(4, c.getGenero());
			    ps.setLong(5, c.getTelefone());
			    ps.setLong(6, c.getCpf());
			    ps.setString(7, c.getCrp());
			    ps.setString(8, c.getTempoConversa());
			    ps.setString(9, c.getTempoUso());
			    ps.setString(10, c.getDataNascimento());
			    ps.setString(11, c.getLinhaTerapeutica());
			    
			    ps.execute();
		  }else {
			  sql = "INSERT INTO T_CLG_ESTAGIARIO (CD_ESTAGIARIO,NM_NOME, DS_SENHA, DS_EMAIL, DS_GENERO, NR_TELEFONE, NR_CPF, DS_REGISTRO_MATRICULA,"
			  		+ "DS_INSTITUICAO, VL_DURACAO, DS_TEMPO_USO, DT_NASCIMENTO, DS_ABORDAGEM) "
			  		+ "VALUES (SQ_SLG_ESTAGIARIO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, to_date(? ,'dd/mm/yyyy'), ?)";
			  
			  PreparedStatement ps = conn.prepareStatement(sql);
			  
			  ps.setString(1, c.getNome());
			    ps.setString(2, c.getSenha());
			    ps.setString(3, c.getEmail());
			    ps.setString(4, c.getGenero());
			    ps.setLong(5, c.getTelefone());
			    ps.setLong(6, c.getCpf());
			    ps.setString(7, c.getRm());
			    ps.setString(8, c.getNomeInstituicao());
			    ps.setString(9, c.getTempoConversa());
			    ps.setString(10, c.getTempoUso());
			    ps.setString(11, c.getDataNascimento());
			    ps.setString(12, c.getLinhaTerapeutica());
			    
			    ps.execute();
		  }    
		 
		  }
}
