package br.com.locadoragames.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.locadoragames.bean.dadosUsuariosBean;
import br.com.locadoragames.bean.loginUserBean;
import br.com.locadoragames.connection.ConnectionFactory;

public class dadosUsuariosDao {
		
	//Atributo contendo a conexão
	private Connection conexao;
	
	//Construtor
	public dadosUsuariosDao(){
		//Instanciar um objeto da classe ConnectionFactory
		ConnectionFactory cf = new ConnectionFactory();
		conexao = cf.obterConexao();
		
	}
	
	
	
	//Método para validar o login
	public boolean login(loginUserBean obj){
		
		//SQL
		String sql = "SELECT COUNT(*) FROM dadosclientes WHERE nomeDadosCliente = ? AND senhaUsuario = ?";
		
		//Variável boolean
		boolean existeUsuario = false;
		
		//Tenta realizar a verificação
		try{
			
			//PreparedStatement
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			//Enviar os dados dos parâmetros (?)
			pstmt.setString(1, obj.getUsuarioLogin());
			pstmt.setString(2, obj.getSenhaLogin());
			
			//Executar ação
			ResultSet rs = pstmt.executeQuery();
			
			//Obter o valor da última linha
			rs.last();
			
			//Condicional
			if(rs.getInt(1) != 0){
				existeUsuario = true;
			}
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao realizar o login. Erro: "+e.getMessage());
		}
		
		
		//Retorno
		return existeUsuario;
		
	}
	
	
	
	//metodo para cadastro login
	public void dadosClientes(dadosUsuariosBean obj){
		
		//SQL
		String sql = "INSERT INTO dadosclientes (nomeDadosCliente,senhaUsuario, emailDadosCliente,telefoneDadosClientes) VALUES (?,?, ?,?)";
		
		//Tentar realizar o cadastro
				try {
					
					//Preparar o envio dos parâmetros
					PreparedStatement pstmt = conexao.prepareStatement(sql);
					pstmt.setString(1, obj.getNomeDadosCliente());
					pstmt.setString(2, obj.getSenhaUsuario());
					pstmt.setString(3, obj.getEmailDadosCliente());
					pstmt.setString(4, obj.getTelefoneDadosClientes());
					
					//Executar o comando
					pstmt.execute();
					
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
					//Finalizar a conexão
					pstmt.close();
					
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Falha ao cadastrar, erro: "+e.getMessage());
				}
	}
				//Método para listar os produtos
				public DefaultTableModel listarDadosClientes() {
					
					//DefaultTableModel
					DefaultTableModel modelo = new DefaultTableModel();
					
					//Colunas
					modelo.addColumn("Nome");
					modelo.addColumn("Senha");
					modelo.addColumn("Email");
					modelo.addColumn("Telefone");
					
					//SQL
					String sql = "SELECT * FROM dadosclientes";
					
					//Tentar executar
					try {
						//Comando para realizar a conexão e executar o comando SQL
						Statement stmt = conexao.createStatement();
						
						//Obter todos os dados da tabela
						ResultSet rs = stmt.executeQuery(sql);
						
						//Laço
						while(rs.next()) {
							modelo.addRow(new Object[] {
								rs.getInt("idDadosClientes"),
								rs.getString("nomeDadosCliente"),
								rs.getString("senhaUsuario"),
								rs.getString("emailDadosCliente"),
								rs.getString("telefoneDadosClientes")
							});
						}
						
					}catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Falha ao executar a seleção.");
					}
					
					//Retorno
					return modelo;
		
	}
				public void excluirDadosClientes(int idDadosClientes){
					
					
					//SQL
					String sql = "DELETE FROM dadosclientes WHERE idDadosClientes = ?";
					
					//Tenta realizar a exclusão
					try {
						
						//Preparar a exclusão
						PreparedStatement pstmt = conexao.prepareStatement(sql);
						pstmt.setInt(1, idDadosClientes);
						
						//Executar comando
						pstmt.execute();
						
						//Finalizar conexão com o banco de dados
						pstmt.close();
						
						//Mensagem
						JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
						
					}catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Falha ao excluir");
					}
					
				
				}
				public dadosUsuariosBean obterNomeEmailTelefoneCliente (int idDadosClientes) {
					
					//Objeto
					dadosUsuariosBean dcb = new dadosUsuariosBean();
					
					//SQL
					String sql = "SELECT * FROM dadosclientes WHERE idDadosClientes = ?";
					
					//Tentar realizar a seleção dos valores
					try {
						
						PreparedStatement pstmt = conexao.prepareStatement(sql);
						pstmt.setInt(1, idDadosClientes);
						
						ResultSet rs = pstmt.executeQuery();
						
						while(rs.next()) {
							dcb.setNomeDadosCliente(rs.getString("nomeDadosClientes"));
							dcb.setSenhaUsuario(rs.getString("senhaUsuario"));
							dcb.setEmailDadosCliente(rs.getString("emailDadosClientes"));
						}
						
						pstmt.close();
						
					}catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Falha ao obter os dados.");
					}
					
					//Retorno
					return dcb;
					
				}
				public void alterarClientes(dadosUsuariosBean obj) {
					
					//SQL
					String sql = "UPDATE dadosclientes SET nomeDadosClientes = ?, senhaUsuario = ?, emailDadosClientes = ? WHERE idDadosClientes = ?";
					
					//Tenta realizar o comando
					try {
						
						PreparedStatement pstmt = conexao.prepareStatement(sql);
						pstmt.setString(1, obj.getNomeDadosCliente());
						pstmt.setString(2, obj.getSenhaUsuario());
						pstmt.setString(3, obj.getEmailDadosCliente());
						pstmt.setInt(4, obj.getIdDadosClientes());
						
						pstmt.execute();
						pstmt.close();
						
					}catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Falha ao alterar cliente.");
					}
					
				}
}
