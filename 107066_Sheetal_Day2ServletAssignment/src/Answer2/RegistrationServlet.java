package Answer2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String surname = request.getParameter("surname");
		String login = request.getParameter("loginname");
		String password = request.getParameter("password");
		int age = Integer.parseInt(request.getParameter("age"));
		String[] top = request.getParameterValues("t1");

		if (username.isEmpty() || surname.isEmpty() || login.isEmpty() || password.isEmpty() || age <= 0
				|| top.length == 0) {
			response.sendRedirect("index2.html");
		}
		User u = new User(username, surname, login, password, age, top);
		

		try {
			DAOOClass obj1 = new DAOOClass();
			boolean b = obj1.insertUser(u);

			if (b)
				out.print("Data Inserted");
			else
				out.print("Data Not Inserted");

		} catch (Exception e) {
			out.print(e);
		}

	}

}
