package DAO;

import java.sql.SQLException;
import java.util.List;
import Entidades.Cliente;

public interface ClienteDAO {
	
	public void addCliente(Cliente c) throws SQLException;
	public void updateCliente(Cliente c) throws SQLException;
	public void deleteCliente(Cliente c) throws SQLException;
	public List<String> listarClientes() throws SQLException;
}
