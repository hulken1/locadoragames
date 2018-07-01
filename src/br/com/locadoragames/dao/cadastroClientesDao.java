package br.com.locadoragames.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.locadoragames.bean.cadastroClientesBean;
import br.com.locadoragames.connection.ConnectionFactory;

public class cadastroClientesDao {

	private Connection conexao;

	public  cadastroClientesDao() {
		// Instanciar um objeto da classe ConnectionFactory
		ConnectionFactory cf = new ConnectionFactory();
		conexao = cf.obterConexao();

	}

	// metodo para cadastro clientes
	public void cadastroClientes(cadastroClientesBean obj) {

		// SQL
		String sql = "INSERT INTO cadastroclientes (nomeCliente, cpfCliente,enderecoCliente,numeroEndereco ,telResidencial,telCelular) VALUES (?, ?, ?, ?, ?, ?)";

		// Tentar realizar o cadastro
		try {

			// Preparar o envio dos parâmetros
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, obj.getNomeCliente());
			pstmt.setString(2, obj.getCpfCliente());
			pstmt.setString(3, obj.getEnderecoCliente());
			pstmt.setString(4, obj.getNumeroEndereco());
			pstmt.setString(5, obj.getTelResidencial());
			pstmt.setString(6, obj.getTelCelular());

			// Executar o comando
			pstmt.execute();
			
			JOptionPane.showMessageDialog(null, "Cadastrado Com sucesso ! ");
			// Finalizar a conexão
			pstmt.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao cadastrar, erro: " + e.getMessage());
		}

	}

	// Método para listar os produtos
	public DefaultTableModel listarClientesCadastrados() {

		// DefaultTableModel
		DefaultTableModel modelo = new DefaultTableModel();

		// Colunas
		modelo.addColumn("Nome");
		modelo.addColumn("CPF");
		modelo.addColumn("Endereco");
		modelo.addColumn("Numero Endereco");
		modelo.addColumn("TelResidencial");
		modelo.addColumn("TelCelular");

		// SQL
		String sql = "SELECT * FROM cadastroclientes";

		// Tentar executar
		try {
			// Comando para realizar a conexão e executar o comando SQL
			Statement stmt = conexao.createStatement();

			// Obter todos os dados da tabela
			ResultSet rs = stmt.executeQuery(sql);

			// Laço
			while (rs.next()) {
				modelo.addRow(new Object[] { 
						
						rs.getString("nomeCliente"), 
						rs.getString("cpfCliente"),
						rs.getString("enderecoCliente"), 
						rs.getString("numeroEndereco"), 
						rs.getString("telResidencial"),
						rs.getString("telCelular")});
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao executar a seleção.");
		}

		// Retorno
		return modelo;

	}

	public void excluirCadastroClientes(String cpfCliente) {

		// SQL
		String sql = "DELETE FROM cadastroclientes WHERE cpfCliente = ?";

		// Tenta realizar a exclusão
		try {

			// Preparar a exclusão
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, cpfCliente);

			// Executar comando
			pstmt.execute();

			// Finalizar conexão com o banco de dados
			pstmt.close();

			// Mensagem
			JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao excluir");
		}

	}

		// Alterar cadastro Clientes
		public cadastroClientesBean obterCadastroClientes(String cpfCliente) {

		// Instanciar objeto
		cadastroClientesBean ccb = new cadastroClientesBean();

		// sql
		String sql = "SELECT * FROM cadastroclientes WHERE cpfCliente = ?";

		// Tentar realizar a seleção dos valores
		try {

			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, cpfCliente);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				ccb.setNomeCliente(rs.getString("nomeCliente"));
				ccb.setCpfCliente(rs.getString("cpfCliente"));
				ccb.setEnderecoCliente(rs.getString("enderecoCliente"));
				ccb.setNumeroEndereco(rs.getString("numeroEndereco"));
				ccb.setTelResidencial(rs.getString("telResidencial"));
				ccb.setTelCelular(rs.getString("telCelular"));

			}

			pstmt.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao obter os dados.");
		}

		// Retorno
		return ccb;

	}

	public void alterarCadastroClientes(cadastroClientesBean obj) {
		
		//SQL
		String sql = "UPDATE cadastroclientes SET nomeCliente = ?, enderecoCliente = ? , numeroEndereco = ?, telResidencial = ? , telCelular = ? WHERE cpfCliente = ?";

		//Tenta realizar o comando
		try {
			
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, obj.getNomeCliente());
			pstmt.setString(2, obj.getEnderecoCliente());
			pstmt.setString(3, obj.getNumeroEndereco());
			pstmt.setString(4, obj.getTelResidencial());
			pstmt.setString(5, obj.getTelCelular());
			pstmt.setString(6, obj.getCpfCliente());
			
			pstmt.execute();
			pstmt.close();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao alterar cliente."+e.getMessage());
		}

	
	}

}
