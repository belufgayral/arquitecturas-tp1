package DAOMySQL;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import DAO.FacturaProductoDAO;
import Entidades.FacturaProducto;
import Helpers.MySQLConexion;

public class MySQLDAO_FacturaProducto implements FacturaProductoDAO {

	@Override
	public void addFacturaProducto(FacturaProducto fp) {
		String insert = "INSERT INTO factura_producto (idFactura,idProducto,cantidad) VALUES (?,?,?)";
		try {
			PreparedStatement ps = MySQLConexion.getConexion().prepareStatement(insert);
			ps.setInt(1, fp.getIdFactura());
			ps.setInt(2, fp.getIdProducto());
			ps.setInt(3, fp.getCantidad());
			
			ps.executeUpdate();
			ps.close();
			//MySQLConexion.getConexion().commit();
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

}
