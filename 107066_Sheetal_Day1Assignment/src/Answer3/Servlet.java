package Answer3;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("userName");
		String upassw=request.getParameter("password");
		
		ArrayList<User> alist=new ArrayList<User>();

			alist.add(new User("Rosh","BadRosh"));
			alist.add(new User("Rach","BadRosh"));
			alist.add(new User("Mon","BadRosh"));
			int c=0;
			for(User u:alist){
				if(uname.equalsIgnoreCase(u.getUserName())&&upassw.equalsIgnoreCase(u.getPassword())){
					request.setAttribute("userName",uname);
					request.setAttribute("password",upassw );
					System.out.println("fgh");
					RequestDispatcher rd = request.getRequestDispatcher("UserInfo");
					rd.forward(request, response);
					c=1;
				}
				
				
			}
			if(c==0){
				response.sendRedirect("Index.html");
			}
	}
}
