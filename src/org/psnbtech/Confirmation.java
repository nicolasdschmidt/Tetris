package org.psnbtech;

import java.awt.*;

import javax.swing.*;

import bd.daos.Pontuacoes;
import bd.dbos.Pontuacao;

public class Confirmation extends JFrame {

	private static final long serialVersionUID = 8660452383821843285L;
	
	private static final Font FONT = new Font("Tahoma", Font.BOLD, 11);
	
	private ButtonPanel buttonPanel;
	
	private Submit submit;
	
	private String user;
	
	private int score;
	
	public Confirmation(Submit submit, String user, int score) {
		super("Verifique seus dados");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		this.submit = submit;
		this.buttonPanel = new ButtonPanel(this);
		
		this.user = user;
		this.score = score;
		
		Label lblVerifique = new Label("Isso está correto?");
		lblVerifique.setFont(FONT);
		
		Label lblUser = new Label("Nome: " + user);
		lblUser.setFont(FONT);
		Label lblScore = new Label(score + " pontos");
		lblScore.setFont(FONT);
		
		add(lblVerifique, BorderLayout.NORTH);
		add(lblUser, BorderLayout.WEST);
		add(lblScore, BorderLayout.EAST);
		add(buttonPanel, BorderLayout.SOUTH);
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void receiveEvent(String e) {
		if (e == "sim") {
			try {
				Pontuacoes.incluir(new Pontuacao(user, score));
			} catch (Exception ex) {
				System.out.println (ex.getMessage());
			}
			dispose();
			submit.dispose();
		} else if (e == "nao") {
			dispose();
		}
	}

}
