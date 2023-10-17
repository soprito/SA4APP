package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexao.ConexaoMySQL;
import supermarket.Pagamento;

public class PagamentoDAO {
	//CRUD - Create, Read, Update e Delete
		public void create(Pagamento pagamento) {
			Connection conexao = ConexaoMySQL.iniciarConexao(); //cria a conexao com o BD
			PreparedStatement stmt = null; //cria um statement
			
			try {
				//Criar o SQL
				stmt = conexao.prepareStatement("INSERT INTO produto (tipoPagamento) VALUES (?)");
				stmt.setInt(1, pagamento.getTipoPagamento());
				stmt.executeUpdate();
			} catch (SQLException erro) {
				erro.printStackTrace();
			} finally {
				ConexaoMySQL.encerrarConexao(conexao, stmt);
			}
		}
		
		public Pagamento read(){
			Connection conexao = ConexaoMySQL.iniciarConexao(); //cria a conexao com o BD
			PreparedStatement stmt = null; //cria um statement
			ResultSet rs = null; //cria um resultset para pegar as informações da tabela através do SELECT
			
			
			try {
				stmt = conexao.prepareStatement("SELECT * FROM pagamento");
				rs = stmt.executeQuery(); //Executa o SQL e o resultado armazena no ResultSet
				
				while(rs.next()) { //Percorrer o ResultSet
					Pagamento pagamento = new Pagamento();
					pagamento.setTipoPagamento(rs.getInt("tipoPagamento"));
				
				}
			} catch (SQLException erro) {
				erro.printStackTrace();
			} finally {
				ConexaoMySQL.encerrarConexao(conexao, stmt, rs);
			}
			return read();
		}
		
		public void update(Pagamento pagamento) {
			Connection conexao = ConexaoMySQL.iniciarConexao(); //cria a conexao com o BD
			PreparedStatement stmt = null; //cria um statement
			
			try {
				//Criar o SQL
				stmt = conexao.prepareStatement("UPDATE produto SET tipoPagamento = ? WHERE tipoPagamento = ?");
				stmt.setInt(1, pagamento.getTipoPagamento());
				
				stmt.executeUpdate();
			} catch (SQLException erro) {
				erro.printStackTrace();
			} finally {
				ConexaoMySQL.encerrarConexao(conexao, stmt);
			}
		}
		
		public void delete(Pagamento pagamento) {
			Connection conexao = ConexaoMySQL.iniciarConexao(); //cria a conexao com o BD
			PreparedStatement stmt = null; //cria um statement
			
			try {
				//Criar o SQL
				stmt = conexao.prepareStatement("DELETE FROM produto WHERE tipoPagamento = ?");
				stmt.setInt(1, pagamento.getTipoPagamento());
				
				stmt.executeUpdate();
			} catch (SQLException erro) {
				erro.printStackTrace();
			} finally {
				ConexaoMySQL.encerrarConexao(conexao, stmt);
			}
		}
}
