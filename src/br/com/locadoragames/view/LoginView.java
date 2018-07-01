package br.com.locadoragames.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Contrutores.Login;
import br.com.locadoragames.bean.loginUserBean;
import br.com.locadoragames.dao.dadosUsuariosDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeUsuario;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFocusPainted(false);
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBorderPainted(false);
		btnCadastrar.setBackground(new Color(102, 51, 153));
		btnCadastrar.setToolTipText("Cadastro");
		btnCadastrar.setBounds(342, 11, 98, 23);
		contentPane.add(btnCadastrar);
		
		txtNomeUsuario = new JTextField();
		txtNomeUsuario.setBounds(150, 82, 145, 33);
		contentPane.add(txtNomeUsuario);
		txtNomeUsuario.setColumns(10);
		Login l = new Login();
		JButton btnLogar = new JButton("");
		btnLogar.setBorderPainted(false);
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Criar um objeto loginUserBean
				loginUserBean lub = new loginUserBean();
				lub.setUsuarioLogin(txtNomeUsuario.getText());
				lub.setSenhaLogin(String.valueOf(txtSenha.getPassword()));
				
				//Método para retornar se o usuário existe ou não
				if(new dadosUsuariosDao().login(lub) == true){
					
					JOptionPane.showMessageDialog(null, "Logado com sucesso FIAO!");
					dispose();
					PrincipalView pv = new PrincipalView();
					pv.setVisible(true);
					
				}else{
					JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos. Se fode ai filho da puta =) ");
				}
			}
		});
		btnLogar.setToolTipText("Login");
		btnLogar.setBackground(new Color(102, 51, 153));
		btnLogar.setIcon(new ImageIcon(LoginView.class.getResource("/Imagens/icons8-sair-26.png")));
		btnLogar.setBounds(178, 201, 89, 38);
		contentPane.add(btnLogar);
		
		JLabel lblBemVindo = new JLabel("Bem Vindo !");
		lblBemVindo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemVindo.setForeground(Color.WHITE);
		lblBemVindo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblBemVindo.setBounds(65, 11, 311, 50);
		contentPane.add(lblBemVindo);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSenha.setBounds(147, 113, 145, 33);
		contentPane.add(lblSenha);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(137, 59, 158, 23);
		contentPane.add(lblNewLabel);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(150, 143, 145, 33);
		contentPane.add(txtSenha);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.setBackground(new Color(102, 51, 153));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//instanciar cadastrologin
				dispose();
				cadastroLoginView clv = new cadastroLoginView();
				clv.setVisible(true);
				
			}
		});
		
		btnCancelar.setOpaque(false);
		btnCancelar.setToolTipText("Cancelar");
		btnCancelar.setIcon(new ImageIcon("src/Imagens/icons8-voltar-16.png"));
		btnCancelar.setBounds(391, 266, 49, 23);
		btnCancelar.setBackground(new Color(102, 51, 153));
		contentPane.add(btnCancelar);
		
		JLabel lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon("src/Imagens/experiencia-do-usuario-1.png"));
		lblImagem.setBounds(0, 0, 450, 300);
		contentPane.add(lblImagem);
	}
}
