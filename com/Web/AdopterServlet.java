package src.main.java.com.Web;

import src.main.java.com.DAO.AdopterDAO;
import src.main.java.com.Model.Adopter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/adopter")
public class AdopterServlet extends HttpServlet {

  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("register".equals(action)) {
           
            Adopter adopter = new Adopter();
            adopter.setName(request.getParameter("name"));
            adopter.setContactInfo(request.getParameter("contact_info"));
            adopter.setEmail(request.getParameter("email"));
            adopter.setPassword(request.getParameter("password")); 
            adopter.setAge(Integer.parseInt(request.getParameter("age")));

            AdopterDAO.registerAdopter(adopter);
            response.sendRedirect("adopter_login.jsp");

        } else if ("login".equals(action)) {
           
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            Adopter adopter = AdopterDAO.getAdopterByEmail(email);

           
            if (adopter != null && adopter.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("adopter", adopter);
                response.sendRedirect("adopter_dashboard.jsp"); 
            } else {
                request.setAttribute("errorMessage", "Invalid email or password");
                request.getRequestDispatcher("adopter_login.jsp").forward(request, response);
            }
        } else {
           
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Unknown action: " + action);
        }
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("adopter_registration.jsp").forward(request, response); 
    }
}