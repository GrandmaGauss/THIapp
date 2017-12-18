package user;

import java.io.IOException;
import java.sql.Connection;
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

/**
 * Servlet implementation class changeUser
 */
@WebServlet("/changeUserServlet")
public class changeUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(lookup="jdbc/MyTHIPool")
    private DataSource ds;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		UserBean user = new UserBean();
		user.setUsername(request.getParameter("username"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setBirthday(request.getParameter("birthday"));
		user.setLocation(request.getParameter("location"));
		user.setInterests(request.getParameter("interests"));
		
		persist(user);
		
        request.setAttribute("user", user);
		
		final RequestDispatcher rd=request.getRequestDispatcher("jsp/Edit/bearbeitet.jsp");  
        rd.forward(request,response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void persist(UserBean user) throws ServletException {
		try (Connection con = ds.getConnection();
			 PreparedStatement pstmt = con.prepareStatement("UPDATE users SET email=?, password=?, birthday=?, location=?, interests=? WHERE username =?")) {
			 
			 pstmt.setString(1, user.getEmail());
			 pstmt.setString(2, user.getPassword());
			 pstmt.setString(3, user.getBirthday());
			 pstmt.setString(4, user.getLocation());
			 pstmt.setString(5, user.getInterests());
			 pstmt.setString(6, user.getUsername());
			 pstmt.executeUpdate();
		}
		catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}

}