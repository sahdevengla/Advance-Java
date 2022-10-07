package book;
import java.sql.*;
import java.util.Scanner;

public class Insert_Into_DB {

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			System.out.println("Enter Book Code:");
			String bCode=s.nextLine();
			System.out.println("Enter Book name:");
			String bName=s.nextLine();
			System.out.println("Enter Book author name:");
			String bAuthor =s.nextLine();
			System.out.println("Enter Book Price:");
			float bPrice=s.nextFloat();
			System.out.println("Enter Book Qty:");
			int bQty=s.nextInt();
			  Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","sahdev","Devengla");
			  Statement stm = con.createStatement();
			  int k = stm.executeUpdate("insert into Book values ('"+bCode+"','"+bName+"','"+bAuthor+"',"+bPrice+","+bQty+")");
			  if(k>0)
			  {
				  System.out.println("Book Details inserted Successfully:");
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
