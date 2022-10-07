package Employee;
import java.util.*;
import java.sql.*;
public class InsertionUsingPS {

	public static void main(String[] args) {
	try {
		Scanner s = new Scanner(System.in);
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","sahdev","Devengla");
		PreparedStatement ps1 = con.prepareStatement("insert into Employee values(?,?,?,?,?)");
		PreparedStatement ps2 = con.prepareStatement("Select*from Employee");
		
		while(true)
		{
			System.out.println("===Choice===");
			System.out.println("1.AddEmployee\n 2.viewEmployees\n 3.exit");
			System.out.println("Enter the Choice: ");
			switch(Integer.parseInt(s.nextLine()))
			{
			case 1:
				System.out.println("Enter the empId:");
				String eId = s.nextLine();
				System.out.println("Enter the empName:");
				String eName = s.nextLine();
				System.out.println("Enter the empDesg:");
				String desg = s.nextLine();
				System.out.println("Enter the empBSal:");
				int bSal = Integer.parseInt(s.nextLine());
				float totSal = bSal +(0.93F*bSal)+(0.63F*bSal);
				
				ps1.setString(1,eId);
				ps1.setString(2,eName);
				ps1.setString(3, desg);
				ps1.setInt(4, bSal);
				ps1.setFloat(5, totSal);
				
				int k = ps1.executeUpdate();
				if(k>0)
				{
					System.out.println("Employee Added Succesfully");
				}
				break;
				
			case 2:
				ResultSet rs = ps2.executeQuery();
				while(rs.next())
				{
					System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t" +rs.getFloat(5));
				}
				break;
			
			case 3:
				System.out.println("Operations Stopped...");
				System.exit(0);
				
				default:
					System.out.println("Invalid Choice...");			
		     }
		
		  }
	
	 } catch(Exception e ) { e.printStackTrace(); }
   }
}


