package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameGUI;

public class MrestartListener implements ActionListener {
	
	private static GameEngine gameEngine;
	private static List<Player> Splayers;
	private static JComboBox<Object> Cplayers;
	private static JTextArea Tsummary;
	private static JTextArea Tbet;
	private static JTextArea Thouse;
	private static JTextArea Tcard;
	private static GameGUI method;
	
	public MrestartListener(GameEngine gameEngine,List<Player> Splayers,JComboBox<Object> Cplayers,JTextArea Tsummary,JTextArea Tbet,
			JTextArea Thouse,JTextArea Tcard,GameGUI method) {
		this.gameEngine = gameEngine;
		this.Splayers = Splayers;
		this.Cplayers = Cplayers;
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
		Splayers.clear();
		Cplayers.removeAllItems();
		method.Tplayer_information = new JPanel();
		method.house_ans = 0;
		
		
	}

}

