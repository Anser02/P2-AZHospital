package AZHospital;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DoctorLoginn {
	String qry,dcc;
	Scanner ob=new Scanner(System.in);
	Scanner obj=new Scanner(System.in);
	Scanner objj=new Scanner(System.in);
	Connection c;
	
	
	public void Present() throws SQLException
	{
		CreateConnection cc=new CreateConnection();
		c=cc.getConnection();
		ResultSet rs;
		PreparedStatement ps;
		Statement st=c.createStatement();
		System.out.println("enter your D_Code:");
		dcc=objj.nextLine();
		qry="select *from doctors";
		rs=st.executeQuery(qry);
		while(rs.next())
		{
			if(dcc.equals(rs.getString(1)))
					{
				System.out.println(rs.getString(2));
					}
		}

		qry="update doctors set Availability='Yes' where D_Code=?";
		ps=c.prepareStatement(qry);
		ps.setString(1,dcc);
		ps.executeUpdate();
		System.out.println("Updated Successfully...");
	
	}
	
	public void Leave() throws SQLException
	{
		CreateConnection cc=new CreateConnection();
		c=cc.getConnection();
		ResultSet rs;
		PreparedStatement ps;
		Statement st=c.createStatement();
		System.out.println("enter your D_Code:");
		dcc=objj.nextLine();
		qry="select *from doctors";
		rs=st.executeQuery(qry);
		while(rs.next())
		{
			if(dcc.equals(rs.getString(1)))
					{
				System.out.println(rs.getString(2));
					}
		}
		qry="update doctors set Availability='No' where D_Code=?";
		ps=c.prepareStatement(qry);
		ps.setString(1,dcc);
		ps.executeUpdate();
		System.out.println("Updated Successfully...");
	
	}	
	
	public void mypatients() throws SQLException
	{
		CreateConnection cc=new CreateConnection();
		c=cc.getConnection();
		ResultSet rs;
		Statement st=c.createStatement();
		qry="select *from patients;";
		rs=st.executeQuery(qry);
		System.out.println("=================================================================================");
		System.out.println("   Patient Name      |   Age        | Gender " );
		System.out.println("=================================================================================");
		//ps=con.prepareStatement(qry);
		//ps.setString(1,dcc);
		//ps.executeUpdate();
		while(rs.next())
		{
			//if(dcc.equals(rs.getString(6)))
			//System.out.println("fgfhf");
			//if(dcc.equals(rs.getString(6)))
			//{
			System.out.println("=================================================================================");
			System.out.println("   "+rs.getString(2)+"            |    "+rs.getString(4)+"    |         "+rs.getString(5));
			System.out.println("=================================================================================");
			//}
		}
		System.out.println();
	}

}
