package AZHospital;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Receptionn extends CreateConnection
{
	String qry;
	Connection c;
	Scanner ob=new Scanner(System.in);
	Scanner obj=new Scanner(System.in);
	Scanner objj=new Scanner(System.in);
	
	void doctors() throws SQLException
	{
		c=getConnection();
		//c=getConnection();		
		Statement st=c.createStatement();
		ResultSet rs;
		PreparedStatement ps;
		
		qry="select *from doctors;";
		rs=st.executeQuery(qry);
		System.out.println();
		System.out.println("======================================================================================================================");
		System.out.println("D_Code |  Doctor Name      | Contact No   |     Specialist     |        Duty Time       |  Room No  | D_Availability      " );
		System.out.println("======================================================================================================================");
		while(rs.next())
		{
		//System.out.println("======================================================================================================================");
		//System.out.println(rs.getString(1)+"    | "+rs.getString(2)+"   |    "+rs.getString(3)+"    |    "+rs.getString(4)+"   |   "+rs.getString(5)+"  |    "+rs.getString(6)+"     |     "+rs.getString(9));
		//System.out.println("======================================================================================================================");
		System.out.println();
		System.out.println("==================================================");
		System.out.println("D_Availability   :   "+rs.getString(8));
		System.out.println("D_Code           :   "+rs.getString(1));
		System.out.println("D_Name           :   "+rs.getString(2));
		System.out.println("Specialist       :   "+rs.getString(4));
		System.out.println("Duty_Time        :   "+rs.getString(5));
		//System.out.println("D_Contact		 :"+rs.getString(3));
		System.out.println("==================================================");
		}
	}

	void patiententry() throws SQLException
	{
		c=getConnection();
		PreparedStatement ps;
		int pa,tn;
		Statement st=c.createStatement();
		ResultSet rs;
		String pn,pg,dp,cc; 
		qry="select *from doctors where Availability='Yes'";
		rs=st.executeQuery(qry);
		while(rs.next())
		{
			System.out.println();
			System.out.println("======================================================================================================================");
			System.out.println(rs.getString(1)+"    | "+rs.getString(2)+"  |    "+rs.getString(4)+"   |   "+rs.getString(5));
			System.out.println("======================================================================================================================");

		}
		System.out.println();	
		System.out.println("Enter Patient Name:");
		pn=obj.nextLine();
		System.out.println("Enter Contact no:");
		cc=obj.nextLine();
		System.out.println("Enter Patient Age:");
		pa=ob.nextInt();
		System.out.println("Enter Patient Gender: (Type 'm'  or  'f')");
		pg=obj.nextLine();
		System.out.println("D_Code:");
		dp=obj.nextLine();

		qry="insert into patients (Patient_Name,Contact_No,Age,Gender,D_Code) values (?,?,?,?,?);";
		ps=c.prepareStatement(qry);
		ps.setString(1,pn);
		ps.setString(2,cc);
		ps.setInt(3,pa);
		ps.setString(4,pg);
		ps.setString(5,dp);
		ps.executeUpdate();
		System.out.println();
		System.out.println("==========================================");
		System.out.println("   *** Token Generated Successfully ***   ");
		System.out.println("==========================================");		
	}
	public void patientlist() throws SQLException
	{
		c=getConnection();		
		Statement st=c.createStatement();
		ResultSet rs;
		qry="select *from patients;";
		rs=st.executeQuery(qry);
		System.out.println("=================================================================================");
		System.out.println(" Token No |   Patient Name    |  Contact No   | Age   | Gender |  D_Code     " );
		System.out.println("=================================================================================");
		while(rs.next())
		{
			System.out.println("=================================================================================");
			System.out.println("   "+rs.getString(1)+"     |      "+rs.getString(2)+"      | "+rs.getString(3)+"   |   "+rs.getString(4)+"  |   "+rs.getString(5)+"   |   "+rs.getString(6));
			System.out.println("=================================================================================");
		}
	}
}
