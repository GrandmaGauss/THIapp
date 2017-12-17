package user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session= request.getSession();
        session.invalidate();
        
        final RequestDispatcher disp = request.getRequestDispatcher("jsp/Logout/LoggedOut.jsp");
        disp.forward(request, response);
        }

public void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException
        {
        doGet(request, response);
        }

}
