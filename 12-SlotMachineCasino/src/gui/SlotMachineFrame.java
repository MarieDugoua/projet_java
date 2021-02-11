package gui;

import game.SlotMachineGame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;


@SuppressWarnings("serial")
public class SlotMachineFrame extends JFrame implements ActionListener {
		//Attribut fr type MorpionFrame
		private SlotMachineGame m_game;
		private JLabel image1, image2, image3;
		private JLabel Parties, PartiesGagnees, NombrePieces;
		// constructeur : récupère l'adresse de la frame et la stock
	
    public SlotMachineFrame(SlotMachineGame game) {
    	
    	m_game = game;
        this.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        this.setSize(900, 400);
        this.setLocationRelativeTo(null);
        
        JPanel contentPane = (JPanel) this.getContentPane();
        
        //contentPane.setLayout( new FlowLayout(FlowLayout.CENTER));
        contentPane.add(createStatusBar(), BorderLayout.SOUTH);
        
        
        image1 = new JLabel(new ImageIcon("./Users/marie/eclipse-workspace/12-SlotMachineCasino/images/" + m_game.slot1 +".png"));
        contentPane.add(image1, BorderLayout.WEST);
        image2 = new JLabel(new ImageIcon("./Users/marie/eclipse-workspace/12-SlotMachineCasino/images/" + m_game.slot2 +".png"));
        contentPane.add(image2, BorderLayout.CENTER);
        image3 = new JLabel(new ImageIcon("./Users/marie/eclipse-workspace/12-SlotMachineCasino/images/" + m_game.slot3 + ".png"));
        contentPane.add(image3, BorderLayout.EAST);
        
        
        JButton btnPlay = new JButton ("Play");
        btnPlay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				m_game.newGame();
				updateImage();
				updateText();
				
			}
		});
        contentPane.add(btnPlay, BorderLayout.NORTH);
       
    }  
    private JPanel createStatusBar() {
    	JPanel statusBar = new JPanel(new FlowLayout());
    	
    	Parties = new JLabel();
    	Parties.setText("Nombre de parties :" + m_game.nbParties);
        Parties.setPreferredSize(new Dimension(200, 40));
        statusBar.add(Parties);
        
        PartiesGagnees = new JLabel();
        PartiesGagnees.setText("Parties gagnées :" + m_game.winParties );
        PartiesGagnees.setPreferredSize(new Dimension(200, 40));
        statusBar.add(PartiesGagnees);
        
        NombrePieces = new JLabel();
        NombrePieces.setText("Nombre de pièces :" + m_game.pieces);
        NombrePieces.setPreferredSize(new Dimension(200, 40));
        statusBar.add(NombrePieces);
        
        return statusBar;
        
    }
    private void updateImage() {
   	 	image1.setIcon(new ImageIcon("./Users/marie/eclipse-workspace/12-SlotMachineCasino/images/" + m_game.slot1 +".png"));
   	 	image2.setIcon(new ImageIcon("./Users/marie/eclipse-workspace/12-SlotMachineCasino/images/" + m_game.slot2 +".png"));
   	 	image3.setIcon(new ImageIcon("./Users/marie/eclipse-workspace/12-SlotMachineCasino/images/" + m_game.slot3 + ".png"));
 
    }
    private void updateText() {
    	Parties.setText("Nombre de parties :" + m_game.nbParties);
    	NombrePieces.setText("Nombre de pièces :" + m_game.pieces);
    	PartiesGagnees.setText("Parties gagnées :" + m_game.winParties );
    }
	

}