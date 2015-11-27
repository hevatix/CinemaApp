package cineapp.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {

	private static Connection conn;

	/**
	 * Crea la conexion con el servidor MySQL especificado
	 */
	private static void createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			// Data
			String address = "192.168.1.64";
			String port = "3306";
			String database = "cinemas";
			String bd1 = "cinemas";
			String bd2 = "";
			
//			String address = "sql4.freemysqlhosting.net";
//			String port = "3306";
//			String database = "sql495837";
//			String bd1 = "sql495837";
//			String bd2 = "n4YPvJ8vfl";

			// Generate the String
			String url = "jdbc:mysql://" + address + ":" + port + "/" + database;
//			System.out.println("DEBUG: " + url);

			// Connect
			conn = DriverManager.getConnection(url, bd1, bd2);

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
			System.err.println("SQLState: " + ex.getSQLState());
			System.err.println("VendorError: " + ex.getErrorCode());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Devuelve una conexion establecida al servidor de base de datos
	 * @return Conexion
	 */
	public static Connection getConnection() {
		if (conn == null) {
			createConnection();
		}
		return conn;
	}

	/**
	 * Finaliza la conexion con el servidor
	 */
	public static void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
