package AZHospital;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



class CreateConnection
{
	public  static Connection getConnection() throws SQLException
	{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/azhospitals","root","");
		return con;
	}
}


public class Mainn {
	
	public static void main(String[] args) throws SQLException {
		Connection c;
		CreateConnection cc=new CreateConnection();
		c=cc.getConnection();
		Statement st;
		st=c.createStatement();
		ResultSet rs;
		boolean found = false;
		Scanner obj=new Scanner(System.in);
		String qry,s,s1,s2,s3,s4;		
		System.out.println("     --------------     AZ Hospital    ---------------     ");
		System.out.println("     No11, Bazaar Road, Near Indian Bank, Ambur-635802.    ");
		System.out.println();
		System.out.println("   ***   Press '1' - Reception Login   ***   ");
		System.out.println("   ***   Press '2' - Doctor Login      ***   ");
		System.out.println("   ***   Press '3' - Medical Login     ***   ");
		System.out.println("   ***   Press '4' - Admin Login       ***   ");
		System.out.println();
		System.out.println("Input:");
		s=obj.nextLine();
		switch(s)
		{		
		//Reception Login
		case "1":
			String ui,pp;
			int i;
			for(i=0;i<55;i++)
			{
			System.out.println("Enter User-Id:");
			ui=obj.nextLine();
			System.out.println("Enter password:");
			pp=obj.nextLine();
			qry="select *from Reception_Login;";
			rs=st.executeQuery(qry);
			while(rs.next())
			{
				if(ui.equals(rs.getString(1))&&pp.equals(rs.getString(2)))
				{
					found=true;
					System.out.println("==========================================");
					System.out.println("   *** login Succssfull ***   ");
					System.out.println("==========================================");

					System.out.println();
			while(true)
			{
				System.out.println();
			System.out.println("   ***   Press 'd' - Doctor Informations     ***   ");
			System.out.println("   ***   Press 'p' - Patient Informations    ***   ");
			System.out.println("   ***   Press 'a' - Add New Patient Entry   ***   ");
			System.out.println("   ***   Press 'l' - LogOut                  ***   ");
			s1=obj.nextLine();
			Receptionn r=new Receptionn();
			switch(s1)
			{
			case "d":
				r.doctors();
				break;
			case "p":
				r.patientlist();
				break;
			case "a":
				r.patiententry();
				break;
			case "l" :
				System.out.println("==========================================");
				System.out.println("   *** LogOut Successfull ***   ");
				System.out.println("==========================================");
				System.exit(0);
				break;
				default : System.out.println("   *** Invalid Input ***   ");
			}
			}
			}
			}
			if(!found)
			{
				System.out.println();
				System.out.println("   *** Invalid login ***   ");
			System.out.println();
			System.out.println(" *** Enter Correct Userid & Password *** ");
		System.out.println();
			}
			}	
			
			
		//Doctor Login	
		case "2":
			String uii,ppp;
			
			for(i=0;i<50;i++)
			{
			System.out.println("Enter User-Id:");
			uii=obj.nextLine();
			System.out.println("Enter password:");
			ppp=obj.nextLine();
			qry="select *from doctors;";
			rs=st.executeQuery(qry);
			while(rs.next())
			{
				if(uii.equals(rs.getString(6))&&ppp.equals(rs.getString(7)))
				{
					found=true;
					System.out.println("==========================================");
					System.out.println("   *** login Succssfull ***   ");
					System.out.println("==========================================");

					System.out.println();
			
			while(true)
			{
			System.out.println("   ***   Press 'a' - My Patients Details      ***   ");
			System.out.println("   ***   Press 'on' - Doctor Duty - On        ***   ");
			System.out.println("   ***   Press 'off' - Doctor Duty - Off      ***   ");
			System.out.println("   ***   Press 'l' - LogOut                   ***   ");
			s2=obj.nextLine();
			DoctorLoginn dl=new DoctorLoginn();
			switch(s2)
			{
			case "off":
				dl.Leave();
			break;
			case "on":
				dl.Present();
			break;
			case "a":
				dl.mypatients();
				break;
			case "l" :
				System.out.println("==========================================");
				System.out.println("   *** LogOut Successfull ***   ");
				System.out.println("==========================================");
				System.exit(0);
				break;
				default : System.out.println("   *** Invalid Input ***   ");
			}	
			}
				}
			}
			if(!found)
			{
				System.out.println();
				System.out.println("   *** Invalid login ***   ");
			System.out.println();
			System.out.println(" *** Enter Correct Userid & Password *** ");
		System.out.println();
			}
			}	
			
		//Medical Login
		case "3":
			String uiii,pppp;			
			for(i=0;i<50;i++)
			{
			System.out.println("Enter User-Id:");
			uiii=obj.nextLine();
			System.out.println("Enter password:");
			pppp=obj.nextLine();
			qry="select *from Medical_Login;";
			rs=st.executeQuery(qry);
			while(rs.next())
			{
				if(uiii.equals(rs.getString(1))&&pppp.equals(rs.getString(2)))
				{
					found=true;
					System.out.println("==========================================");
					System.out.println("   *** login Succssfull ***   ");
					System.out.println("==========================================");

					System.out.println();
			while(true)
			{
			System.out.println();
			System.out.println("   ***   Press 'a' - All Medicine Stocks   ***   ");
			System.out.println("   ***      Press 'b' - Bill Generate      ***   ");
			System.out.println("   ***     Press 's' - Remaining Stocks    ***   ");
			System.out.println("   ***       Press 'l' -  For Logout       ***   ");
			s3=obj.nextLine();
			Medicall m=new Medicall();
			switch(s3)
			{
			case "a":
				m.MedicineAllstocksDetails();
				break;
			case "b":
			m.MedicineBill();
			break;
			case "s":
				m.Availablestocks();
				break;
			case "l" :
				System.out.println("==========================================");
				System.out.println("   *** LogOut Successfull ***   ");
				System.out.println("==========================================");
				System.exit(0);
				break;
				default : System.out.println("   *** Invalid Input ***   ");
			}
			}
				}
			}
			if(!found)
			{
				System.out.println();
				System.out.println("   *** Invalid login ***   ");
			System.out.println();
			System.out.println(" *** Enter Correct Userid & Password *** ");
		System.out.println();
			}
			}	
			
			
			
		//Adminn Login
		case "4":
			String uiiii,ppppp;			
			for(i=0;i<50;i++)
			{
			System.out.println("Enter User-Id:");
			uiiii=obj.nextLine();
			System.out.println("Enter password:");
			ppppp=obj.nextLine();
			qry="select *from admin_login;";
			rs=st.executeQuery(qry);
			while(rs.next())
			{
				if(uiiii.equals(rs.getString(1))&&ppppp.equals(rs.getString(2)))
				{
					found=true;
					System.out.println("==========================================");
					System.out.println("   *** login Succssfull ***   ");
					System.out.println("==========================================");

					System.out.println();
					while(true)
					{
			System.out.println();
			System.out.println("   ***   Press 'd'  - Doctor Informations    		***   ");
			System.out.println("   ***   Press 'p'  - Patient Informations  	 	***   ");
			System.out.println("   ***   Press 'ad' - Add New Doctor Details		***   ");
			System.out.println("   ***   Press 'ap' - Add New Patient Entry  		***   ");
			System.out.println("   ***   Press 'pd' - Patient of Particular Docotor ***   ");
			System.out.println("   ***   Press 'l'  - LogOut                        ***   ");
			s4=obj.nextLine();
			Receptionn r=new Receptionn();
			AdminLoginn a=new AdminLoginn();
			switch(s4)
			{
			case "d":
				r.doctors();
				break;
			case "p":
				r.patientlist();
			break;
			case "ad":
				a.AddNewDoctor();
				break;
			case "ap":	
				r.patiententry();
			break;
			case "pd":
				a.ParticularDoctorPatients();
				break;
			case "l" :
				System.out.println("==========================================");
				System.out.println("   *** LogOut Successfull ***   ");
				System.out.println("==========================================");
				System.exit(0);
				break;
				default : System.out.println("   *** Invalid Input ***   ");
			}			
					}
		}	
			}
				if(!found)
				{
					System.out.println();
					System.out.println("   *** Invalid login ***   ");
				System.out.println();
				System.out.println(" *** Enter Correct Userid & Password *** ");
			System.out.println();
				}
			}
			break;
		default :
			System.out.println("   *** Invalid Input ***   ");
			}
	}
}