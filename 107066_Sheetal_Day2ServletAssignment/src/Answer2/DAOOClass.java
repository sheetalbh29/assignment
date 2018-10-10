package Answer2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAOOClass {

	Connection con;
	PreparedStatement ps;

	public DAOOClass() throws SQLException, NamingException {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/myTestDBCP");
		con = ds.getConnection();
		System.out.println(" ->. con " + con);
	}

	public boolean insertUser(User u) throws Exception {
		boolean isInserted = false;

		System.out.println(" ----->> inside insertUser " + u);

		ps = con.prepareStatement("insert into MyUser values(?,?,?,?,?,?)");
		ps.setString(1, u.getFirstName());
		ps.setString(2, u.getSurName());
		ps.setString(3, u.getLoginName());
		ps.setString(4, u.getpassword());
		ps.setInt(5, u.getAge());
		String str = "";
		for (String string : u.getTopics()) {
			str = " " + string + ",";
		}
		ps.setString(6, str);

		int x = ps.executeUpdate();
		if (x > 0)
			isInserted = true;

		System.out.println("--------->> " + isInserted);
		return isInserted;
	}

	public User showData(String username) throws SQLException {

		ps = con.prepareStatement("Select * from MyUser where username = ?");
		ps.setString(1, username);
		System.out.println("before execute query...");
		ResultSet rs = ps.executeQuery();
		System.out.println("after execute query...");
		System.out.println(rs);
		rs.next();
		System.out.println(rs);
		User user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
				rs.getString(6).split(","));
		System.out.println("object instantiated...");
		return user;
	}
}
