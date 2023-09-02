package DAOFactories;

import java.util.List;

import DAO.*;
<<<<<<< HEAD
import Helpers.MySQLTablas;
=======
import Entidades.*;
import DAOMySQL.*;
import Helpers.MySQLTablas;
import Helpers.Generador;
>>>>>>> 7a664ef4d9ab8b61b87867ea7b678e69af3ada67

public class MySQLDAOFactory extends DAOFactory {
	
	protected MySQLDAOFactory() {
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
	
	public void poblarTablas() {
		poblarTablaCliente();
		poblarTablaFactura();
		poblarTablaFacturaProducto();
		poblarTablaProducto();
	}
	
	public void poblarTablaCliente() {
		MySQLTablas.createTablaCliente();
		List<Cliente> clientes = Generador.clientesCSV();
		for (int i = 0; i < clientes.size(); i++) {
			getClienteDAO().addCliente(clientes.get(i));
		}
	}
	
	public void poblarTablaFactura() {
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
