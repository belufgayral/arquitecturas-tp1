package Helpers;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import Entidades.*;

public class Generador {
	private static String clientesCSV = "./src/DataSet/clientes.csv";
	private static String facturasCSV = "./src/DataSet/facturas.csv";
	private static String productosCSV = "./src/DataSet/productos.csv";
	private static String facturasproductosCSV = "./src/DataSet/facturas-productos.csv";
	
	
	public static List<Cliente> clientesCSV() {
		CSVParser parser = null;
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(clientesCSV));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (CSVRecord row: parser) {
			clientes.add(new Cliente(Integer.parseInt(row.get(0)), row.get(1), row.get(2)));
		}
		return clientes;
	}
	
	public static List<Factura> facturasCSV() {
		CSVParser parser = null;
		List<Factura> facturas = new ArrayList<Factura>();
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(facturasCSV));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(CSVRecord row: parser) {
			facturas.add(new Factura(Integer.parseInt(row.get(0)), Integer.parseInt(row.get(1))));
		}
		return facturas;
	}
	
	public static List<Producto> productosCSV() {
		CSVParser parser = null;
		List<Producto> productos = new ArrayList<Producto>();
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(productosCSV));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(CSVRecord row: parser) {
			productos.add(new Producto(Integer.parseInt(row.get(0)), row.get(1), Float.parseFloat(row.get(2))));
		}
		return productos;
	}
	
	
	public static List<FacturaProducto> facturasProductosCSV() {
		CSVParser parser = null;
		List<FacturaProducto> facturasProductos = new ArrayList<FacturaProducto>();
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(facturasproductosCSV));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(CSVRecord row: parser) {
			facturasProductos.add(new FacturaProducto(Integer.parseInt(row.get(0)), Integer.parseInt(row.get(1)), Integer.parseInt(row.get(2))));
		}
		
		return facturasProductos;
	}
}
