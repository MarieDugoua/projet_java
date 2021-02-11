package starter;

import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import game.SlotMachineGame;
import gui.SlotMachineFrame;

public class SlotMachineStarter {

    public static void main( String[] args ) throws Exception {        
        // Try to set Nimbus look and feel
        UIManager.setLookAndFeel( new NimbusLookAndFeel() );

        // Start the demo
        SlotMachineGame smg = new SlotMachineGame();
        SlotMachineFrame smf = new SlotMachineFrame(smg);
        
        smf.setVisible( true );
    }
}
