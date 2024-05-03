import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.MembreDAOImpl;
import metier.Membre;

@WebServlet("/updateProfile")
public class UpdateProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        String password = request.getParameter("password");
        String nomMembre = request.getParameter("nom_membre");
        String adresse = request.getParameter("adresse");
        String tele = request.getParameter("tele");


        Membre updatedMembre = new Membre();
        updatedMembre.setUsername(username);
        updatedMembre.setPassword(password);
        updatedMembre.setNom_membre(nomMembre);
        updatedMembre.setAdresse(adresse);
        updatedMembre.setTele(tele);

        System.out.println("===========================");
        System.out.println(updatedMembre.getNom_membre());
        System.out.println(updatedMembre.getUsername());


        MembreDAOImpl membreDAO = new MembreDAOImpl();
        membreDAO.update(updatedMembre);


        response.sendRedirect(request.getContextPath() + "/UpdateProfile.jsp");
    }





}
