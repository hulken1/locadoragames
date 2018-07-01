package br.com.locadoragames.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.locadoragames.bean.cadastroJogosBEAN;
import br.com.locadoragames.connection.ConnectionFactory;

public class cadastroJogosDao {

	private Connection conexao;
	
	public cadastroJogosDao() {
		
		// Instanciar um objeto da classe ConnectionFactory
		ConnectionFactory cf = new ConnectionFactory();
		conexao = cf.obterConexao();
	}

	
	// metodo para cadastro de jogos
		public void cadastroJogos(cadastroJogosBEAN obj) {

			// SQL
			String sql = "INSERT INTO cadastrojogo (nomeJogo,valorJogo,estoqueJogo,nomeGenero,nomeConsole) VALUES (?,?,?,?,?)";
			
			// Tentar realizar o cadastro
			try {

				// Preparar o envio dos parâmetros
				PreparedStatement pstmt = conexao.prepareStatement(sql);
				pstmt.setString(1, obj.getNomeJogo());
				pstmt.setDouble(2, obj.getValorJogo());
				pstmt.setInt(3, obj.getEstoqueJogo());
				pstmt.setString(4,obj.getNomeGenero());
				pstmt.setString(5, obj.getNomeConsole());				
				
				// Executar o comando
				pstmt.execute();								
				JOptionPane.showMessageDialog(null, "Jogo cadastrado com sucesso !");
				// Finalizar a conexão
				pstmt.close();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Falha ao cadastrar jogo, erro: " + e.getMessage());
			}

		}
		
		// Método para listar os produtos
		public DefaultTableModel listarCadastroJogos() {

			// DefaultTableModel
			DefaultTableModel modelo = new DefaultTableModel();

			// Colunas
			modelo.addColumn("NomeJogo");
			modelo.addColumn("Valor");
			modelo.addColumn("QTD Estoque");
			modelo.addColumn("Genero");
			modelo.addColumn("Consoles");
			

			// SQL
			String sql = "SELECT * FROM cadastrojogo";

			// Tentar executar
			try {
				// Comando para realizar a conexão e executar o comando SQL
				Statement stmt = conexao.createStatement();

				// Obter todos os dados da tabela
				ResultSet rs = stmt.executeQuery(sql);

				// Laço
				while (rs.next()) {
					modelo.addRow(new Object[] { 
							rs.getString("nomeJogo"), 
							rs.getDouble("valorJogo"),
							rs.getInt("estoqueJogo"),
							rs.getString("nomeGenero"),
							rs.getString("nomeConsole")});
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Falha ao executar listagen Jogos.");
			}
			
			// Retorno
			return modelo;
		}
		
		public void excluirJogo(int idCadastroJogo){
			
			//Sql
			String sql = "DELETE FROM cadastrojogo WHERE idCadastroJogo = ? ";
			
			// Tenta realizar a exclusão
			try {

				// Preparar a exclusão
				PreparedStatement pstmt = conexao.prepareStatement(sql);
				pstmt.setInt(1, idCadastroJogo);


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
		
		public cadastroJogosBEAN obterDadosJogos(int idCadastroJogo){
			
			//Instanciar objeto
			cadastroJogosBEAN cb = new cadastroJogosBEAN();
					
			// sql
			String sql = "SELECT * FROM cadastrojogo WHERE idCadastroJogo = ?";
			
			// Tentar realizar a seleção dos valores
			try {

				PreparedStatement pstmt = conexao.prepareStatement(sql);
				pstmt.setInt(1, idCadastroJogo);
				
				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
					cb.setNomeJogo(rs.getString("nomeJogo"));
					cb.setValorJogo(rs.getDouble("valorJogo"));
					cb.setEstoqueJogo(rs.getInt("estoqueJogo"));
					cb.setNomeGenero(rs.getString("nomeGenero"));
					cb.setNomeConsole(rs.getString("nomeConsole"));
				
				}

				pstmt.close();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Falha ao obter os dados.");
			}

			// Retorno
			return cb;

		}

public void alterarJogo(cadastroJogosBEAN obj){
	
	//SQL
	String sql = "UPDATE cadastrojogo SET nomeJogo = ?, valorJogo = ?, estoqueJogo = ?, nomeGenero = ?,nomeConsole = ?,  WHERE idCadastroJogo = ?";
	
	//Tenta realizar o comando
			try {
				
				PreparedStatement pstmt = conexao.prepareStatement(sql);
				pstmt.setString(1, obj.getNomeJogo());
				pstmt.setDouble(2, obj.getValorJogo());
				pstmt.setInt(3, obj.getEstoqueJogo());
				pstmt.setString(4, obj.getNomeGenero());
				pstmt.setString(5, obj.getNomeConsole());
				
				pstmt.execute();
				pstmt.close();
				
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Falha ao alterar cadastro jogo.");
			}
}
}