package user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
 * Servlet implementation class messageServlet
 */
@WebServlet("/messageServlet")
public class messageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Resource(lookup="jdbc/MyTHIPool")
	private DataSource ds;
	Timestamp ts;
	java.util.Date now = new java.util.Date();

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public messageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		messageBean message = new messageBean();
		message.setusername(request.getParameter("username"));
		message.setinhalt(request.getParameter("inhalt"));
		message.setuser(request.getParameter("user"));
		
		ts = getTimestamp();
		message.setDate(ts);
		
		persist(message);
	
		final HttpSession session = request.getSession();
		session.setAttribute("message", message);
		
		final RequestDispatcher disp = request.getRequestDispatcher("jsp/Messages/message.jsp");
		disp.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	
	public void persist(messageBean message) throws ServletException {
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement("INSERT INTO messages (username,inhalt, date, user) VALUES (?,?,?,?)")){
			pstmt.setString(1,message.getusername());
			pstmt.setString(2, message.getinhalt());
			pstmt.setTimestamp(3, new java.sql.Timestamp(now.getTime()));
			pstmt.setString(4, message.getuser());
		
			pstmt.executeUpdate();
			
		}
		catch(Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		
	}
	public static Timestamp getTimestamp(){
		Timestamp ts= new Timestamp(System.currentTimeMillis());
		return ts;
		}

}
