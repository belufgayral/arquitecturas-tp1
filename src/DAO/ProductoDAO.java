package DAO;

import Entidades.Producto;

public interface ProductoDAO {

	public void addProducto(Producto p);

	//Escriba un programa JDBC que retorne el producto que más recaudó. Se define 
	//“recaudación” como cantidad de productos vendidos multiplicado por su valor:
	public Producto getProductoMayorRecaudacion();
}
