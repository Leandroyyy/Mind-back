package br.com.mind.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind.to.DenunciaTO;
import br.com.mind.to.ElogioTO;
import oracle.jdbc.pool.OracleDataSource;

public class ElogioDAO {

	private String connString = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	private Connection conn;
	public static List<ElogioTO> elogios;
	
	public ElogioDAO() throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL(connString);
		ods.setUser("rm86866");
		ods.setPassword("290396");
		
		conn = ods.getConnection();		
	}

	public List<ElogioTO> select() throws Exception{
		elogios = new ArrayList<ElogioTO>();
		String sql = "SELECT * FROM T_CLG_ELOGIO";
		
		PreparedStatement ps = conn.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("CD_ELOGIO");
			String elogio = rs.getString("DS_ELOGIO");
			int consulta = rs.getInt("CD_CONSULTA");
			
			ElogioTO elogiou = new ElogioTO();
			
			elogiou.setId(id);
			elogiou.setElogio(elogio);
			elogiou.setConsulta(consulta);
			
			elogios.add(elogiou);
		}
		
		return elogios;
	}
	
	public void insert(ElogioTO c) throws Exception{
		String sql = "INSERT INTO T_CLG_ELOGIO (CD_ELOGIO, DS_ELOGIO, CD_CONSULTA) VALUES (SQ_SLG_ELOGIO.NEXTVAL, ?, ?)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, c.getElogio());
		ps.setInt(2, 1);
		ps.execute();		
	}
}
