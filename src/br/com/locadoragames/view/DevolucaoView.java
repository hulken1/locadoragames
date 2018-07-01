package br.com.locadoragames.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import Contrutores.Acoes;

import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.border.SoftBevelBorder;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DevolucaoView extends JFrame {

	private JPanel contentPane;
	protected int linha;
	private JTextField txtNome;
	private JTextField txtNomeJogo;

	public DevolucaoView(String nomeCliente, String nomeJogo, int dias) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 413, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel pnlDevolucao = new JPanel();
		pnlDevolucao.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.GRAY, Color.BLACK, Color.GRAY));
		pnlDevolucao.setBounds(0, 0, 397, 104);
		contentPane.add(pnlDevolucao);
		pnlDevolucao.setLayout(null);
		
		txtNome = new JTextField(nomeCliente);
		txtNome.setOpaque(false);
		txtNome.setColumns(10);
		txtNome.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), new Color(0, 0, 0)), "Nome Cliente", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtNome.setBounds(72, 0, 221, 46);
		pnlDevolucao.add(txtNome);
		
		txtNomeJogo = new JTextField(nomeJogo);
		txtNomeJogo.setOpaque(false);
		txtNomeJogo.setColumns(10);
		txtNomeJogo.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), new Color(0, 0, 0)), "Nome Jogo", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtNomeJogo.setBounds(72, 43, 221, 46);
		pnlDevolucao.add(txtNomeJogo);
		Acoes a = new Acoes();
		
	        JButton btnDevolver = new JButton("");
	        btnDevolver.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Acoes a = new Acoes();
	        		a.devolver(linha);
	        		JOptionPane.showMessageDialog(null, "Devolvido!");
	        		
	        	}
	        });
	        btnDevolver.setToolTipText("Devolver");
	        btnDevolver.setIcon(new ImageIcon(DevolucaoView.class.getResource("/Imagens/icons8-delete-16.png")));
	        btnDevolver.setBounds(137, 161, 89, 38);
	        contentPane.add(btnDevolver);
	        
	        JButton btnVoltar = new JButton("");
	        btnVoltar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		new LocacaoView().setVisible(true);
	        		dispose();
	        	}
	        });
	        btnVoltar.setIcon(new ImageIcon(DevolucaoView.class.getResource("/Imagens/icons8-voltar-16.png")));
	        btnVoltar.setToolTipText("Voltar");
	        btnVoltar.setBounds(137, 210, 89, 23);
	        contentPane.add(btnVoltar);

	}
}
