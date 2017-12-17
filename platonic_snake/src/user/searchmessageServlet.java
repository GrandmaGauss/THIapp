package user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class searchmessageServlet
 */
@WebServlet("/searchmessageServlet")
public class searchmessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(lookup="jdbc/MyTHIPool")
	private DataSource ds;
	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchmessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		final String username = request.getParameter("username");
	
		List <messageBean> messages = read(username);
		
		final HttpSession session = request.getSession();
		session.setAttribute("messages", messages);
		
		final RequestDispatcher disp = request.getRequestDispatcher("jsp/Messages/showmessages.jsp");
		disp.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public List <messageBean> read (String username) throws ServletException {
		List <messageBean> messages = new ArrayList <messageBean>();
		
		try (Connection con = ds.getConnection(); 
			 PreparedStatement pstmt = con.prepareStatement("SELECT m.username, m.inhalt, m.date, m.user FROM messages AS m JOIN users AS u ON u.username = m.username WHERE m.username = ?")){
			 pstmt.setString(1, username);
			
			try (ResultSet rs = pstmt.executeQuery()){
				while (rs.next()) {
					messageBean message = new messageBean();
					message.setusername(rs.getString(1));
					message.setinhalt(rs.getString(2));
					message.setDate(rs.getTimestamp(3));
					message.setuser(rs.getString(4));
					messages.add(message);
				}
			}
			
		}
		catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		return messages;
	}

}
