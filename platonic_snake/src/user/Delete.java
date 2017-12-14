package user;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	 @Resource(lookup="jdbc/MyTHIPool")
     private DataSource ds; 
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
  
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Servlet zur Entgegennahme von Formularinhalten, Löschen der Daten in einer DB und Generierung
        // eines Feldes zur Weitergabe an eine JSP
    //    request.setCharacterEncoding("UTF-8");  // In diesem Format erwartet das Servlet jetzt die Formulardaten
        String username = String.valueOf(request.getParameter("username"));
        String password = String.valueOf(request.getParameter("password"));
    
        //DB-Zugriff
        delete(username, password);

    
        //Scope "Request"
        request.setAttribute("username", username);
        request.setAttribute("password", password);
    
        //Weiterleiten an JSP
        final RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/Delete/AccountDeleted.jsp");
        dispatcher.forward(request, response);  
}
    
    private void delete(String username, String password) throws ServletException {
        //DB-Zugriff
        try (Connection con = ds.getConnection();
                PreparedStatement pstmt = con.prepareStatement ("DELETE FROM users WHERE username = ? AND password = ?")){
                pstmt.setString(1, username);
                pstmt.setString(2, password);
           // pstmt.set(1,form.getUsername());
             //   pstmt.setString(3, form.getPassword());
                pstmt.executeUpdate();
                } catch (Exception ex){
                    throw new ServletException(ex.getMessage());
                }
                
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
  

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
