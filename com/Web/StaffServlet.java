package src.main.java.com.Web;

import src.main.java.com.DAO.StaffDAO;
import src.main.java.com.Model.Staff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/staff")
public class StaffServlet extends HttpServlet {
    private StaffDAO staffDao;

    @Override
    public void init() {
        staffDao = new StaffDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("register".equals(action)) {
            // registration
            Staff staff = new Staff();
            staff.setName(request.getParameter("name"));
            staff.setAge(Integer.parseInt(request.getParameter("age")));
            staff.setGender(request.getParameter("gender"));
            staff.setAddress(request.getParameter("address"));
            staff.setPhoneNumber(request.getParameter("phone_number"));
            staff.setEmail(request.getParameter("email"));
            staff.setPassword(request.getParameter("password")); 

            // Register for the staff
            staffDao.registerStaff(staff);
            response.sendRedirect("staff_login.jsp"); 
        } else if ("login".equals(action)) {
            // login staff
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            Staff staff = staffDao.getStaffByEmail(email);

            if (staff != null && staff.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("staff", staff);
                response.sendRedirect("staff_dashboard.jsp");
            } else {
                request.setAttribute("errorMessage", "Invalid email or password");
                request.getRequestDispatcher("staff_login.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("staff_registration.jsp").forward(request, response); 
    }
}