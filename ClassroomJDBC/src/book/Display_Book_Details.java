package book;
import java.sql.*;

public class Display_Book_Details {

	public static void main(String[] args) {
		try 
		{
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","sahdev","Devengla");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select*from Book");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"\t" +rs.getString(2)+"\t" +rs.getString(3)+"\t" +rs.getFloat(4)+"\t"+rs.getInt(5));
				
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		}
		
}


