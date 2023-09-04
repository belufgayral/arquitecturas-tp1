package DAOMySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.ProductoDAO;
import Entidades.Producto;
import Helpers.MySQLConexion;

public class MySQLDAO_Producto implements ProductoDAO {

	@Override
	public void addProducto(Producto p) {
		String insert = "INSERT INTO producto (idProducto, nombre,valor) VALUES (?,?,?)";
		try {
			PreparedStatement ps = MySQLConexion.getConexion().prepareStatement(insert);
			ps.setInt(1, p.getIdProducto());
			ps.setString(2, p.getNombre());		
			ps.setFloat(3, p.getValor());
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
	public Producto getProductoMayorRecaudacion() {
		String select = "SELECT p.idProducto,p.nombre, p.valor FROM tp1.producto p " +
				"LEFT JOIN tp1.factura_producto fp ON p.idProducto = fp.idProducto " +
				"GROUP BY(p.idProducto) ORDER BY SUM(fp.cantidad)*p.valor desc LIMIT 1";
		try {
			PreparedStatement ps = MySQLConexion.getConexion().prepareStatement(select);
			ResultSet rs = ps.executeQuery();
			//ps.executeUpdate();
			while(rs.next()){
				Producto prod = new Producto(rs.getInt(1),rs.getString(2),rs.getInt(3));
				return prod;
			}
			ps.close();
//			MySQLConexion.getConexion().commit();
		} catch(SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}
