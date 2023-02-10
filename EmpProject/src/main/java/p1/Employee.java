package p1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.jsp.tagext.TryCatchFinally;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.apache.jasper.tagplugins.jstl.core.Catch;

import com.mysql.cj.xdevapi.PreparableStatement;

//class DBconnect{
//	//public static Connection con;
//	try {
//		Connection con=Class.forName("com.mysql.cj.jdbc.Driver");
//		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empdata","root","root");
//	}catch(Exception e){
//		System.out.println(e);
//	}
//	
//	
//	
//	
//}
public class Employee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    public Employee() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String emId=request.getParameter("empid");
		String emName=request.getParameter("empname");
		String emSal=request.getParameter("empsal");
		
		out.print("<h1>ID: "+emId+"</h1><br>");
		out.print("<h1>Name: "+emName+"</h1><br>");
		out.print("<h1>Salary: "+emSal+"</h1><br>");
		
		int id=Integer.parseInt(emId);
		double salary=Double.parseDouble(emSal);
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empdata","root","root");
			String sql="insert into empdetails values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2,emName);
			ps.setDouble(3, salary);
			
			int val=ps.executeUpdate();
			if (val==1) {
				System.out.println("Done");
			}
		}catch(Exception e){
			System.out.println(e);
		}
		
		
	}

}



