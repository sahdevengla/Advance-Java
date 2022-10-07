package Employee;
import java.sql.*;
import java.util.*;

public class CombineOperations {
	public static void main(String[] args)  {
		try {
			
			Scanner s = new Scanner(System.in);
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","sahdev","Devengla");
			PreparedStatement ps1 = con.prepareStatement("select*from Employee where Eid =?");
			PreparedStatement ps2 = con.prepareStatement("update Employee set bSal =?,totsal=? where Eid =?");
			PreparedStatement ps3 = con.prepareStatement("delete from Empolyee where Eid =? ");
			PreparedStatement ps4 = con.prepareStatement("insert into Employee values(?,?,?,?,?)");
			PreparedStatement ps5 = con.prepareStatement("Select*from Employee");
			while(true)
			{
				System.out.println(" ===Choice===");
				System.out.println("");
				System.out.println("1.AddEmployee\n 2.viewEmployees\n 3.view employee by empId");
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
					System.out.println("");
					System.out.println("\t 3. Enter Number for below oparation by id ");
                   // System.out.println("");
					System.out.println("   ==Choice==   ");
					System.out.println("1.viewDetails \n 2.UpdateDetails\n 3.DeleteDetails");
					System.out.println("Enter the Choice:");
					int c = Integer.parseInt(s.nextLine());
					System.out.println("Enter the empId:");
					String id = s.nextLine();
					ps1.setString(1,id);
					ResultSet rs1 = ps1.executeQuery();
					if(rs1.next())
					{
						switch(c)
						{
					
						case 1:
					
						System.out.println(rs1.getString(1)+"\t" + rs1.getString(2)+"\t" +rs1.getString(3)+"\t"+rs1.getInt(4)+"\t" +rs1.getFloat(5));
						break;
						
						case 2:
							System.out.println("old bSal:" +rs1.getInt(4));
							System.out.println("Enter new bSal:");
							int  newBSal = Integer.parseInt(s.nextLine());
							Float newTotSal = +(0.93F*newBSal)+(0.63F*newBSal);
							ps2.setInt(1, newBSal);
							ps2.setFloat(2, newTotSal);
					 		ps2.setString(3, id);
							int k1 = ps2.executeUpdate();
							
							if(k1>0)
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
			             }//switch2 
						
					}//if2
					
					
					
					
					else {
						System.out.println("Invalid empId...");
					}
					break;
				
				}//switch1
					
			  break;
			}//while
			
		}//try
					
	  			
			
		catch(Exception e)
		{
			e.printStackTrace();
		}//catch


			

			
	}//main method
}//class
			


