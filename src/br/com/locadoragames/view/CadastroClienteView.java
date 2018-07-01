package br.com.locadoragames.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.Icon;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import Contrutores.Acoes;
import br.com.locadoragames.bean.cadastroClientesBean;
import br.com.locadoragames.dao.cadastroClientesDao;

import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.border.BevelBorder;
import java.awt.Font;

import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.awt.event.MouseAdapter;

public class CadastroClienteView extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtnResidencia;
	private JTable tblListarClientes;


	
	public CadastroClienteView() {
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
		setBounds(100, 100, 701, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		cadastroClientesDao ccd = new cadastroClientesDao();
		
		JLabel lblImagemCliente = new JLabel("");
		lblImagemCliente.setIcon(new ImageIcon(CadastroClienteView.class.getResource("/Imagens/game-banner.png")));
		lblImagemCliente.setBounds(0, 0, 685, 152);
		contentPane.add(lblImagemCliente);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 154, 685, 301);
		contentPane.add(tabbedPane);
	
		JPanel pnlCadastroCliente = new JPanel();
		pnlCadastroCliente.setToolTipText("");
		tabbedPane.addTab("Cadastro Cliente", null, pnlCadastroCliente, null);
		pnlCadastroCliente.setLayout(null);
		
		JFormattedTextField txtCPF = new JFormattedTextField();
		txtCPF.setFont(new Font("SansSerif", Font.BOLD, 13));
		txtCPF.setOpaque(false);
		txtCPF.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), new Color(0, 0, 0)), "CPF", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtCPF.setBounds(235, 0, 101, 50);
		pnlCadastroCliente.add(txtCPF);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("SansSerif", Font.BOLD, 13));
		txtNome.setOpaque(false);
		txtNome.setBounds(0, 0, 215, 50);
		txtNome.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), new Color(0, 0, 0)), "Nome", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlCadastroCliente.add(txtNome);
		txtNome.setColumns(10);
		
		txtEndereco = new JTextField();
		txtEndereco.setOpaque(false);
		txtEndereco.setFont(new Font("SansSerif", Font.BOLD, 13));
		txtEndereco.setColumns(10);
		txtEndereco.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), new Color(0, 0, 0)), "Endereco", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtEndereco.setBounds(0, 61, 215, 50);
		pnlCadastroCliente.add(txtEndereco);
	
		txtnResidencia = new JTextField();
		txtnResidencia.setOpaque(false);
		txtnResidencia.setFont(new Font("SansSerif", Font.BOLD, 13));
		txtnResidencia.setColumns(10);
		txtnResidencia.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), new Color(0, 0, 0)), "N\u00BA", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtnResidencia.setBounds(235, 61, 88, 50);
		pnlCadastroCliente.add(txtnResidencia);
	
		JFormattedTextField txtNumeroResidencial = new JFormattedTextField();
		txtNumeroResidencial.setOpaque(false);
		txtNumeroResidencial.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumeroResidencial.setFont(new Font("SansSerif", Font.BOLD, 13));
		txtNumeroResidencial.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), new Color(0, 0, 0)), "Telefone Residencial", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtNumeroResidencial.setBounds(0, 122, 146, 50);
		pnlCadastroCliente.add(txtNumeroResidencial);

        
		JFormattedTextField txtCelular = new JFormattedTextField();
		txtCelular.setOpaque(false);
		txtCelular.setHorizontalAlignment(SwingConstants.CENTER);
		txtCelular.setFont(new Font("SansSerif", Font.BOLD, 13));
		txtCelular.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), new Color(0, 0, 0)), "Celular", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtCelular.setBounds(156, 122, 146, 50);
		pnlCadastroCliente.add(txtCelular);
		
         
		JButton btnCadastro = new JButton("");
		btnCadastro.setToolTipText("Cadastro");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						
				//Instanciar cadastroClienteBean
				cadastroClientesBean ccb = new cadastroClientesBean();
				ccb.setNomeCliente(txtNome.getText());
				ccb.setCpfCliente(txtCPF.getText());
				ccb.setEnderecoCliente(txtEndereco.getText());
				ccb.setNumeroEndereco(txtnResidencia.getText());
				ccb.setTelResidencial(txtNumeroResidencial.getText());
				ccb.setTelCelular(txtCelular.getText().toString());
				
				// Executar método de cadastro
				cadastroClientesDao ccd = new cadastroClientesDao();
				ccd.cadastroClientes(ccb);
				
				//Limpar campos
				txtNome.setText("");
				txtCPF.setText("");
				txtEndereco.setText("");
				txtnResidencia.setText("");
				txtNumeroResidencial.setText("");
				txtCelular.setText("");
				//Atualizar a table
				tblListarClientes.setModel(ccd.listarClientesCadastrados());
				
				//cursor campo nome
				txtNome.requestFocus();
			}
		});
		btnCadastro.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, Color.BLACK, Color.BLACK));
		btnCadastro.setIcon(new ImageIcon(CadastroClienteView.class.getResource("/Imagens/icons8-adicionar-usu\u00E1rio-masculino-26.png")));
		btnCadastro.setBounds(237, 183, 156, 44);
		pnlCadastroCliente.add(btnCadastro);
		
		JLabel lblImagemDireita = new JLabel("");
		lblImagemDireita.setIcon(new ImageIcon("src/Imagens/cadastro-clientes.png"));
		lblImagemDireita.setBounds(415, 0, 255, 262);
		pnlCadastroCliente.add(lblImagemDireita);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.setToolTipText("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PrincipalView().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setIcon(new ImageIcon(CadastroClienteView.class.getResource("/Imagens/icons8-voltar-16.png")));
		btnVoltar.setBounds(276, 239, 89, 23);
		pnlCadastroCliente.add(btnVoltar);
		
		JPanel pnlHistoricoCliente = new JPanel();
		tabbedPane.addTab("Historico Cliente", (Icon) null, pnlHistoricoCliente, null);
		pnlHistoricoCliente.setLayout(null);
		
		
		
		JScrollPane scrollClientes = new JScrollPane();
		scrollClientes.setBounds(10, 11, 660, 251);
		pnlHistoricoCliente.add(scrollClientes);
		
		tblListarClientes = new JTable();
		tblListarClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int linhaSelecionada = tblListarClientes.getSelectedRow();
				
				//obter idcliente
				String idCadastroClientes = (String) tblListarClientes.getValueAt(linhaSelecionada, 1);
				
				dispose();
				
				AlteracaoClienteView acv = new AlteracaoClienteView(idCadastroClientes);
				acv.setVisible(true);
				
				
			}
		});
		tblListarClientes.setBounds(10, 11, 660, 251);
		//pnlHistoricoCliente.add(tblListarClientes);
		tblListarClientes.setModel(ccd.listarClientesCadastrados());
		scrollClientes.setViewportView(tblListarClientes);
		
	}
}
