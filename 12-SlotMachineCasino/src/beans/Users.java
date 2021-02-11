package beans;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectors.MySqlConnect;

public class Users {
	private ArrayList<User> u_list = new ArrayList<User>();
	
	public Users() throws SQLException {
		
		MySqlConnect connect = new MySqlConnect("slotMachine");
		
		ResultSet resUsers = connect.select("SELECT DISTINCT * FROM users ORDER BY date");
		
		while(resUsers.next()) {
			
			int nbPart = resUsers.getInt("nbPart");
			int nbWon = resUsers.getInt("nbWon");
			int nbLost = resUsers.getInt("nbLost");
			int moneyWagered = resUsers.getInt("moneyWagered");
			Date date = resUsers.getDate("date");
			
			User u = new User(nbPart, nbWon, nbLost, moneyWagered, date);
			u_list.add(u);
		}
	}
	public ArrayList<User> getList() {
		return u_list;
	}
}
