package DAOFactories;

import DAO.*;

public abstract class DAOFactory {
	public static final String MYSQL = "mysql";
	
	public static MySQLDAOFactory mySQLDAOFactory;
	
	public abstract ClienteDAO getClienteDAO();
	public abstract FacturaDAO getFacturaDAO();
	public abstract FacturaProductoDAO getFacturaProductoDAO();
	public abstract ProductoDAO getProductoDAO();
	
	//switch 
	public static DAOFactory getDAOFactory(String db) {
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

