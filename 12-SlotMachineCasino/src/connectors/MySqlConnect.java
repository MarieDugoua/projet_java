package connectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;

public class MySqlConnect {
	private Connection m_connexion;
		
	public MySqlConnect(String ip, String base, String login, String password) {
		try {
			String url = "jdbc:mysql://" + ip + "/" + base + "?serverTimezone=UTC";
			m_connexion = DriverManager.getConnection( url, login, password);
		} catch (Exception exc) {
			System.err.println("Constructeur : " + exc.getMessage());
		}	
	}
	
	public MySqlConnect(String base) {
		this("localhost:8889", base , "root" , "root");
	}
	
	public ResultSet select(String sql) {
		ResultSet res = null;
		try {
			Statement instruction = m_connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            res = instruction.executeQuery(sql);
            
		} catch (Exception exc) {
			System.err.println("Probléme sur requête '" + sql + "'");
		}
		return res;
	}
	
	// modifications
		public int update(String sql) {
			int res=-1;
			try {
				Statement stmt = m_connexion.createStatement();
				res=stmt.executeUpdate(sql);
			} catch(Exception exc) {
				System.err.println(getClass().getSimpleName()+
						"insereAI("+sql+") : "+exc.getMessage());
			}
			return res;
		}
		
		public int insert(String sql) {
			int res=-1;
			try {
				Statement stmt = m_connexion.createStatement();
				stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
				ResultSet rs = stmt.getGeneratedKeys();
				rs.next();
				res = rs.getInt(1);
			} catch(Exception exc) {
				System.err.println(getClass().getSimpleName()+
						"insereAI("+sql+") : "+exc.getMessage());
			}
			return res;
		}

}