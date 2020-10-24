package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Daniel Tompkins (818339)
 */
public class ShoppingListServlet extends HttpServlet {
    ArrayList<String> items = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	if (request.getParameter("username") != null) {
	    getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);      
	} else {
	    getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
	}
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session = request.getSession();
	
	if (request.getParameter("action").equals("register") && !request.getParameter("username").equals("")) {
	    String username = request.getParameter("username");
	    session.setAttribute("username", username);
	    request.setAttribute("message", username);
	    getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
	} else if (request.getParameter("action").equals("register")) {
	    request.setAttribute("message", "A username must be entered.");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
	}
	
	if (request.getParameter("action").equals("add")) {
	    String item = request.getParameter("item");
	    items.add(item);
	    request.setAttribute("items", items);
	    getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
	}
	
	if (request.getParameter("action").equals("delete")) {
	    String item = request.getParameter("item");
	    items.remove(item);
	    request.setAttribute("items", items);
	    getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
	}
	
	if (request.getParameter("action").equals("logout")) {
	    
	    
	    request.setAttribute("message", "Logged out.");
	    getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
	}
    }
}
