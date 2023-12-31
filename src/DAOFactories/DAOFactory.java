package DAOFactories;

import java.sql.SQLException;

import DAO.*;

public abstract class DAOFactory {
	public static final String MYSQL = "mysql";
	
	private static MySQLDAOFactory mySQLDAOFactory;
	
	public abstract ClienteDAO getClienteDAO();
	public abstract FacturaDAO getFacturaDAO();
	public abstract FacturaProductoDAO getFacturaProductoDAO();
	public abstract ProductoDAO getProductoDAO();
	public abstract void poblarTablas() throws SQLException ;
	
	//switch con Singleton
	public static DAOFactory getDAOFactory(String db) throws SQLException {
		switch(db) {
			case MYSQL : {
				if (mySQLDAOFactory == null) 
					mySQLDAOFactory = new MySQLDAOFactory();
				return mySQLDAOFactory;
				}
			default : return null;
		}
	}
}

