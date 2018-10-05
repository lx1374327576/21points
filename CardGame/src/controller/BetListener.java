package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameGUI;

public class BetListener implements ActionListener{

	private static GameEngine gameEngine;
	private static List<Player> Splayers;
	private static JComboBox<Object> Cplayers;
	private static JTextArea Tbet;
	private static JTextArea Tsummary;
	private static GameGUI method;
	
	public  BetListener(GameEngine gameEngine,List<Player> Splayers,JComboBox<Object> Cplayers,
			JTextArea Tbet,JTextArea Tsummary,GameGUI method){
		this.gameEngine = gameEngine;
		this.Splayers = Splayers;
		this.Cplayers = Cplayers;
		this.Tbet = Tbet;
		this.Tsummary = Tsummary;
		this.method = method;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		boolean isBet = false;
		if(Splayers.isEmpty()) {
			return;
		}
		int index = Cplayers.getSelectedIndex();
		Player thePlayer = Splayers.get(index);
		int theBet = 100;
		if(thePlayer.getPoints()<theBet) {
			Splayers.remove(thePlayer);
			Cplayers.removeAllItems();
			for(Player player1: Splayers) {
				Cplayers.addItem(player1.getPlayerName());
			}
			Tsummary.setText("");
	        if(!Splayers.isEmpty()) {
	        	for(Player player1:Splayers) {
	        		String content = String.format("%s : %d\r\n", player1.getPlayerName(),player1.getPoints());
	        		Tsummary.append(content);
	        	}
	        }
			return;
		}
		if(!(thePlayer.getBet()==0)) {
			theBet = theBet + thePlayer.getBet();
			isBet = thePlayer.placeBet(theBet);
		}else {
			isBet = thePlayer.placeBet(theBet);
		}
		if(!isBet) {
			thePlayer.getPoints();
			JOptionPane.showMessageDialog(null, String.format("%s : Your balance is not sufficient", thePlayer.getPlayerName()), "ERROR", JOptionPane.ERROR_MESSAGE);
			return;
		}
		Tbet.setText("");
		for (Player player:Splayers) {
			if(!(player.getBet()==0)) {
				String content = String.format( "%s : %d",player.getPlayerName(), player.getBet());
				Tbet.append(content + "\r\n");
			}
		}
		
		
		
		
	}

}
