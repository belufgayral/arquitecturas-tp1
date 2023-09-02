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

	@Override
	public void updateCliente(Cliente c) throws SQLException {
		Connection conn =  MySQLConexion.getConexion();
		String update = "UPDATE cliente SET nombre = ?, email = ?" +
						"WHERE idCliente = ?";
		PreparedStatement ps = conn.prepareStatement(update);
		ps.setString(1, c.getNombre());
		ps.setString(2, c.getEmail());
		ps.setInt(3, c.getId());
		ps.executeUpdate();
		ps.close();
		//conn.commit();
	}

	@Override
	public void deleteCliente(Cliente c) throws SQLException {
		Connection conn = MySQLConexion.getConexion();
		String delete = "DELETE FROM cliente " +
						"WHERE idCliente = ?";
		PreparedStatement ps = conn.prepareStatement(delete);
		ps.setInt(1, c.getId());
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
		String select = "SELECT * FROM cliente";
		PreparedStatement ps = conn.prepareStatement(select);
		ResultSet rs =   ps.executeQuery();
		while (rs.next()) {
			lista.add("ID: "+ rs.getInt(1) + ", Nombre: " + rs.getString(2) + ", Email: " + rs.getString(3));
		}

		return lista;
	}
}
