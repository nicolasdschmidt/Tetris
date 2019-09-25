package org.psnbtech;

//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Dimension;

//import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Submit extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = -1366313491942138905L;
	
	private static final Font FONT = new Font("Tahoma", Font.BOLD, 11);
	
	private String user;
	private int score;
	
	private Label scoreText;
	private Label texto;
	private TextField txtUser;
	private Button btnSubmit;
	
	public Submit(int scoreRecebida) {
		super("Salvar pontuação");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		this.score = scoreRecebida;
		
		texto = new Label();
		texto.setText("Insira seu nome para salvar sua pontuação:");
		texto.setFont(FONT);
		
		scoreText = new Label();
		scoreText.setText(score + " pontos");
		scoreText.setFont(FONT);
		
		txtUser = new TextField();
		txtUser.setFont(FONT);
		
		btnSubmit = new Button();
		btnSubmit.setLabel("Enviar");
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setBackground(Color.BLUE);
		btnSubmit.addActionListener(this);
		
		add(texto, BorderLayout.NORTH);
		add(txtUser, BorderLayout.CENTER);
		add(scoreText, BorderLayout.EAST);
		add(btnSubmit, BorderLayout.SOUTH);
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		this.user = txtUser.getText().trim();
		new Confirmation(this, user, score);
	}
}
