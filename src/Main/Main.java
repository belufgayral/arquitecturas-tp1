package Main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.ClienteDAO;
import DAO.FacturaDAO;
import DAO.ProductoDAO;
import DAOFactories.DAOFactory;
import Entidades.Factura;
import Entidades.Producto;
import Helpers.MySQLConexion;

public class Main {

	public static void main(String[] args) throws SQLException {

		//ej 1:
		DAOFactory mySQLDAOFactory = DAOFactory.getDAOFactory("mysql");
		//ej 2:
		//comentar si la poblacion de tablas ya fue hecha
		mySQLDAOFactory.poblarTablas();

		ClienteDAO cliente = mySQLDAOFactory.getClienteDAO();
		ProductoDAO prod = mySQLDAOFactory.getProductoDAO();
		FacturaDAO factura = mySQLDAOFactory.getFacturaDAO();

		//ej 3:
		System.out.println("Producto con mas recaudacion: ");
		Producto p = prod.getProductoMayorRecaudacion();

		System.out.println(p);

		//ej 4:
		System.out.println("");
		System.out.println(" --------------------------- ");
		System.out.println("");
		System.out.println("Clientes con mas facturacion: ");
		ArrayList<String> lista = (ArrayList<String>) cliente.listarClientes();
		for(String l : lista){
			System.out.println(l);
		}

		MySQLConexion.closeConnection();
		System.out.println("Conexion cerrada ");
	}
}
