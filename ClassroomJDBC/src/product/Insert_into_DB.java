package product;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Insert_into_DB {
 
		public static void main(String[] args) throws SQLException
			{
				
				Connection con=null;
				Statement stm=null;
				
				try {
					Scanner s= new Scanner(System.in);
					System.out.println("Enter the Prodcode:");
					String pCode =s.nextLine();
					System.out.println("Enter the ProdName:");
					String pName = s.nextLine();
					System.out.println("Enter the ProdPrice:");
					float pPrice = s.nextFloat();
					System.out.println("Enter the ProdQty");
					int pQty = s.nextInt();
					String sql="INSERT INTO  product VALUES ('"+pCode+"','"+pName+"',"+pPrice+","+pQty+")";
					
					 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","sahdev","Devengla");
				      stm =  con.createStatement();
					int k= stm.executeUpdate(sql);
				         
					
					if(k>0)
					{
						System.out.println("Product Details inserted Successfully");
						
					}
					else 
					{ System.out.println("Product not inserted...");}
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				finally {
					stm.close();
					con.close();
				}
			}	
			}



	
	

