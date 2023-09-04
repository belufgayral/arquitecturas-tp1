package DAO;

import java.sql.SQLException;

import Entidades.Factura;

public interface FacturaDAO {
	
	public void addFactura(Factura f) throws SQLException;
}
