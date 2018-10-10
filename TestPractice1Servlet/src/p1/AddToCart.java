package p1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

public class AddToCart extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> cart=new ArrayList<Product>();
		String[] checkBox=request.getParameterValues("t1");
		
		for (String string : checkBox) {
			cart.add(new Product(string));
		}
		HttpSession session = request.getSession();
		session.setAttribute("cart",cart);
		response.sendRedirect("AddToCart.jsp");
			
		}
	}
