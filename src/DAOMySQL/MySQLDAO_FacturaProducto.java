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

	@Override
	public void updateFacturaProducto(FacturaProducto fp) {
		String update = "UPDATE factura_producto SET idFactura=?, idProducto=?, cantidad=? WHERE idFactura=? AND idProducto=?";
		try {
			PreparedStatement ps = MySQLConexion.getConexion().prepareStatement(update);
			int idFact = fp.getIdFactura();
			int idProd = fp.getIdProducto();
			
			ps.setInt(1, idFact);
			ps.setInt(2, idProd);
			ps.setInt(3, fp.getCantidad());
			ps.setInt(4, idFact);
			ps.setInt(5, idProd);
			ps.executeUpdate();
			ps.close();
			//MySQLConexion.getConexion().commit();
		} catch(SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public void deleteFacturaProducto(FacturaProducto fp) {
		String delete = "DELETE FROM factura_producto WHERE idFactura=? AND idProducto=?";
		try {
			PreparedStatement ps = MySQLConexion.getConexion().prepareStatement(delete);
			ps.setInt(1, fp.getIdFactura());
			ps.setInt(2, fp.getIdProducto());
			ps.executeUpdate();
			ps.close();
			//MySQLConexion.getConexion().commit();
		} catch(SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

}
