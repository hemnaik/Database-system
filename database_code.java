//DATABASE MANAGEMENT SYSTEM//
import java.sql.*;
import java.util.Scanner;
class update
{
	int id;
	String updatename;
	Scanner sc=new Scanner(System.in);
	public void update_data()
	{
		try
		{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","password");
	   
	        System.out.println("ENTER UPDATE NAME:");
			updatename=sc.nextLine();
			System.out.println("ENTER ID:");
			id=sc.nextInt();
			
	        String select="SELECT * FROM customer_info WHERE id="+id;
			Statement s=con.createStatement();
			s.execute(select);
			ResultSet rs=s.executeQuery(select);
		        boolean flag=false;
			while(rs.next())
			{
			    if(id==rs.getInt(1))
				{
					flag=true;
					break;
				}
			}
			if(flag==true)
			{
				 String update="UPDATE customer_info SET name=? WHERE id=?";
				 PreparedStatement p=con.prepareStatement(update);
				 p.setString(1,updatename);
			          p.setInt(2,id);
				 p.executeUpdate();
				 con.close();
				 System.out.println("RECORD UPDATED SUCESSFULLY");
			}
			else
			{
				System.out.println("RECORD NOT FOUND");
			}
		}
		catch(Exception l)
	        {
			System.out.println("RECORD CANNOT BE UPDATED");
		}
	}
}
class select
{
	int id;
	Scanner sc=new Scanner(System.in);
	public void select_data()
	{
		try
		{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","password");
	   
	        System.out.println("ENTER ID:");
			id=sc.nextInt();
	        String select="SELECT * FROM customer_info WHERE id="+id;
			Statement s=con.createStatement();
			s.execute(select);
			ResultSet rs=s.executeQuery(select);
		    boolean flag=false;
			while(rs.next())
			{
			    if(id==rs.getInt(1))
				{
					flag=true;
					break;
				}
			}
			if(flag==true)
			{
			     String select1="SELECT * FROM customer_info WHERE id="+id;
			     Statement s1=con.createStatement();
			     s1.execute(select1);
			     ResultSet rs1=s1.executeQuery(select1);
		  
			     while(rs1.next())
			     {
					  System.out.println("ID="+rs1.getString(1)+"    NAME="+rs1.getString(2));
			     }
			}
			else
			{
				System.out.println("RECORD NOT FOUND");
			}
		}
		catch(Exception k)
		{
			System.out.println("RECORD CANNOT BE DISPLAY");
		}
	}
}
class delete
{
	int id;
	Scanner sc=new Scanner(System.in);
	public void delete_data()
	{
		try
		{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","password");
	   
	        System.out.println("ENTER ID FOR RECORD DELETION:");
		id=sc.nextInt();
	        String delete="DELETE FROM customer_info WHERE id=?";
	        PreparedStatement p=con.prepareStatement(delete);
	        p.setInt(1,id);
	        p.executeUpdate();
	        con.close();
			System.out.println("RECORD DELETED SUCCESSFULLY");
		}
		catch(Exception k)
		{
			System.out.println("RECORD CANNOT BE INSERTED");
		}
	}
}
class insert
{
	int id;
	String name;
	Scanner sc=new Scanner(System.in);
	public void insert_data()
	{
		try
		{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","password");
	   
	        System.out.println("ENTER NAME & ID:");
	        name=sc.nextLine();
			id=sc.nextInt();
	        String insert="INSERT INTO customer_info(id,name) VALUES(id,name)";
	        PreparedStatement p=con.prepareStatement(insert);
	        p.executeUpdate();
	        con.close();
			System.out.println("RECORD INSERTED SUCCESSFULLY");
		}
		catch(Exception k)
		{
			System.out.println("RECORD CANNOT BE INSERTED");
		}
	}
}
public class database 
{
	public static void main(String args[])
	{
		int choice;
		Scanner sc=new Scanner(System.in);
		for(;;)
		{
			System.out.println("1--->INSERT");
			System.out.println("2--->DELETE");
			System.out.println("3--->SELECT");
			System.out.println("4--->UPDATE");
			System.out.println("5--->EXIT");
			System.out.println("ENTER CHOICE:");
			choice=sc.nextInt();
			switch(choice)
			{
				case 1:
				insert i=new insert();
				i.insert_data();
				break;
				case 2:
				delete d=new delete();
				d.delete_data();
				break;
				case 3:
				select s=new select();
				s.select_data();
				break;
				case 4:
			    update u=new update();
				u.update_data();
				break;
				case 5:
				System.exit(1);
				default:
				System.out.println("INVALID CHOICE!!!");
			}
		}
		
	}
}
