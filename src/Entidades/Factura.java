package Entidades;

public class Factura {
	private int idFactura;
	private int idCliente;
	
	public Factura(int idFactura, int idCliente) {
		this.idFactura = idFactura;
		this.idCliente = idCliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public int getIdFactura() {
		return idFactura;
	}
}
