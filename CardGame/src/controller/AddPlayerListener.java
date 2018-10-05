package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextArea;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameGUI;

public class AddPlayerListener implements ActionListener {
	private static GameEngine gameEngine;
	private static List<Player> Splayers;
	private static JComboBox<Object> Cplayers;
	private static JTextArea Tsummary;
	private static GameGUI method;

	public AddPlayerListener(GameEngine gameEngine,List<Player> Splayers,JComboBox<Object> Cplayers,JTextArea tsummary2,GameGUI method) {
		this.gameEngine = gameEngine;
		this.Splayers = Splayers;
		this.Cplayers = Cplayers;
		this.Tsummary = tsummary2;
		this.method = method;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("add one!");
		int tmp=method.getPlayerNumber();
		Player player=new SimplePlayer(Integer.toString(tmp+1),"tsy"+Integer.toString(tmp+1),(int)(1+Math.random()*10)*100);
		gameEngine.addPlayer(player);
        Splayers.add(player);
        Cplayers.addItem(player.getPlayerName());
        Tsummary.setText("");
        if(!Splayers.isEmpty()) {
        	for(Player player1:Splayers) {
        		String content = String.format("%s : %d\r\n", player1.getPlayerName(),player1.getPoints());
        		Tsummary.append(content);
        	}
        }

	}

}
