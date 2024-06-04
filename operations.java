import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class operations {

	String url = //your mysql database url
	String userName = //your username
	String passWord = //your password
	Scanner s = new Scanner(System.in);

	public void addRecord() throws Exception{

		int rs=0;

		Connection con = DriverManager.getConnection(url,userName,passWord);

		System.out.println();
		System.out.print("\nEnter Book ISBN ID :");
		int id = Integer.parseInt(s.nextLine());
		System.out.print("\nEnter Title of the Book :");
		String name = s.nextLine();
		System.out.print("\nEnter Name of the Author :");
		String author_name = s.nextLine();
		System.out.print("\nEnter Name of the Publisher :");
		String publisher = s.nextLine();
		System.out.print("\nEnter Price of the Book :");
		int price = Integer.parseInt(s.nextLine());
		int count = isContain(id);

		if(count!=0) {
			String query = "update library set available_count = "+(count+1)+" where isbn_id = "+id;
			Statement st = con.createStatement();
			rs = st.executeUpdate(query);
		}
		else {
			PreparedStatement pst = con.prepareStatement("insert into library(isbn_id,title,author_name,publisher,price,available_count) values(?,?,?,?,?,?)");
			pst.setInt(1,id);
			pst.setString(2, name);
			pst.setString(3, author_name);
			pst.setString(4, publisher);
			pst.setInt(5, price);
			pst.setInt(6,1);

			rs = pst.executeUpdate();
		}

		System.out.println("\n"+rs+" Book Added");
		con.close();
	}


	public int isContain(int id) throws Exception{

		int res = 0;
		Connection con = DriverManager.getConnection(url,userName,passWord);
		String query = "select available_count from library where isbn_id = "+id;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		if(rs.next()) {
			res=rs.getInt(1);
		}

		con.close();
		return res;
	}


	public void viewRecord(String query) throws Exception{

		Connection con = DriverManager.getConnection(url,userName,passWord);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);

		if(!rs.next()) {
			System.out.println("\nNo Records Found!!!");
		}

		else {
			System.out.println("------------------------------------------------------------------------------------------------");
			System.out.print("                                           RECORDS");
			do {
				System.out.println("\n------------------------------------------------------------------------------------------------");
				System.out.print("  "+rs.getInt(1)+"  ||  ");
				System.out.print("  "+rs.getString(2)+"  ||  ");
				System.out.print("  "+rs.getString(3)+"  ||  ");
				System.out.print("  "+rs.getString(4)+"  ||  ");
				System.out.print("  "+rs.getInt(5)+"  ||  ");
				System.out.print("  "+rs.getInt(6)+"    ");
			}
			while(rs.next());
			System.out.println("\n------------------------------------------------------------------------------------------------");
		}

		con.close();
	}


	public void deleteRecord() throws Exception{

		System.out.print("\nEnter the ISBN Id of the Book : ");
		int id = Integer.parseInt(s.nextLine());

		String query = "delete from library where isbn_id = "+id;

		Connection con = DriverManager.getConnection(url,userName,passWord);
		Statement st = con.createStatement();
		int rs = st.executeUpdate(query);

		if(rs==0)
			System.out.println("\nRecord Not Found!!!");

		else
			System.out.println("\n"+rs+" Record Deleted Successfully");

		con.close();
	}


	public void updateRecord()throws Exception {

		System.out.print("\nEnter the ISBN Id of the Book : ");
		int id = Integer.parseInt(s.nextLine());
		System.out.print("\nEnter the Count of the Book to be Updated : ");
		int count = Integer.parseInt(s.nextLine());

		String query = "update library set available_count = "+count+" where isbn_id = "+id;

		Connection con = DriverManager.getConnection(url,userName,passWord);
		Statement st = con.createStatement();
		int rs = st.executeUpdate(query);

		if(rs==0)
			System.out.println("\nRecord Unavailable");
		else
			System.out.println("\n"+rs+" Record Updated");
		con.close();
	}
}
