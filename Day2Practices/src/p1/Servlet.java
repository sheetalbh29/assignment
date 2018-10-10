package p1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
int pid = Integer.parseInt(request.getParameter("projectId"));
		
	
		
		Database dbObj = new Database();
		Project project = dbObj.getProjectDetails(pid);

		if (project != null) {

			request.setAttribute("projectId",pid);
			request.setAttribute("project",project );
			RequestDispatcher rd = request.getRequestDispatcher("Output");
			rd.forward(request, response);
			
		} else {
			response.sendRedirect("ProjectForm.jsp");
		}

	
	}

}
