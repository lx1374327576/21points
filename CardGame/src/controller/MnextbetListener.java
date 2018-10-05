package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameGUI;

public class MnextbetListener implements ActionListener {
	
	private static GameEngine gameEngine;
	private static List<Player> Splayers;
	private static JTextArea Tsummary;
	private static JTextArea Tbet;
	private static JTextArea Thouse;
	private static JTextArea Tcard;
	private static GameGUI method;
	
	public MnextbetListener(GameEngine gameEngine,List<Player> Splayers,JTextArea Tsummary,JTextArea Tbet,
			JTextArea Thouse,JTextArea Tcard,GameGUI method) {
		this.gameEngine = gameEngine;
		this.Splayers = Splayers;
		this.Tsummary = Tsummary;
		this.Tbet = Tbet;
		this.Thouse = Thouse;
		this.Tcard = Tcard;
		this.method = method;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Tbet.setText("");
		Thouse.setText("");
		Tcard.setText("");
		Tsummary.setText("");
		method.Tplayer_information = new JPanel();
		method.house_ans = 0;
		if(Splayers.isEmpty()) {
			JOptionPane.showMessageDialog(null, "there is no player", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		for(Player player :Splayers) {
			player.setResult(0);
		}
        if(!Splayers.isEmpty()) {
        	for(Player player1:Splayers) {
        		String content = String.format("%s : %d\r\n", player1.getPlayerName(),player1.getPoints());
        		Tsummary.append(content);
        	}
        }
		
	}

}
