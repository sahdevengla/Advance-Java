package book;
import java.sql.*;
import java.util.Scanner;

public class RetriveDetails {

	public static void main(String[] args) {
		try {
			Scanner s= new Scanner(System.in);
			System.out.println("Enter a Book code:");
			String bCode=s.nextLine();		
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","sahdev","Devengla");
			Statement stm = con.createStatement();
		    ResultSet rs = stm.executeQuery("select bCode,bName,bAuthor,bPrice,bQty from Book where bcode='"+bCode+"'");
			  
		    System.out.println("bcode\t"+"bname\t"+"bAuthor\t\t"+"bPrice\t"+"bQty\t");
		    System.out.println("");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"\t" +rs.getString(2)+"\t" +rs.getString(3)+"\t" +rs.getFloat(4)+"\t"+rs.getInt(5));
				
			}
			
			
			
			con.close();
			s.close();
			
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
