package product;
import java.sql.*;

public class Display_Product_Details {
    
	public static void main(String[] args) throws SQLException   {
	    
		Connection con =null;
		Statement stm=null;
		ResultSet rs =null;
		
		try	
		
	   {	
		 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","sahdev","Devengla");
		 stm = con.createStatement();
	     rs = stm.executeQuery("select * from product");
	     
	     System.out.println("PCODE\t\t"+"PNAME\t"+"PPRICE\t"+"PQTY\t");
		while(rs.next())
		{
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t" +rs.getFloat(3)+"\t"+rs.getInt(4));
		}	   
	}
	catch(Exception e)
	{
		e.printStackTrace();

	}
		
	finally {
			rs.close();
			stm.close();
			con.close();	
		}
		
     }

}
