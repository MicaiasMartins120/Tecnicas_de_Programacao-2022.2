package AgendaDeCompromissos;

import java.sql.*;

public class Conection {
	private String host;
	private String usuario;
	private String senha;
	private String banco;

	public Conection() {

		this.host = "127.0.0.1";
		this.banco = "agendacompromissos";
		this.usuario = "root";
		this.senha = "";
	}

	public Connection getConection() {
		String url="jdbc:mysql://" + this.host + "/" + this.banco+"?verifyServerCertificate=false&useSSL=true";
		try {
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException ex) {
			System.out.println("Conex�o com MYSQL n�o realizada");
			ex.printStackTrace();
		}
		return null;
	}

}
