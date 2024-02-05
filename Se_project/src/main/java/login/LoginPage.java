package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginPage {
	
	public static boolean validate(String UserName,String pass)
	{
		boolean status=false;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Loginpage","root","B210445@cs");
			
			PreparedStatement ps=con.prepareStatement("select *from register where UserName=? and pass=?");
			ps.setString(1,UserName);
			ps.setString(2,pass);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			
			
		}catch(Exception e)
		{
			
		}
		return status;
		
	}

}
