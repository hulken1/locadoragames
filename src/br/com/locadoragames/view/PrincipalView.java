package br.com.locadoragames.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PrincipalView extends JFrame {

	private JPanel contentPane;

	int nivel;
	
	public PrincipalView() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (e.getID() == WindowEvent.WINDOW_CLOSING){
					int selectedOption = JOptionPane.showConfirmDialog(null,"Deseja Sair Realmente?", "Sistema informa:", JOptionPane.YES_NO_OPTION);
	if(selectedOption == JOptionPane.YES_OPTION){
		System.exit(0);  	                	
	}	
				}	
			}
		});
		
	
		setTitle("**************** LOCADORA DO GUTAO ********");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 670, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.setFocusPainted(false);
		btnClientes.setBorderPainted(false);
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CadastroClienteView().setVisible(true);
				dispose();
			}
		});
		btnClientes.setIcon(new ImageIcon(PrincipalView.class.getResource("/Imagens/icons8-m\u00E1scara-dos-anonymous-50.png")));
		btnClientes.setBounds(0, 176, 137, 59);
		contentPane.add(btnClientes);
		
		JButton btnJogos = new JButton("Jogos");
		btnJogos.setBorderPainted(false);
		btnJogos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new cadastroJogosView().setVisible(true);
				dispose();
			}
		});
		btnJogos.setIcon(new ImageIcon(PrincipalView.class.getResource("/Imagens/icons8-mario-8-bit-filled-50.png")));
		btnJogos.setBounds(224, 176, 137, 59);
		contentPane.add(btnJogos);
		
		JButton btnLocao = new JButton("Loca\u00E7\u00E3o");
		btnLocao.setBorderPainted(false);
		btnLocao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LocacaoView().setVisible(true);
				dispose();
			}
		});
		btnLocao.setIcon(new ImageIcon(PrincipalView.class.getResource("/Imagens/icons8-cole\u00E7\u00E3o-de-cds-50.png")));
		btnLocao.setBounds(441, 176, 137, 59);
		contentPane.add(btnLocao);
		
		JLabel lblImagemPrincipal = new JLabel("");
		lblImagemPrincipal.setIcon(new ImageIcon(PrincipalView.class.getResource("/Imagens/game-banner.png")));
		lblImagemPrincipal.setBounds(0, 0, 654, 175);
		contentPane.add(lblImagemPrincipal);
		
		JLabel lblImagemBaixo = new JLabel("");
		lblImagemBaixo.setIcon(new ImageIcon(PrincipalView.class.getResource("/Imagens/de30bdc3237ed1d09edcea4534e60c4b--xbox-one-games-videogames.jpg")));
		lblImagemBaixo.setBounds(0, 176, 654, 380);
		contentPane.add(lblImagemBaixo);
	}
}
