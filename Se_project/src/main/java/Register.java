

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String Name=request.getParameter("name");
		String UserName =request.getParameter("username");
		String organisation=request.getParameter("organisation");
		String Email=request.getParameter("email");
		String mobileNo=request.getParameter("mobile");
		String pass=request.getParameter("password");
		String cnfpass=request.getParameter("password");
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Loginpage","root","B210445@cs");
			
			PreparedStatement ps=con.prepareStatement("insert into register values(?,?,?,?,?,?,?)");
			
			ps.setString(1,Name);
			ps.setString(2,UserName);
			ps.setString(3,organisation);
			ps.setString(4,Email);
			ps.setString(5,mobileNo);
			ps.setString(6,pass);
			ps.setString(7,cnfpass);
			
			int i=ps.executeUpdate();
			if(i>0)
			{
				out.print("yor have successfully registered");
				RequestDispatcher rd=request.getRequestDispatcher("login.html");
				rd.include(request, response);
			}
		}catch(Exception e)
		{
			
		}
		out.close();
		
	}

}
