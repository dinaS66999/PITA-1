package src.main.java.com.Web;

import src.main.java.com.DAO.PetDAO;
import src.main.java.com.Model.Pet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/pets")
public class PetServlet extends HttpServlet {
    private PetDAO petDAO;

    @Override
    public void init() {
        petDAO = new PetDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            List<Pet> pets = petDAO.getAllPets();
            request.setAttribute("pets", pets);
            request.getRequestDispatcher("view_pets.jsp").forward(request, response);
        } else if (action.equals("edit")) {
            int petId = Integer.parseInt(request.getParameter("id"));
            Pet pet = petDAO.getPetById(petId);
            request.setAttribute("pet", pet);
            request.getRequestDispatcher("edit_pet.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
    
        if (action != null) {
            if (action.equals("add")) {
                Pet pet = new Pet();
                pet.setName(request.getParameter("name"));
                pet.setType(request.getParameter("type"));
                pet.setAge(Integer.parseInt(request.getParameter("age"))); // Assuming you have an age field
                pet.setSex(request.getParameter("sex")); // Assuming you have a sex field
                pet.setHealth(request.getParameter("health")); // Assuming you have a health field
                pet.setStatus(request.getParameter("status"));
                petDAO.addPet(pet);
                response.sendRedirect("pets"); // Redirect to view pets
            } else if (action.equals("update")) {
                Pet pet = new Pet();
                pet.setId(Integer.parseInt(request.getParameter("id")));
                pet.setName(request.getParameter("name"));
                pet.setType(request.getParameter("type"));
                pet.setAge(Integer.parseInt(request.getParameter("age"))); // Assuming you have an age field
                pet.setSex(request.getParameter("sex")); // Assuming you have a sex field
                pet.setHealth(request.getParameter("health")); // Assuming you have a health field
                pet.setStatus(request.getParameter("status"));
                petDAO.updatePet(pet);
                response.sendRedirect("pets"); // Redirect to view pets
            } else if (action.equals("delete")) {
                int petId = Integer.parseInt(request.getParameter("id"));
                petDAO.deletePet(petId);
                response.sendRedirect("pets"); // Redirect to view pets
            } else {
                // Handle unknown action
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Unknown action: " + action);
            }
        } else {
            // Handle missing action
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Action parameter is missing.");
        }
    }
}
