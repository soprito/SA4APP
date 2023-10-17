package DAO;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.ConexaoMySQL;
import supermarket.Venda;
import supermarket.Produto;
public class VendaDAO {
	public void create(Venda venda) {
		Connection conexao = ConexaoMySQL.iniciarConexao(); //cria a conexao com o BD
		PreparedStatement stmt = null; //cria um statement
		
		try {
			//Criar o SQL
			stmt = conexao.prepareStatement("INSERT INTO venda (id_venda, listavenda, vlrTotal) VALUES (?,?,?)");
			stmt.setInt(1, venda.getId_venda());
			stmt.setArray(2, (Array) venda.getListavenda());
			stmt.setDouble(3, venda.getVlrTotal());
			
			stmt.executeUpdate();
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			ConexaoMySQL.encerrarConexao(conexao, stmt);
		}
	}
	
	@SuppressWarnings("unchecked")
	public Venda read(){
		Connection conexao = ConexaoMySQL.iniciarConexao(); //cria a conexao com o BD
		PreparedStatement stmt = null; //cria um statement
		ResultSet rs = null; //cria um resultset para pegar as informações da tabela através do SELECT
		ArrayList<Produto> listavenda = new ArrayList<>();
		
		try {
			stmt = conexao.prepareStatement("SELECT * FROM venda");
			rs = stmt.executeQuery(); //Executa o SQL e o resultado armazena no ResultSet
			
			while(rs.next()) { //Percorrer o ResultSet
				Venda venda = new Venda();
				venda.setId_venda(rs.getInt("id_venda"));
				venda.setListavenda((ArrayList<Produto>) rs.getArray("listavenda"));
				venda.setVlrTotal(rs.getInt("vlrTotal"));
				listavenda.toArray();
			}
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			ConexaoMySQL.encerrarConexao(conexao, stmt, rs);
		}
		return read();
	}
	
	public void update(Venda venda) {
		Connection conexao = ConexaoMySQL.iniciarConexao(); //cria a conexao com o BD
		PreparedStatement stmt = null; //cria um statement
		
		try {
			//Criar o SQL
			stmt = conexao.prepareStatement("UPDATE venda SET id_venda = ?, listavenda = ?, vlrTotal = ? WHERE id_venda = ?");
			stmt.setInt(1, venda.getId_venda());
			stmt.setArray(2, (Array) venda.getListavenda());
			stmt.setDouble(3, venda.getVlrTotal());
			
			stmt.executeUpdate();
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			ConexaoMySQL.encerrarConexao(conexao, stmt);
		}
	}
	
	public void delete(Venda venda) {
		Connection conexao = ConexaoMySQL.iniciarConexao(); //cria a conexao com o BD
		PreparedStatement stmt = null; //cria um statement
		
		try {
			//Criar o SQL
			stmt = conexao.prepareStatement("DELETE FROM produto WHERE id_venda = ?");
			stmt.setInt(1, venda.getId_venda());
			
			stmt.executeUpdate();
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			ConexaoMySQL.encerrarConexao(conexao, stmt);
		}
	}

}
