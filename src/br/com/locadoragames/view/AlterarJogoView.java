package br.com.locadoragames.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import Contrutores.Acoes;
import br.com.locadoragames.bean.cadastroJogosBEAN;
import br.com.locadoragames.dao.cadastroJogosDao;

import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlterarJogoView extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtConsole;
	private JTextField txtGenero;
	protected int linha;

	public AlterarJogoView(int idCadastroJogo) {
		setTitle("***************  ALTERAR JOGO ***************");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		cadastroJogosBEAN cb = new cadastroJogosBEAN();
		cadastroJogosDao cd = new cadastroJogosDao();
		
		cd.obterDadosJogos(idCadastroJogo);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 649, 307);
		panel.setLayout(null);
		panel.setToolTipText("");
		contentPane.add(panel);
		
		txtNome = new JTextField(cb.getNomeJogo());
		txtNome.setOpaque(false);
		txtNome.setColumns(10);
		txtNome.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), new Color(0, 0, 0)), "Nome", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtNome.setBounds(10, 11, 181, 37);
		panel.add(txtNome);
		
		txtConsole = new JTextField(cb.getNomeConsole());
		txtConsole.setOpaque(false);
		txtConsole.setColumns(10);
		txtConsole.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), new Color(0, 0, 0)), "Console", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtConsole.setBounds(201, 11, 155, 37);
		panel.add(txtConsole);
	
		JTextField txtValor = new JTextField(String.valueOf(cb.getValorJogo()));
		txtValor.setOpaque(false);
		txtValor.setHorizontalAlignment(SwingConstants.CENTER);
		txtValor.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), new Color(0, 0, 0)), "Valor", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtValor.setBounds(34, 59, 120, 37);
		panel.add(txtValor);
		
		
		JTextField txtQuantidade = new JTextField(String.valueOf(cb.getEstoqueJogo()));	
		txtQuantidade.setOpaque(false);
		txtQuantidade.setHorizontalAlignment(SwingConstants.CENTER);
		txtQuantidade.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), new Color(0, 0, 0)), "Quantidade", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtQuantidade.setBounds(211, 59, 94, 37);
		panel.add(txtQuantidade);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("src/Imagens/path_of_exile_logo.png"));
		label.setBounds(366, 11, 273, 285);
		panel.add(label);
		
		JButton btnAlterarJogo = new JButton("Alterar");
		btnAlterarJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
			}
		});
		btnAlterarJogo.setIcon(new ImageIcon(AlterarJogoView.class.getResource("/Imagens/icons8-alterar-24.png")));
		btnAlterarJogo.setBounds(95, 155, 162, 49);
		panel.add(btnAlterarJogo);
		
		txtGenero = new JTextField(cb.getNomeGenero());
		txtGenero.setOpaque(false);
		txtGenero.setColumns(10);
		txtGenero.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), new Color(0, 0, 0)), "Genero", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtGenero.setBounds(110, 107, 127, 37);
		panel.add(txtGenero);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Acoes a = new Acoes();
				a.excluirJogo(linha);
				JOptionPane.showMessageDialog(null, "Excluido!");
				
			}
		});
		btnExcluir.setIcon(new ImageIcon(AlterarJogoView.class.getResource("/Imagens/icons8-delete-16.png")));
		btnExcluir.setBounds(131, 215, 106, 30);
		panel.add(btnExcluir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new cadastroJogosView().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setIcon(new ImageIcon(AlterarJogoView.class.getResource("/Imagens/icons8-voltar-16.png")));
		btnVoltar.setBounds(141, 256, 89, 23);
		panel.add(btnVoltar);
	}

}
