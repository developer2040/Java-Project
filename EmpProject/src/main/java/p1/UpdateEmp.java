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


public class UpdateEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateEmp() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("empid"));
		String name=request.getParameter("empname");
		double salary=Double.parseDouble(request.getParameter("empsal"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empdata","root","root");
			
			String sql="update empdetails set name=?,salary=? where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setDouble(2, salary);
			ps.setInt(3, id);
			
			int val=ps.executeUpdate();
			if (val==1) {
				System.out.println("Done");
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	
	}

}
