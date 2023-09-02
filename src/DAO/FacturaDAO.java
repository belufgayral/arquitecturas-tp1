package DAO;

import Entidades.Factura;

public interface FacturaDAO {
	
	public void addFactura(Factura f);
	public void updateFactura(Factura f);
	public void deleteFactura(Factura f);
}
