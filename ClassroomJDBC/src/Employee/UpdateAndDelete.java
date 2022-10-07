package Employee;
import java.sql.*;
import java.util.*;

public class UpdateAndDelete {

	public static void main(String[] args) {
	try {
		Scanner s = new Scanner(System.in);
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","sahdev","Devengla");
		PreparedStatement ps1 = con.prepareStatement("select*from Employee where Eid =?");
		PreparedStatement ps2 = con.prepareStatement("update Employee set bSal =?,totsal=? where Eid =?");
		PreparedStatement ps3 = con.prepareStatement("delete from Empolyee where Eid =? ");
		
		System.out.println("Enter the empId:");
		String id = s.nextLine();
		ps1.setString(1,id);
		ResultSet rs = ps1.executeQuery();
		if(rs.next())
		{
			System.out.println("==Choice==");
			System.out.println("1.viewDetails \n 2.UpdateDetails\n 3.DeleteDetails");
			System.out.println("Enter the Choice:");
			switch(Integer.parseInt(s.nextLine()))
			{
		
			case 1:
		
			System.out.println(rs.getString(1)+"\t" + rs.getString(2)+"\t" +rs.getString(3)+"\t"+rs.getInt(4)+"\t" +rs.getFloat(5));
			break;
			
			case 2:
				System.out.println("old bSal:" +rs.getInt(4));
				System.out.println("Enter new bSal:");
				int  newBSal = Integer.parseInt(s.nextLine());
				Float newTotSal = +(0.93F*newBSal)+(0.63F*newBSal);
				ps2.setInt(1, newBSal);
				ps2.setFloat(2, newTotSal);
		 		ps2.setString(3, id);
				int k = ps2.executeUpdate();
				
				if(k>0)
				{
					System.out.println("Details  Updated SuccessFully...");
					
				}
				break;
			case 3:
				ps3.setString(1, id);
				int z = ps3.executeUpdate();
				if(z>0)
				{
					System.out.println("Details  Updated SuccessFully...");
				}
				
				break;
				default:
					 System.out.println("Invalid Choice...");
			}
			
		}
		{
			System.out.println("Invalid empId...");
		}
		
	}catch(Exception e) {e.printStackTrace();}

}
}

