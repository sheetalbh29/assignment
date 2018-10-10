package Answer2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AlreadyServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		try {
			
		DAOService dc = new DAOService();
		boolean isValidUser = dc.validateUser(username,password);
		
		if(isValidUser){
			HttpSession session = request.getSession(true);
			out.print("Welcome " + username + "<br>");
			out.println("Session Id : " + session.getId() + "<br><hr><br>");
			
			DAOOClass dc2=new DAOOClass();
			System.out.println("before calling showdata");
			User user = dc2.showData(username);
			System.out.println("after calling showdata");
			
			
			out.println("Name : " + user.getFirstName() + "<br>");
			out.println("Surname : " + user.getSurName() + "<br>");
			out.println("Login Name : " + user.getLoginName() + "<br>");
			out.println("Password : " + user.getpassword() + "<br>");
			out.println("Password : " + user.getAge() + "<br>");
			String str[] = user.getTopics();
			out.println("Topics : ");
			for (String string : str) {
				out.println(string + "<br>");
			}
		}
			else
			{
				response.sendRedirect("Index2.html");
			}
			
		} 
	catch (Exception e) {
				out.print(""+e);
		}
	
	}

}
