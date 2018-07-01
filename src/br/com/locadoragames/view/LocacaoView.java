package br.com.locadoragames.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.border.SoftBevelBorder;

import Contrutores.Acoes;

import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;

import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JEditorPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LocacaoView extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeCliente;
	private JTextField txtNomeJogo;
	private JTextField txtDias;
	private JTextField txtValor;
	protected int linha;

	 Acoes a = new Acoes();
	public LocacaoView() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon(LocacaoView.class.getResource("/Imagens/game-banner.png")));
		lblImagem.setBounds(0, 0, 728, 178);
		contentPane.add(lblImagem);
		
		JPanel pnlLocacao = new JPanel();
		pnlLocacao.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.GRAY, Color.BLACK, Color.BLACK));
		pnlLocacao.setBounds(0, 183, 350, 318);
		contentPane.add(pnlLocacao);
		pnlLocacao.setLayout(null);
		
		
		JPanel pnlJogos = new JPanel();
		pnlJogos.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), Color.GRAY, new Color(0, 0, 0), new Color(0, 0, 0)));
		pnlJogos.setBounds(0, 0, 102, 317);
		pnlLocacao.add(pnlJogos);
		
		MaskFormatter maskaraDias = null;
        try {
            // Create a MaskFormatter for accepting phone number, the # symbol accept
            // only a number. We can also set the empty value with a place holder
            // character.
        	maskaraDias = new MaskFormatter("##");
        	
        } catch (ParseException e) {
            e.printStackTrace();
        }
		pnlJogos.setLayout(null);
		
		JTable modelo = new JTable();
		JScrollPane barra = new JScrollPane(modelo);
		barra.setBounds(0, 0, 102, 317);
		pnlJogos.add(barra);
		
		modelo.setModel(a.listaDeJogos());
		
		
		JPanel pnlInfo = new JPanel();
		pnlInfo.setToolTipText("");
		pnlInfo.setBounds(103, 0, 247, 75);
		pnlLocacao.add(pnlInfo);
		pnlInfo.setLayout(null);
		
		JEditorPane tbpInformacoes = new JEditorPane();
		tbpInformacoes.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		tbpInformacoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbpInformacoes.setText("   Loca\u00E7\u00E3o Diaria R$ 3,00\r\n   7 Dias ou Mais R$ 2,00/Dia");
		tbpInformacoes.setBounds(0, 0, 247, 75);
		pnlInfo.add(tbpInformacoes);
		
		
		
		JPanel pnlDiasLocar = new JPanel();
		pnlDiasLocar.setBounds(103, 73, 247, 244);
		pnlLocacao.add(pnlDiasLocar);
		pnlDiasLocar.setLayout(null);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(10, 11, 221, 46);
		pnlDiasLocar.add(txtNomeCliente);
		txtNomeCliente.setOpaque(false);
		txtNomeCliente.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), new Color(0, 0, 0)), "Nome Cliente", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtNomeCliente.setColumns(10);
		
		txtNomeJogo = new JTextField();
		txtNomeJogo.setOpaque(false);
		txtNomeJogo.setColumns(10);
		txtNomeJogo.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), new Color(0, 0, 0)), "Nome Jogo", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtNomeJogo.setBounds(10, 54, 221, 46);
		pnlDiasLocar.add(txtNomeJogo);
		
		txtDias = new JTextField();
		txtDias.setOpaque(false);
		txtDias.setColumns(10);
		txtDias.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), new Color(0, 0, 0)), "Dias", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtDias.setBounds(81, 100, 62, 46);
		pnlDiasLocar.add(txtDias);
		
		JButton btnLocar = new JButton("");


		btnLocar.setToolTipText("Locar");

		btnLocar.setIcon(new ImageIcon("C:\\Users\\sopar\\eclipse-workspace\\LocadoraGames\\Imagens\\espada.png"));
		btnLocar.setBounds(67, 157, 89, 68);
		pnlDiasLocar.add(btnLocar);
		
		JPanel pnlResultado = new JPanel();
		pnlResultado.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		pnlResultado.setBounds(350, 183, 343, 154);
		contentPane.add(pnlResultado);
		pnlResultado.setLayout(null);
		pnlResultado.setVisible(true);
 
       
		JButton btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PrincipalView().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setToolTipText("Voltar");
		btnVoltar.setIcon(new ImageIcon(LocacaoView.class.getResource("/Imagens/icons8-voltar-16.png")));
		btnVoltar.setBounds(432, 462, 89, 23);
		contentPane.add(btnVoltar);
		
		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(446, 415, 138, 36);
		contentPane.add(txtValor);
		
		JLabel lblResultado = new JLabel("");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setIcon(new ImageIcon("C:\\Users\\sopar\\eclipse-workspace\\LocadoraGames\\Imagens\\icons8-moedas-48.png"));
		lblResultado.setBounds(446, 359, 138, 45);
		contentPane.add(lblResultado);
		
        JTable results = new JTable();
        JScrollPane barra1 = new JScrollPane(results);
 
        results.setModel(a.listaLocacao());
        
        barra1.setBounds(5, 5,338, 149);
        pnlResultado.add(barra1);
        
        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new LocacaoView().setVisible(true);
        	}
        });
        btnReset.setBounds(548, 462, 89, 23);
        contentPane.add(btnReset);
        
		btnLocar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Acoes a = new Acoes();
				
				String nomeCliente = txtNomeCliente.getText();
				String nomeJogo = txtNomeJogo.getText();
				int dias = Integer.parseInt(txtDias.getText());
		
				double valorNormal = dias * 3;
				double valor7Dias = dias * 2;		

				
				if(dias < 7) {
					txtValor.setText(String.valueOf("R$ " +valorNormal));;
				}else{
					txtValor.setText(String.valueOf("R$ " +valor7Dias));
				}
				String valor = txtValor.getText();
				a.locacao(nomeCliente, nomeJogo, dias, valor);
				results.setModel(a.listaLocacao());
				
			}
		});
     results.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			int linha = results.getSelectedRow();
			String nomeCliente = results.getValueAt(linha, 0).toString();
	        String nomeJogo = results.getValueAt(linha, 1).toString();
	        int dias =Integer.parseInt(results.getValueAt(linha, 2).toString());
	        
			DevolucaoView d = new DevolucaoView(nomeCliente, nomeJogo, dias);
			d.setVisible(true);
			dispose();
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	});   
	}
	
}
