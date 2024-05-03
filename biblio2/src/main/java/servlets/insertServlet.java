package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.LivreDao;
import postgresql.Connectiondb;
import MYSQLIMP.MoviesDAOImpl;
import Modals.Movie;


@WebServlet("/InsertMovieServlet")
public class InsertMovieServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
 private MovieDAO moviesDAO;

 public void init() throws ServletException {
  super.init();
  // database connection
  Connection connection = null;
  try {
   connection = Connectiondb.getConnection();
  } catch (SQLException e) {
   e.printStackTrace(); // Handle SQLException appropriately
  }
  moviesDAO = new MoviesDAOImpl(connection);
 }


 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

 }

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String Title = request.getParameter("Title");
  String Description = request.getParameter("Description");
  String ReleaseDateString = request.getParameter("ReleaseDate");
  int Duration = Integer.parseInt(request.getParameter("Duration"));
  String Genre = request.getParameter("Genre");
  String Director = request.getParameter("Director");
  String Cover = request.getParameter("Cover");

  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
  try {

   java.util.Date parsedReleaseDate = dateFormat.parse(ReleaseDateString);
   long milliseconds = parsedReleaseDate.getTime(); // Get milliseconds
   java.sql.Date ReleaseDate = new java.sql.Date(milliseconds);

   Movie movie = new Movie(Title, Description, ReleaseDate, Duration, Genre, Director, Cover);
   moviesDAO.insertMovie(movie);


   response.sendRedirect(request.getContextPath() + "/affcihermovies");
  } catch (ParseException e) {
   e.printStackTrace();
  } catch (SQLException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
 }


}
