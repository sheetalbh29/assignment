package Answer2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAOService {
	Connection con;
	PreparedStatement ps;

	public DAOService() throws SQLException, NamingException {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/myTestDBCP");
		con = ds.getConnection();
		System.out.println(" ->. con " + con);
	}
	public boolean validateUser(String username,String password)throws Exception
	{
		boolean isValid = false;
		System.out.println(getClass()+" -------->> Validate User called ...."+username+" & "+password);
		System.out.println("helo");
		ps = con.prepareStatement("select * from MyUser where username =? and password =?");
		ps.setString(1,username);
		ps.setString(2,password);	
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			isValid = true;
		}
		System.out.println(getClass()+" -------->> Validate User return  ...."+isValid);
		return isValid;
	}
}
