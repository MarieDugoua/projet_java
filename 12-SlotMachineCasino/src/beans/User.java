package beans;

import java.sql.Date;

public class User {
	
	private int nbPart;
	private int nbWon;
	private int npLost;
	private int moneyWagered;
	private Date date;
	
	public User(int nbPart, int nbWon, int npLost, int moneyWagered, Date date) {
		super();
		this.nbPart = nbPart;
		this.nbWon = nbWon;
		this.npLost = npLost;
		this.moneyWagered = moneyWagered;
		this.date = date;
	}

	public int getNbPart() {
		return nbPart;
	}

	public void setNbPart(int nbPart) {
		this.nbPart = nbPart;
	}

	public int getNbWon() {
		return nbWon;
	}

	public void setNbWon(int nbWon) {
		this.nbWon = nbWon;
	}

	public int getNpLost() {
		return npLost;
	}

	public void setNpLost(int npLost) {
		this.npLost = npLost;
	}

	public int getMoneyWagered() {
		return moneyWagered;
	}

	public void setMoneyWagered(int moneyWagered) {
		this.moneyWagered = moneyWagered;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	

}
