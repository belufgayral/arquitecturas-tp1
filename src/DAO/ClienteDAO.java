package DAO;

import Entidades.Cliente;

public interface ClienteDAO {
	
	public void addCliente(Cliente c);
	public void updateCliente(Cliente c);
	public void deleteCliente(Cliente c);
	//Escriba un programa JDBC que imprima una lista de clientes, ordenada por a cuál se le facturó más:
	public String listarClientes();
}
