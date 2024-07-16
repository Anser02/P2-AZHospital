package AZHospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Medicall {
	String qry;
	Scanner ob=new Scanner(System.in);
	Scanner obj=new Scanner(System.in);
	Scanner objj=new Scanner(System.in);
	Connection c;
	
	void MedicineAllstocksDetails() throws SQLException
	{
		CreateConnection cc=new CreateConnection();
		c=cc.getConnection();
		ResultSet rs;
		PreparedStatement ps;
		Statement st=c.createStatement();
		qry="select *from medicall;";
		rs=st.executeQuery(qry);
		System.out.println("              ***   Total Medicine Stocks   ***   "        );
		System.out.println("============================================================");
		System.out.println("  M_Code | M_Type  |        M_Name        | Total_Stocks | ");
		System.out.println("============================================================");

		while(rs.next())
		{
			System.out.println("============================================================");
			System.out.println("   "+rs.getString(1)+"  |   "+rs.getString(2)+"  |   "+rs.getString(3)+"        |   "+rs.getString(5));
			System.out.println("============================================================");

		}
	}
	 void MedicineBill() throws SQLException
	 {
		 String mc;
			int qty;
			CreateConnection cc=new CreateConnection();
			c=cc.getConnection();
			ResultSet rs;
			PreparedStatement ps;
			Statement st=c.createStatement();
			System.out.println("enter medicine code:");
			mc=obj.nextLine();
			qry="select *from medicall;";
			rs=st.executeQuery(qry);					
			while(rs.next())
			{
				if(mc.equals(rs.getString(1)))	
				{
				System.out.println("===============================");
				System.out.println( rs.getString(3)+"  |   Rs. "+rs.getString(4));
				System.out.println("===============================");
				}
			}
			System.out.println();
			System.out.println("Enter Qty:");
			qty=ob.nextInt();
			if(qty!=0)
			{
				qry="update medicall set Qty=? where M_Code=?";
				ps=c.prepareStatement(qry);
				ps.setInt(1,qty);
				ps.setString(2, mc);
				ps.executeUpdate();
				//System.out.println("updated successfully");
			}
			System.out.println("");
			System.out.println();
			System.out.println("     --------------     AZ Hospital    ---------------     ");
			System.out.println("     No11, Bazaar Road, Near Indian Bank, Ambur-635802.    ");
			System.out.println("             Contact No : 9876543210, 887695662            ");
			System.out.println();
			
			System.out.println("                  ***  Purchase Invoice  ***                      ");
			System.out.println();
	
			qry="select *from medicall;";
			rs=st.executeQuery(qry);	
			System.out.println("===========================================================");
			System.out.println("      Medicine Name               Qty          Amount     ");
			System.out.println("===========================================================");

			while(rs.next())
			{
				if(mc.equals(rs.getString(1)))
				{
				System.out.println("       "+rs.getString(3)+"                "+rs.getString(6)+"             "+rs.getString(7));
				System.out.println("===========================================================");
				}

			}
				System.out.println();
				System.out.println("                     *** THANK YOU ***                    ");
				System.out.println("                   *** Have a Nice Day ***                ");
	 }
	 void Availablestocks() throws SQLException
	 {
		 	
		 CreateConnection cc=new CreateConnection();
			c=cc.getConnection();
			ResultSet rs;
			PreparedStatement ps;
			Statement st=c.createStatement();
			qry="select *from medicall;";
			rs=st.executeQuery(qry);
			System.out.println();
			System.out.println("                         ***   Remaining Stocks   ***                         ");
			System.out.println();
			System.out.println("==============================================================================");
			System.out.println("  M_Code | M_Type  |        M_Name        |  Total Stock   | Remainig_Stocks  ");
			System.out.println("==============================================================================");

			while(rs.next())
			{
				System.out.println("==============================================================================");
				System.out.println("  "+rs.getString(1)+"   | "+rs.getString(2)+"  | "+rs.getString(3)+"             |    "+ rs.getString(5)+"         |     "+rs.getString(8));
				System.out.println("==============================================================================");

			}
	 }
}
