package Main;

import java.sql.SQLException;

import DAOFactories.DAOFactory;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		DAOFactory mySQLDAOFactory = DAOFactory.getDAOFactory("mysql");
		System.out.println(":)");
	}

}
