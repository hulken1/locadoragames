package br.com.locadoragames.view;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import br.com.locadoragames.bean.cadastroJogosBEAN;
import br.com.locadoragames.dao.cadastroJogosDao;

import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;

public class cadastroJogosView extends JFrame {

	private JPanel pnlPrincipal;
	private JTextField txtNomeJogo;
	private JTextField txtConsole;
	private JTextField txtGenero;
	private JTable tblCadastroJogos;

	public cadastroJogosView() {
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
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 586);
		pnlPrincipal = new JPanel();
		pnlPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlPrincipal);
		this.setLocationRelativeTo(null);
		pnlPrincipal.setLayout(null);
		
		
		
		JLabel lblImagemCima = new JLabel("");
		lblImagemCima.setIcon(new ImageIcon(cadastroJogosView.class.getResource("/Imagens/game-banner.png")));
		lblImagemCima.setBounds(0, 0, 654, 183);
		pnlPrincipal.add(lblImagemCima);
		
		cadastroJogosDao cjd = new cadastroJogosDao();
		
		JTabbedPane tbpJogos = new JTabbedPane(JTabbedPane.TOP);
		tbpJogos.setBounds(0, 186, 654, 363);
		pnlPrincipal.add(tbpJogos);
		
		JPanel pnlCadastroJogos = new JPanel();
		pnlCadastroJogos.setToolTipText("");
		tbpJogos.addTab("Cadastro Jogo", null, pnlCadastroJogos, null);
		pnlCadastroJogos.setLayout(null);
		
		txtNomeJogo = new JTextField();
		txtNomeJogo.setBounds(10, 11, 181, 37);
		txtNomeJogo.setOpaque(false);
		txtNomeJogo.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), new Color(0, 0, 0)), "Nome", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlCadastroJogos.add(txtNomeJogo);
		txtNomeJogo.setColumns(10);
		
		txtConsole = new JTextField();
		txtConsole.setBounds(201, 11, 181, 37);
		txtConsole.setOpaque(false);
		txtConsole.setColumns(10);
		txtConsole.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), new Color(0, 0, 0)), "Console", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlCadastroJogos.add(txtConsole);
		
        
		JTextField txtQuantidade = new JTextField();
		txtQuantidade.setBounds(288, 59, 94, 37);
		txtQuantidade.setOpaque(false);
		txtQuantidade.setHorizontalAlignment(SwingConstants.CENTER);
		txtQuantidade.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), new Color(0, 0, 0)), "Quantidade", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlCadastroJogos.add(txtQuantidade);
		
		JTextField txtValor = new JTextField();
		txtValor.setOpaque(false);
		txtValor.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), new Color(0, 0, 0)), "Valor", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtValor.setBounds(10, 59, 131, 37);
		pnlCadastroJogos.add(txtValor);
		
		txtGenero = new JTextField();
		txtGenero.setOpaque(false);
		txtGenero.setColumns(10);
		txtGenero.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), new Color(0, 0, 0)), "Genero", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtGenero.setBounds(151, 59, 127, 37);
		pnlCadastroJogos.add(txtGenero);
		
		JLabel lblImagemDireita = new JLabel("");
		lblImagemDireita.setIcon(new ImageIcon("src/Imagens/path_of_exile_logo.png"));
		lblImagemDireita.setBounds(391, 11, 248, 313);
		pnlCadastroJogos.add(lblImagemDireita);
		
		JPanel pnlHistoricoJogos = new JPanel();
		tbpJogos.addTab("Historico Jogos", null, pnlHistoricoJogos, null);
		pnlHistoricoJogos.setLayout(null);

		JButton btnCadastroJogos = new JButton("");
		btnCadastroJogos.setToolTipText("Cadastro");
		btnCadastroJogos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				//Instanciar beans jogo
				cadastroJogosBEAN cb = new cadastroJogosBEAN();
				
				cb.setNomeJogo(txtNomeJogo.getText());
				cb.setValorJogo(Double.parseDouble(txtValor.getText()));
				cb.setEstoqueJogo(Integer.parseInt(String.valueOf(txtQuantidade.getText())));
				cb.setNomeGenero(txtGenero.getText());
				cb.setNomeConsole(txtConsole.getText());
				
				//executar o cadastro
				cadastroJogosDao cd = new cadastroJogosDao();
				cd.cadastroJogos(cb);
				
				//Limpar campos
				txtNomeJogo.setText("");
				txtValor.setText("");
				txtQuantidade.setText("");
				txtGenero.setText("");
				txtConsole.setText("");
				
				tblCadastroJogos.setModel(cd.listarCadastroJogos());
				
				//campo nome selecionado
				txtNomeJogo.requestFocus();
				
				
			}
		});
		btnCadastroJogos.setIcon(new ImageIcon("src/Imagens/icons8-mario-8-bit-filled-50.png"));
		btnCadastroJogos.setBounds(95, 165, 162, 59);
		pnlCadastroJogos.add(btnCadastroJogos);
		
		
		JScrollPane scrollJogos = new JScrollPane();
		
		scrollJogos.setBounds(10, 11, 629, 313);
		pnlHistoricoJogos.add(scrollJogos);
		
		tblCadastroJogos = new JTable();
		tblCadastroJogos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linhaSelecionada =  tblCadastroJogos.getSelectedRow();
				
				//obter idCadastroJogo
				int idCadastroJogo = (int) tblCadastroJogos.getValueAt(linhaSelecionada, 1);
				
				dispose();
				
				AlterarJogoView av = new AlterarJogoView(idCadastroJogo);
				av.setVisible(true);
			}
		});
		scrollJogos.setViewportView(tblCadastroJogos);
		JButton btnVoltar = new JButton("");
		btnVoltar.setToolTipText("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PrincipalView().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setIcon(new ImageIcon("src/Imagens/icons8-voltar-16.png"));
		btnVoltar.setBounds(10, 301, 89, 23);
		pnlCadastroJogos.add(btnVoltar);
		tblCadastroJogos.setModel(cjd.listarCadastroJogos());
	}
}
