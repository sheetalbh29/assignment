package dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DaoConnection {
	static Connection con = null;

	static Connection getConnection(String path) throws NamingException, SQLException {
		Context ctx;

		ctx = new InitialContext();
		DataSource ds;
		ds = (DataSource) ctx.lookup("java:comp/env/jdbc/myTestDBCP");
		con = ds.getConnection();

		return con;
	}
}
