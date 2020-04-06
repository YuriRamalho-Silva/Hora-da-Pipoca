package ads.pipoca.model.dao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	static {
		try {
			//se descomentar uma linha não se esqueça de comentar a outra
			//descomente a linha de baixo para MySQL 5.7
			Class.forName("com.mysql.jdbc.Driver");
			//descomente a linha de baixo para MySQL 8
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static Connection getConnection() throws IOException {
		try {
			//se descomentar uma linha não se esqueça de comentar a outra
			//descomente a linha de baixo para MySQL 5.7
			return DriverManager.getConnection("jdbc:mysql://localhost/pipocadb?"
					+ "user=alunos&password=alunos&useSSL=false");
			//descomente a linha de baixo para MySQL 8
			//return DriverManager .getConnection("jdbc:mysql://localhost:3306/pipocadb?"
			//		+ "useTimezone=true&serverTimezone=UTC&user=alunos&password=alunos";
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}

}
