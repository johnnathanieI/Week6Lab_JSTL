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
 * @author johnn
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("username") == null) {
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
	} else {
            request.getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(); // get the session
        String action = request.getParameter("action"); // get the action parameter
    
    if (action.equals("register")) {
        // If action is to register, get the username and store it in the session
        String username = request.getParameter("username");
        session.setAttribute("username", username);
        
        // Create an ArrayList to hold the shopping list items and store it in the session
        ArrayList<String> shoppingList = new ArrayList<>();
        session.setAttribute("shoppingList", shoppingList);
        
        // Redirect to the ShoppingList page
        response.sendRedirect("ShoppingList");
    } else if (action.equals("add")) {
        // If action is to add an item, get the shopping list from the session
        ArrayList<String> shoppingList = (ArrayList<String>) session.getAttribute("shoppingList");
        
        // Get the item to add from the request parameter
        String item = request.getParameter("item");
        
        // Add the item to the shopping list and update the session
        shoppingList.add(item);
        session.setAttribute("shoppingList", shoppingList);
        
        // Redirect to the ShoppingList page
        response.sendRedirect("ShoppingList");
    } else if (action.equals("delete")) {
        // If action is to delete an item, get the shopping list from the session
        ArrayList<String> shoppingList = (ArrayList<String>) session.getAttribute("shoppingList");
        
        // Get the index of the item to delete from the request parameter
        int index = Integer.parseInt(request.getParameter("index"));
        
        // Remove the item from the shopping list and update the session
        shoppingList.remove(index);
        session.setAttribute("shoppingList", shoppingList);
        
        // Redirect to the ShoppingList page
        response.sendRedirect("ShoppingList");
    } else if (action.equals("logout")) {
        // If action is to logout, invalidate the session and redirect to the ShoppingList page
        session.invalidate();
        response.sendRedirect("ShoppingList");
    }
    }

}
