package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckAnswerServlet extends HttpServlet {

  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String answer1=request.getParameter("answer1");
	String answer2=request.getParameter("answer1");
	String answer3=request.getParameter("answer1");
	String answer4=request.getParameter("answer1");
	String answer5=request.getParameter("answer1");
	}

}
