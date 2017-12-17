package user;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

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
 * Servlet implementation class Search
 */
@WebServlet("/Interests")
public class Interests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 @Resource(lookup="jdbc/MyTHIPool")
	    private DataSource ds; 
    /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
  

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
    
        //request.setCharacterEncoding("UTF-8";)
        String interests = request.getParameter("interests");
        
        //DB-Zugriff
        List<UserData> users = search(interests);
        
        //Scope 
        request.setAttribute("users", users);
        
         //Weiterleiten an JSP
        final RequestDispatcher disp = request.getRequestDispatcher("jsp/Interests/ResultPage.jsp");
    
        disp.forward(request, response);
        
    }   
    
    
        private List <UserData> search(String interests) throws ServletException {
            interests = (interests == null || interests == "") ? "%" : "%" + interests + "%";
            List<UserData> users = new ArrayList<UserData>();
            System.out.println("Der User:" + interests);
            
            //DB-Zugriff
            try (Connection con = ds.getConnection();
                    PreparedStatement pstmt = con.prepareStatement("SELECT * from users WHERE interests LIKE ?")){
                        
                        pstmt.setString(1, interests);
                        
                                    
                        try (ResultSet rs = pstmt.executeQuery()){
                            
                            while (rs.next()){
                                UserData user = new UserData();
                                                             
                             //   Long id = Long.valueOf(rs.getLong("id"));
                            //    user.setId(id);
                                
                                                             
                                
                                byte[] photo = rs.getBytes("photo");
                                user.setPhoto(photo);
                                
                                String interests0 = rs.getString("interests");
                                user.setInterests(interests0);
                             
                                String username = rs.getString("username");
                                user.setUsername(username);
                                                        
                                
                                                              
                                users.add(user);
                                
                           
                            }
                        }
                      }catch (Exception ex){
                          throw new ServletException(ex.getMessage());
                      }
                      return users;
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
