package p1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			
			int id=Integer.parseInt(request.getParameter("emid"));
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empdata", "root", "root");
				String sql="delete from empdetails where id=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, id);
				
				int val=ps.executeUpdate();
				if (val==0) {
					System.out.println("Done");
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			
	
	
	
	}

}
