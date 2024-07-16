package AZHospital;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AdminLoginn extends CreateConnection
{
	String qry;
	Scanner ob=new Scanner(System.in);
	Scanner obj=new Scanner(System.in);
	Scanner objj=new Scanner(System.in);
	Connection c;
	void AddNewDoctor() throws SQLException
	{
		c=getConnection();
		PreparedStatement ps;
		Statement st=c.createStatement();
		ResultSet rs;
		String ndt,dn,dt,rn,da,dc,ccn,dun,ddp;
		System.out.println("Enter D_Code: (format : s1,g1,e1...etc)");
		ndt=obj.nextLine();
		System.out.println("Enter Doctor Name : (format : Dr.Asrar)");
		dn=obj.nextLine();
		System.out.println("Enter Doctor Contact No:");
		ccn=obj.nextLine();
		System.out.println("Specilist : (format : Skin Doctor,General Doctor,Eye Doctor...etc)");
		dc=obj.nextLine();
		System.out.println("Enter Doctor Duty Time : (format : 09:00am to 01:00pm)");
		dt=obj.nextLine();
		//System.out.println("Enter Doctor Room No : (format : 01,02,03...etc)");
		//rn=obj.nextLine();
//		System.out.println("Enter Doctor Availability Status (format : Yes or No)");
//		da=obj.nextLine();
		System.out.println("Enter Doctor Userid:");
		dun=obj.nextLine();
		System.out.println("Enter Doctor Password:");
		ddp=obj.nextLine();
		qry="insert into doctors (D_Code,Doctor_name,Contact_No,Specialist,duty_time,userid,pasword)values (?,?,?,?,?,?,?)";
		ps=c.prepareStatement(qry);
		ps.setString(1,ndt);
		ps.setString(2,dn);
		ps.setString(3,ccn);
		ps.setString(4,dc);
		ps.setString(5,dt);
		//ps.setString(6, rn);
		//ps.setString(6,da);
		ps.setString(6,dun);
		ps.setString(7,ddp);
		ps.executeUpdate();
		System.out.println();
		System.out.println("==============================================================================");
		System.out.println(" ***   New Doctor Details Successfully Added into Hospital DataBase   ***");
		System.out.println("==============================================================================");		
	}	

	void ParticularDoctorPatients() throws SQLException
	{
		String pd;
		c=getConnection();
		ResultSet rs;
		Statement st;
		st=c.createStatement();
		System.out.println("Enter D_Code:");
		pd=obj.nextLine();
		qry="select *from patients;";
		rs=st.executeQuery(qry);
			while(rs.next())
			{
				if(pd.equals(rs.getString(6)))
				{
			System.out.println("=================================================================================");
			System.out.println("   "+rs.getString(2)+"            |    "+rs.getString(4)+"    |         "+rs.getString(5));
			System.out.println("=================================================================================");
				}
			}
	}
}
