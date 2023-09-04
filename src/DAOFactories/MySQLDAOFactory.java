package DAOFactories;

import java.sql.SQLException;
import java.util.List;
import DAO.*;
import Helpers.MySQLTablas;
import Entidades.*;
import DAOMySQL.*;
import Helpers.Generador;

public class MySQLDAOFactory extends DAOFactory {
	private static MySQLDAO_Cliente mySQLDAOCliente;
	private static MySQLDAO_Factura mySQLDAOFactura;
	private static MySQLDAO_FacturaProducto mySQLDAOFacturaProducto;
	private static MySQLDAO_Producto mySQLDAOProducto;
	
	protected MySQLDAOFactory() throws SQLException {
	}

	@Override
	public ClienteDAO getClienteDAO() {
		if (mySQLDAOCliente == null)
			mySQLDAOCliente = new MySQLDAO_Cliente();
		return mySQLDAOCliente;
	}

	@Override
	public FacturaDAO getFacturaDAO() {
		if (mySQLDAOFactura == null)
			mySQLDAOFactura = new MySQLDAO_Factura();
		return mySQLDAOFactura;
	}

	@Override
	public FacturaProductoDAO getFacturaProductoDAO() {
		if (mySQLDAOFacturaProducto == null)
			mySQLDAOFacturaProducto = new MySQLDAO_FacturaProducto();
		return mySQLDAOFacturaProducto;
	}

	@Override
	public ProductoDAO getProductoDAO() {
		if (mySQLDAOProducto == null)
			mySQLDAOProducto = new MySQLDAO_Producto();
		return mySQLDAOProducto;
	}
	
	public void poblarTablas() throws SQLException {
		poblarTablaCliente();
		poblarTablaFactura();
		poblarTablaProducto();
		poblarTablaFacturaProducto();
	}
	
	public void poblarTablaCliente() throws SQLException {
		MySQLTablas.createTablaCliente();
		List<Cliente> clientes = Generador.clientesCSV();
		for (int i = 0; i < clientes.size(); i++) {
			getClienteDAO().addCliente(clientes.get(i));
		}
	}
	
	public void poblarTablaFactura() throws SQLException {
		MySQLTablas.createTablaFactura();
		List<Factura> facturas = Generador.facturasCSV();
		for (int i = 0; i < facturas.size(); i++) {
			getFacturaDAO().addFactura(facturas.get(i));
		}
	}
	
	public void poblarTablaFacturaProducto() {
		MySQLTablas.createTablaFacturaProducto();
		List<FacturaProducto> facturasproductos = Generador.facturasProductosCSV();
		for (int i = 0; i < facturasproductos.size(); i++) {
			getFacturaProductoDAO().addFacturaProducto(facturasproductos.get(i));
		}
	}
	
	public void poblarTablaProducto() {
		MySQLTablas.createTablaProducto();
		List<Producto> productos = Generador.productosCSV();
		for (int i = 0; i < productos.size(); i++) {
			getProductoDAO().addProducto(productos.get(i));
		}
	}

	public void borrarScheme(){

	}
}
