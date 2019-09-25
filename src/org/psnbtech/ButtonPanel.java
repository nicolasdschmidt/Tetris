package org.psnbtech;

/*import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonPanel extends JPanel {

	private static final long serialVersionUID = 3034279817252025506L;
	
	private Confirmation confirmation;
	
	public ButtonPanel(Confirmation confirmation) {
		setBackground(Color.BLACK);
		setLayout(new BorderLayout());
		
		this.confirmation = confirmation;
		
		Button btnSim = new Button();
		btnSim.setLabel("Sim");
		btnSim.setForeground(Color.WHITE);
		btnSim.setBackground(Color.GREEN);
		btnSim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				confirmation.receiveEvent("sim");
			}
		});
		
		Button btnNao = new Button();
		btnNao.setLabel("Não");
		btnNao.setForeground(Color.WHITE);
		btnNao.setBackground(Color.RED);
		btnNao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				confirmation.receiveEvent("nao");
			}
		});
		
		add(btnSim, BorderLayout.EAST);
		add(btnNao, BorderLayout.WEST);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}
