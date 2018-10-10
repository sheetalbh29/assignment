package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.DaoClass;

public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			ServletContext ctx= getServletContext();
			String path=ctx.getInitParameter("datasoursePath");
			HttpSession session=request.getSession(true);
			String username=request.getParameter("username");
			String password=request.getParameter("password");

			try {
				DaoClass dao=new DaoClass();
				boolean check=dao.isValidUser(username,password,path);
				ResultSet rs=dao.showUser(username, password, path);
				if(check){
					if(rs!=null){
						User u=new User();
						session.setAttribute("rs",rs);
					//	session.setAttribute("topic",u.getTopic());
						/*RequestDispatcher rd = request.getRequestDispatcher("Quiz.jsp");
						rd.forward(request,response);*/
						response.sendRedirect("Quiz1.jsp");
					}
					else {
						RequestDispatcher rd = request.getRequestDispatcher("LoginAndRegister.jsp");
						rd.forward(request,response);
					}
				}
				else {
					RequestDispatcher rd = request.getRequestDispatcher("LoginAndRegister.jsp");
					rd.forward(request,response);
				}
			} catch (NamingException | SQLException e) {
				e.printStackTrace();
			}
	
	}

}
