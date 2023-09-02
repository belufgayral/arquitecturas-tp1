package Helpers;

import java.sql.SQLException;

public class MySQLTablas {
	
	public static void createTablaCliente() {
		String table = "CREATE TABLE IF NOT EXISTS cliente("
						+ "idCliente INT,"
						+ "nombre VARCHAR(500),"
						+ "email VARCHAR(150),"
						+ "PRIMARY KEY(idCliente))";
		
		try {
			MySQLConexion.getConexion().prepareStatement(table).execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void createTablaFactura() {
		String table = "CREATE TABLE IF NOT EXISTS factura("
						+ "idFactura INT,"
						+ "idCliente INT,"
						+ "PRIMARY KEY(idFactura),"
						+ "FOREIGN KEY(idCliente) REFERENCES cliente(idCliente))";
		
		try {
			MySQLConexion.getConexion().prepareStatement(table).execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void createTablaFacturaProducto() {
		String table = "CREATE TABLE IF NOT EXISTS factura_producto("
						+ "idFactura INT,"
						+ "idProducto INT,"
						+ "cantidad INT,"
						+ "FOREIGN KEY (idFactura) REFERENCES factura(idFactura),"
						+ "FOREIGN KEY (idProducto) REFERENCES producto(idProducto))";
		
		try {
			MySQLConexion.getConexion().prepareStatement(table).execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void createTablaProducto() {
		String table = "CREATE TABLE IF NOT EXISTS producto("
						+ "idProducto INT,"
						+ "nombre VARCHAR(45),"
						+ "valor FLOAT,"
						+ "PRIMARY KEY(idProducto))";
		
		try {
			MySQLConexion.getConexion().prepareStatement(table).execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
