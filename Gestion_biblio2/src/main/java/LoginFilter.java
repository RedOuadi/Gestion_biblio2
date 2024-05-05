import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.SingletonConnection;

@WebFilter("/login")
public class LoginFilter implements Filter {

    public void init(FilterConfig fConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;


        String username = request.getParameter("username");
        String password = request.getParameter("password");


        try {
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM admin WHERE username = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                HttpSession session = httpRequest.getSession();
                session.setAttribute("username", username);
                session.setAttribute("role", "admin");
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/admin.jsp");
                return;
            }


            ps = connection.prepareStatement("SELECT * FROM membre WHERE username = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {

                HttpSession session = httpRequest.getSession();
                session.setAttribute("username", username);
                session.setAttribute("role", "membre");
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/membre.jsp");
                return;
            }


            request.setAttribute("error", "Invalid username or password");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;

        } catch (SQLException e) {
            e.printStackTrace();

        }


        chain.doFilter(request, response);
    }


    public void destroy() {

    }

}



