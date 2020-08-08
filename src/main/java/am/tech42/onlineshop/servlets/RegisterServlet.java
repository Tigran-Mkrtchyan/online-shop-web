package am.tech42.onlineshop.servlets;

import am.tech42.onlineshop.model.User;
import am.tech42.onlineshop.service.UserService;
import org.postgresql.util.PSQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phone = req.getParameter("phone");
        String pass = req.getParameter("pass");
        String name = req.getParameter("name");
        User user = null;
        try {
            user = UserService.registerUser(phone,pass,name);
        } catch (PSQLException e) {
            if (e.getServerErrorMessage().getConstraint().equals("users_phone_number_key")) {
                          resp.sendRedirect("/register?error");
           }else{
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        if(user != null){
            req.getSession().setAttribute("loggedInUser", user);
            resp.sendRedirect("/");
        }
    }
}
