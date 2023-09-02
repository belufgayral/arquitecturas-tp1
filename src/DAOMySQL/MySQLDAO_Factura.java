package DAOMySQL;

import DAO.FacturaDAO;
import Entidades.Factura;

public class MySQLDAO_Factura implements FacturaDAO {

	@Override
	public void addFactura(Factura f) {
		Connection conn = MySQLconexion.getConexion();
		String insert = "INSERT INTO factura (idCliente, idFactura) VALUES (?, ?)";
		PreparedStatement ps = conn.prepareStatement(insert);
		ps.setInt(1, f.getIdCliente());
		ps.setInt(2, f.getIdFactura());
		ps.executeUpdate();
		ps.close();
		
	}

	@Override
	public void updateFactura(Factura f) {
		Connection conn = MySQLconexion.getConexion();
		String update = "UPDATE factura SET idCliente = ?" +
				"WHERE idFactura = ?";
		PreparedStatement ps = conn.prepareStatement(update);
		ps.setInt(1, f.getIdCliente());
		ps.setInt(2, f.getIdFactura());
		ps.executeUpdate();
		ps.close();
	}

	@Override
	public void deleteFactura(Factura f) {
		// TODO Auto-generated method stub
		
	}

}
