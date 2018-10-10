package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import bean.User;

public class DaoClass {
public ResultSet getTopic(String path) throws NamingException, SQLException{
	Connection con = DaoConnection.getConnection(path);
	PreparedStatement preparedStatement=con.prepareStatement("select distinct TOPIC from QUIZUSER");
	ResultSet rs=preparedStatement.executeQuery();
	return rs;
	
}
public boolean registerUser(User user,String path) throws NamingException, SQLException{
	Connection con = DaoConnection.getConnection(path);
	PreparedStatement preparedStatement=con.prepareStatement("insert into QUIZUSER values(?,?,?,?)");
	preparedStatement.setString(1, user.getUsername());
	preparedStatement.setString(2, user.getPassword());
	preparedStatement.setInt(3, user.getAge());
	preparedStatement.setString(4, user.getTopic());
	int rs=preparedStatement.executeUpdate();
	if(rs>0)
	return true;
	else
		return false;
}
public boolean isValidUser(String username, String password, String path) throws NamingException, SQLException {
	
		Connection con = DaoConnection.getConnection(path);
		int i = 0;
		PreparedStatement preparedStatement=con.prepareStatement("select * from QUIZUSER where username=? and password=?");
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);
		ResultSet rs=preparedStatement.executeQuery();
		System.out.println("inside valid");
		while (rs.next()) {
			i++;
		}
		if (i > 0) 
			return true;
		 else 
			return false;
}

public ResultSet showUser(String username, String password, String path) throws NamingException, SQLException {
	
		Connection con = DaoConnection.getConnection(path);
		PreparedStatement preparedStatement=con.prepareStatement("select * from QUIZUSER where username=? and password=?");
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);
		ResultSet rs=preparedStatement.executeQuery();
		return rs;
	
}

public ResultSet getQuestion(String topic,String path) throws NamingException, SQLException{
	Connection con = DaoConnection.getConnection(path);
	PreparedStatement preparedStatement=con.prepareStatement("select * from QUIZ where TOPIC=?");
	preparedStatement.setString(1, topic);
	ResultSet rs=preparedStatement.executeQuery();
	return rs;	
}
}
