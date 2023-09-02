package DAOMySQL;

import DAO.ClienteDAO;
import Entidades.Cliente;

public class MySQLDAO_Cliente implements ClienteDAO {

	//Cliente = int id, String nombre, String email
	@Override
	public void addCliente(Cliente c) {
		Connection conn = MySQLconexion.getConexion();
		String insert = "INSERT into CLIENTE (idCliente, nombre, email) VALUES (?, ?, ?";
		PreparedStatement ps = conn.prepareStatement(insert);
		ps.setInt(1, c.getId());
		ps.setString(2, c.getNombre());
		ps.setString(3, c.getEmail());
		ps.executeUpdate();
		ps.close();
	}

	@Override
	public void updateCliente(Cliente c) {
		Connection conn =  MySQLconexion.getConexion();
		String update = "UPDATE cliente SET idCliente = ?, nombre = ?, email = ?";
		PreparedStatement ps = conn.prepareStatement(update);
		ps.setInt(1, c.getId());
		ps.setString(2, c.getNombre());
		ps.setString(3, c.getEmail());
		ps.executeUpdate();
		ps.close();

	}

	@Override
	public void deleteCliente(Cliente c) {
		Connection conn = MySQLconexion.getConexion();
		String delete = "DELETE FROM cliente " +
						"WHERE idCliente = ?";
		PreparedStatment ps = conn.prepareStatement(delete);
		ps.setInt(1, c.getId());
		ps.executeUpdate();
		ps.close();

	}

	@Override
	public String listarClientes() {
		Connection conn = MySQLconexion.getConexion();
		String select = "SELECT * FROM cliente";
		PreparedStatement ps = conn.prepareStatement(select);
		ResultSet rs =   ps.executeQuery();
		while (rs.next()){
			System.out.println((rs.getInt(1) +", "+ rs.getString(2) +", " + rs.getString(3)));
		}


		return null;
	}

}
