package br.com.locadoragames.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import br.com.locadoragames.bean.dadosUsuariosBean;
import br.com.locadoragames.dao.dadosUsuariosDao;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class cadastroLoginView extends JFrame {

	private JPanel cpCadastroLogin;
	private JTextField txtNomeCliente;
	private JTextField txtTelefone;
	private JTextField txtSenha;

	public cadastroLoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 342, 220);
		cpCadastroLogin = new JPanel();
		cpCadastroLogin.setBackground(Color.LIGHT_GRAY);
		cpCadastroLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(cpCadastroLogin);
		cpCadastroLogin.setLayout(null);
		
		dadosUsuariosDao dcd = new dadosUsuariosDao();
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNome.setBounds(24, 11, 58, 22);
		cpCadastroLogin.add(lblNome);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNomeCliente.setBounds(110, 11, 132, 23);
		cpCadastroLogin.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email :  ");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmail.setBounds(24, 81, 66, 22);
		cpCadastroLogin.add(lblEmail);
		
		JTextField txtEmailCliente = new JTextField();
		txtEmailCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmailCliente.setColumns(10);
		txtEmailCliente.setBounds(110, 81, 132, 23);
		cpCadastroLogin.add(txtEmailCliente);
		
		JLabel lblTelefone = new JLabel("Telefone : ");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTelefone.setBounds(24, 114, 88, 22);
		cpCadastroLogin.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(110, 114, 132, 23);
		cpCadastroLogin.add(txtTelefone);
		
		JButton btnBtncadastroUsuario = new JButton("Cadastro Usuario");
		btnBtncadastroUsuario.setFont(new Font("SansSerif", Font.BOLD, 11));
		btnBtncadastroUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Instanciar beam de usuarios
				dadosUsuariosBean dub = new dadosUsuariosBean();
				
				dub.setNomeDadosCliente(txtNomeCliente.getText());
				dub.setSenhaUsuario(txtSenha.getText());
				dub.setEmailDadosCliente(txtEmailCliente.getText());
				dub.setTelefoneDadosClientes(txtTelefone.getText());
				
				//executar metodo cadastro
				dadosUsuariosDao dud = new dadosUsuariosDao();
				dud.dadosClientes(dub);
				
				//limpar campos 
				txtNomeCliente.setText("");
				txtSenha.setText("");
				txtEmailCliente.setText("");
				txtTelefone.setText("");
				
				txtNomeCliente.requestFocus();
			}
		});
		btnBtncadastroUsuario.setBounds(110, 147, 132, 23);
		cpCadastroLogin.add(btnBtncadastroUsuario);
		
		JLabel lblSenha = new JLabel("Senha :");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSenha.setBounds(24, 48, 66, 22);
		cpCadastroLogin.add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSenha.setColumns(10);
		txtSenha.setBounds(110, 45, 132, 23);
		cpCadastroLogin.add(txtSenha);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginView lv = new LoginView();
				lv.setVisible(true);
			}
		});
		btnNewButton.setBounds(250, 147, 66, 23);
		cpCadastroLogin.add(btnNewButton);
	}
}
