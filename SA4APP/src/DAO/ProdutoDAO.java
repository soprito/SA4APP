package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.ConexaoMySQL;
import supermarket.Produto;



public class ProdutoDAO {
	//CRUD - Create, Read, Update e Delete
	public void create(Produto produto) {
		Connection conexao = ConexaoMySQL.iniciarConexao(); //cria a conexao com o BD
		PreparedStatement stmt = null; //cria um statement
		
		try {
			//Criar o SQL
			stmt = conexao.prepareStatement("INSERT INTO produto (nome, preco, quantidade_estoque) VALUES (?,?,?)");
			stmt.setString(1, produto.getNome());
			stmt.setDouble(2, produto.getPreco());
			stmt.setInt(3, produto.getQuantidadeEstoque());
			
			stmt.executeUpdate();
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			ConexaoMySQL.encerrarConexao(conexao, stmt);
		}
	}
	
	public ArrayList<Produto> read(){
		Connection conexao = ConexaoMySQL.iniciarConexao(); //cria a conexao com o BD
		PreparedStatement stmt = null; //cria um statement
		ResultSet rs = null; //cria um resultset para pegar as informações da tabela através do SELECT
		ArrayList<Produto> listaprodutos = new ArrayList<>(); //ArrayList que vai receber as informações do ResultSet
		
		try {
			stmt = conexao.prepareStatement("SELECT * FROM produto");
			rs = stmt.executeQuery(); //Executa o SQL e o resultado armazena no ResultSet
			//Repassar as informações do ResultSet para um ArrayList
			while(rs.next()) { //Percorrer o ResultSet
				Produto produto = new Produto();
				produto.setId_produto(rs.getInt("id_produto"));
				produto.setNome(rs.getString("nome"));
				produto.setPreco(rs.getDouble("preco"));
				produto.setQuantidadeEstoque(rs.getInt("quantidade_estoque"));
				listaprodutos.add(produto);
			}
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			ConexaoMySQL.encerrarConexao(conexao, stmt, rs);
		}
		return listaprodutos;
	}
	
	public void update(Produto produto) {
		Connection conexao = ConexaoMySQL.iniciarConexao(); //cria a conexao com o BD
		PreparedStatement stmt = null; //cria um statement
		
		try {
			//Criar o SQL
			stmt = conexao.prepareStatement("UPDATE produto SET nome = ?, preco = ?, quantidade_estoque = ? WHERE id_produto = ?");
			stmt.setString(1, produto.getNome());
			stmt.setDouble(2, produto.getPreco());
			stmt.setInt(3, produto.getQuantidadeEstoque());
			stmt.setInt(4, produto.getId_produto());
			
			stmt.executeUpdate();
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			ConexaoMySQL.encerrarConexao(conexao, stmt);
		}
	}
	
	public void delete(Produto produto) {
		Connection conexao = ConexaoMySQL.iniciarConexao(); //cria a conexao com o BD
		PreparedStatement stmt = null; //cria um statement
		
		try {
			//Criar o SQL
			stmt = conexao.prepareStatement("DELETE FROM produto WHERE id_produto = ?");
			stmt.setInt(1, produto.getId_produto());
			
			stmt.executeUpdate();
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			ConexaoMySQL.encerrarConexao(conexao, stmt);
		}
	}

}
