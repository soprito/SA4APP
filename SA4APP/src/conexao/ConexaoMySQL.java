package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoMySQL {
	private static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/sa4app";
	private static String USER = "root";
	private static String PASS = "123456";

	public static Connection iniciarConexao() {
		try {
			Class.forName(DRIVER); // realizar a busca da classe na biblioteca
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException | SQLException erro) {
			throw new RuntimeException("Erro na conexão: " + erro);
		}

	}
	public static void encerrarConexao(Connection conexao) {
		if (conexao != null) {
			try {
				conexao.close();
			} catch (SQLException erro) {
				erro.printStackTrace();
			}
		}
	}

	public static void encerrarConexao(Connection conexao, PreparedStatement stmt) {
		encerrarConexao(conexao);
		try {
			stmt.close();
		} catch (SQLException erro) {
			erro.printStackTrace();
		}
	}

	public static void encerrarConexao(Connection conexao, PreparedStatement stmt, ResultSet rs) {
		encerrarConexao(conexao, stmt);
		try {
			rs.close();
		} catch (SQLException erro) {
			erro.printStackTrace();
		}
	}
}