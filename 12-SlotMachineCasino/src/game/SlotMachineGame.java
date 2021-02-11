package game;


import connectors.MySqlConnect;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SlotMachineGame {
	public int slot1 = 1;
	public int slot2 = 1;
	public int slot3 = 1;
	public int pieces = 100;
	public int nbParties;
	public int winParties;
	public int lostParties;
	public LocalDate date;

	
	public void newGame() {
		Random randgenerator = new Random();
		
		LocalDateTime date = LocalDateTime.now();
	    System.out.println("Before formatting: " + date);
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	    String formattedDate = date.format(myFormatObj);
	    System.out.println("After formatting: " + formattedDate);

        
		slot1 = randgenerator.nextInt(9) + 1;
		slot2 = randgenerator.nextInt(9) + 1;
		slot3 = randgenerator.nextInt(9) + 1;
	
		System.out.println(slot1 + " " + slot2 + " " + slot3);
		
		if(slot1 == slot2 && slot2 == slot3) {
			System.out.println("Win 10 pieces");
			pieces += 10;
			nbParties += 1;
			winParties +=1;
			lostParties = nbParties - winParties;
		} else if (slot1 == slot2 || slot1 == slot3 || slot2 == slot3) {
			System.out.println("Win 5 pieces");
			pieces += 5;
			nbParties += 1;
			winParties +=1;
			lostParties = nbParties - winParties;
		} else {
			System.out.println("Loose 2 pieces");
			pieces -= 2;
			nbParties += 1;
			lostParties += 1;
		}
		
		MySqlConnect connect = new MySqlConnect("slotMachine");

		try {
			
			int rs = connect.insert("INSERT INTO users (nbPart, nbWon, nbLost, moneyWagered) VALUE  (" + nbParties + "," + winParties + "," + lostParties + "," + pieces + ")");
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}

}
