package DAOMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DAO.ClienteDAO;
import Entidades.Cliente;
import Helpers.MySQLConexion;

public class MySQLDAO_Cliente implements ClienteDAO {

	//Cliente = int id, String nombre, String email
	@Override
	public void addCliente(Cliente c) throws SQLException {
		Connection conn = MySQLConexion.getConexion();
		String insert = "INSERT INTO cliente (idCliente, nombre, email) VALUES (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(insert);
		ps.setInt(1, c.getId());
		ps.setString(2, c.getNombre());
		ps.setString(3, c.getEmail());
		ps.executeUpdate();
		ps.close();
		//conn.commit();
	}

	//Escriba un programa JDBC que imprima una lista de clientes, ordenada por a cuál se le facturó más:
	//falta asociar con factura para listar por factura
	@Override
	public List<String> listarClientes() throws SQLException {
		Connection conn = MySQLConexion.getConexion();
		List<String> lista = new ArrayList<String>();
		String select =
				"SELECT tabla.idCliente, tabla.nombre, SUM(valor) AS facturacion " +
						"FROM (  SELECT c.idCliente, c.nombre, SUM(fp.cantidad*p.valor) AS valor FROM tp1.cliente c " +
						"INNER JOIN tp1.factura f ON c.idCliente = f.idCliente " +
						"INNER JOIN tp1.factura_producto fp ON f.idFactura = fp.idFactura " +
						"INNER JOIN tp1.producto p ON fp.idProducto = p.idProducto " +
						"GROUP BY c.idCliente, p.idProducto) as tabla " +
						"GROUP BY tabla.idCliente, tabla.nombre " +
						"ORDER BY facturacion desc " +
						"LIMIT 10";
		PreparedStatement ps = conn.prepareStatement(select);
		ResultSet rs =   ps.executeQuery();
		while (rs.next()) {
			lista.add("IDCliente: "+ rs.getInt(1) + ", Nombre: " + rs.getString(2) + ", facturacion: $" + rs.getInt(3));
		}

		return lista;
	}
}
