package DAOMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DAO.FacturaDAO;
import Entidades.Factura;
import Helpers.MySQLConexion;

public class MySQLDAO_Factura implements FacturaDAO {

	@Override
	public void addFactura(Factura f) throws SQLException {
		Connection conn = MySQLConexion.getConexion();
		String insert = "INSERT INTO factura (idCliente, idFactura) VALUES (?, ?)";
		PreparedStatement ps = conn.prepareStatement(insert);
		ps.setInt(1, f.getIdCliente());
		ps.setInt(2, f.getIdFactura());
		ps.executeUpdate();
		ps.close();
	}
}
