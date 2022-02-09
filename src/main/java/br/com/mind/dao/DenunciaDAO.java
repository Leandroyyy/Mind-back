package br.com.mind.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind.to.CadastroTo;
import br.com.mind.to.DenunciaTO;
import oracle.jdbc.pool.OracleDataSource;

public class DenunciaDAO {
	
	private String connString = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	private Connection conn;
	public static List<DenunciaTO> denuncias;

	public DenunciaDAO() throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL(connString);
		ods.setUser("rm86866");
		ods.setPassword("290396");
		
		conn = ods.getConnection();
	}
	
	public List<DenunciaTO> select() throws Exception{
		denuncias = new ArrayList<DenunciaTO>();
		String sql = "SELECT * FROM T_CLG_DENUNCIA";
		
		PreparedStatement ps = conn.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("CD_DENUNCIA");
			String acusacao = rs.getString("TX_ACUSACAO");
			int consulta = rs.getInt("CD_CONSULTA");
			
			DenunciaTO denuncia = new DenunciaTO();
			
			denuncia.setId(id);
			denuncia.setAcusacao(acusacao);
			denuncia.setConsulta(consulta);
			
			denuncias.add(denuncia);
		}
		
		return denuncias;
	}
	
	public void insert(DenunciaTO c) throws Exception{
		String sql = "INSERT INTO T_CLG_DENUNCIA (CD_DENUNCIA, TX_ACUSACAO, CD_CONSULTA) VALUES (SQ_SLG_DENUNCIA.NEXTVAL, ?, ?)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, c.getAcusacao());
		ps.setInt(2,1);
		ps.execute();		
	}

}
