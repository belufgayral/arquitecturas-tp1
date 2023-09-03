package Main;

import java.sql.SQLException;

import DAO.*;
import DAOFactories.DAOFactory;
import Entidades.Producto;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		DAOFactory mySQLDAOFactory = DAOFactory.getDAOFactory("mysql");
		ClienteDAO daoCliente = mySQLDAOFactory.getClienteDAO();
		FacturaDAO daoFactura = mySQLDAOFactory.getFacturaDAO();
		FacturaProductoDAO daoFacturaProducto = mySQLDAOFactory.getFacturaProductoDAO();
		ProductoDAO daoProducto = mySQLDAOFactory.getProductoDAO();

		//punto 3)
		//daoProducto.getProductoMayorRecaudacion();

		daoCliente.listarClientes();
	}

}
