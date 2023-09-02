package DAOFactories;

import java.sql.SQLException;
import java.util.List;
import DAO.*;
import Helpers.MySQLTablas;
import Entidades.*;
import DAOMySQL.*;
import Helpers.Generador;

public class MySQLDAOFactory extends DAOFactory {
	
	protected MySQLDAOFactory() throws SQLException {
		poblarTablas();
	}

	@Override
	public ClienteDAO getClienteDAO() {
		return new MySQLDAO_Cliente();
	}

	@Override
	public FacturaDAO getFacturaDAO() {
		return new MySQLDAO_Factura();
	}

	@Override
	public FacturaProductoDAO getFacturaProductoDAO() {
		return new MySQLDAO_FacturaProducto();
	}

	@Override
	public ProductoDAO getProductoDAO() {
		return new MySQLDAO_Producto();
	}
	
	public void poblarTablas() throws SQLException {
		poblarTablaCliente();
		poblarTablaFactura();
		poblarTablaFacturaProducto();
		poblarTablaProducto();
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
}
