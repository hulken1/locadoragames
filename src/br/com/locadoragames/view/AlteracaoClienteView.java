package br.com.locadoragames.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Contrutores.Acoes;
import br.com.locadoragames.bean.cadastroClientesBean;
import br.com.locadoragames.dao.cadastroClientesDao;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import javax.swing.JFormattedTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Frame;

public class AlteracaoClienteView extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtNumeroRes;
	protected int linha;
	private JTextField txtCPF;
	private JTextField txtNumeroResidencial;
	private JTextField txtNumeroCelular;
	
	public AlteracaoClienteView(String cpfCliente) {
		setTitle("********** Alterac\u00E3o Cliente **********");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		//riar objeto classes dao e bean
		cadastroClientesBean ccb = new cadastroClientesBean();
		cadastroClientesDao ccd = new cadastroClientesDao();
		
		ccb =  ccd.obterCadastroClientes(cpfCliente);
		
		
		JPanel pnlAlterarCliente = new JPanel();
		pnlAlterarCliente.setBounds(0, 0, 699, 261);
		contentPane.add(pnlAlterarCliente);
		pnlAlterarCliente.setLayout(null);
		
		JLabel lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon("src/Imagens/cadastro-clientes.png"));
		lblImagem.setBounds(449, 0, 230, 262);
		pnlAlterarCliente.add(lblImagem);
		
		txtNome = new JTextField(ccb.getNomeCliente());
		txtNome.setOpaque(false);
		txtNome.setFont(new Font("SansSerif", Font.BOLD, 13));
		txtNome.setColumns(10);
		txtNome.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), new Color(0, 0, 0)), "Nome", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtNome.setBounds(10, 0, 215, 50);		
		pnlAlterarCliente.add(txtNome);
		
		txtEndereco = new JTextField(ccb.getEnderecoCliente());
		txtEndereco.setOpaque(false);
		txtEndereco.setFont(new Font("SansSerif", Font.BOLD, 13));
		txtEndereco.setColumns(10);
		txtEndereco.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), new Color(0, 0, 0)), "Endereco", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtEndereco.setBounds(10, 61, 215, 50);
		
		pnlAlterarCliente.add(txtEndereco);
		
		
		
		txtNumeroRes = new JTextField(String.valueOf(ccb.getNumeroEndereco()));
		txtNumeroRes.setOpaque(false);
		txtNumeroRes.setFont(new Font("SansSerif", Font.BOLD, 13));
		txtNumeroRes.setColumns(10);
		txtNumeroRes.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), new Color(0, 0, 0)), "N\u00BA", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtNumeroRes.setBounds(245, 61, 88, 50);
		
		pnlAlterarCliente.add(txtNumeroRes);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setIcon(new ImageIcon(AlteracaoClienteView.class.getResource("/Imagens/icons8-alterar-24.png")));

		btnAlterar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, Color.BLACK, Color.BLACK));
		btnAlterar.setBounds(10, 182, 117, 38);
		pnlAlterarCliente.add(btnAlterar);
		
		
		

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CadastroClienteView().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setIcon(new ImageIcon(AlteracaoClienteView.class.getResource("/Imagens/icons8-voltar-16.png")));
		btnVoltar.setBounds(10, 227, 117, 23);
		pnlAlterarCliente.add(btnVoltar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(AlteracaoClienteView.class.getResource("/Imagens/icons8-delete-16.png")));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resposta = 0;
				resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir realmente ? ","",0);
					if(resposta == 0) {
						//Chamar o método para excluir
						ccd.excluirCadastroClientes(cpfCliente);
					
						//Fechar o JFrame
						dispose();
						
						//Chamar o outro JFrame
						CadastroClienteView ccv = new CadastroClienteView();
						ccv.setVisible(true);
										
					}
				
				
			}
			
		});
		btnExcluir.setBounds(137, 186, 117, 30);
		pnlAlterarCliente.add(btnExcluir);
		
		txtCPF = new JTextField(String.valueOf(ccb.getCpfCliente()));
		txtCPF.setEditable(false);
		txtCPF.setOpaque(false);
		txtCPF.setFont(new Font("SansSerif", Font.BOLD, 13));
		txtCPF.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), new Color(0, 0, 0)), "CPF", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtCPF.setBounds(235, 0, 119, 50);
		pnlAlterarCliente.add(txtCPF);
		
		txtNumeroResidencial = new JTextField(String.valueOf(ccb.getTelResidencial()));
		txtNumeroResidencial.setOpaque(false);
		txtNumeroResidencial.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumeroResidencial.setFont(new Font("SansSerif", Font.BOLD, 13));
		txtNumeroResidencial.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), new Color(0, 0, 0)), "Telefone Residencial", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtNumeroResidencial.setBounds(10, 122, 146, 50);
		pnlAlterarCliente.add(txtNumeroResidencial);
		
		txtNumeroCelular = new JTextField(String.valueOf(ccb.getTelCelular()));
		txtNumeroCelular.setOpaque(false);
		txtNumeroCelular.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumeroCelular.setFont(new Font("SansSerif", Font.BOLD, 13));
		txtNumeroCelular.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), new Color(0, 0, 0)), "Celular", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtNumeroCelular.setBounds(166, 122, 146, 50);
		pnlAlterarCliente.add(txtNumeroCelular);
		
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//classe bean clientes
				cadastroClientesBean ccb = new cadastroClientesBean();
				
				//obterdados
				ccb.setCpfCliente(cpfCliente);
				
				ccb.setNomeCliente(txtNome.getText());
				ccb.setEnderecoCliente(txtEndereco.getText());
				ccb.setNumeroEndereco(txtNumeroRes.getText());
				ccb.setTelResidencial(txtNumeroResidencial.getText());
				ccb.setTelCelular(txtNumeroCelular.getText());
				
				ccd.alterarCadastroClientes(ccb);
				
				JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
				
				dispose();
				
				CadastroClienteView ccv = new CadastroClienteView();
				ccv.setVisible(true);
			}
		});
	}
}
