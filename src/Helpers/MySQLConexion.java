package Helpers;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion {
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String uri = "jdbc:mysql://localhost:3306/tp1?createDatabaseIfNotExist=true";
	private static String user = "root";
	private static String password = "admin";
	private static Connection conexion;
	
	private MySQLConexion() {
		//para que nadie a pueda instanciar desde afuera..
	}
	
	public static Connection getConexion() {
		if (conexion == null) {
			conexion = instanciar();
		}
		return conexion;
	}
	
	private static Connection instanciar() {
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		try {
			Connection conn = DriverManager.getConnection(uri, user, password);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
			return null;
		}
	}

	public static void closeConnection() throws SQLException {
		conexion.close();
	}
}
