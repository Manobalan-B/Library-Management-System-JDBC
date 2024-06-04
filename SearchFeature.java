import java.util.Scanner;

public class SearchFeature {
	Scanner s = new Scanner(System.in);
	String choice;
	String query;
	operations op = new operations();
	
	public void initiator() throws Exception {
		switch(choice) {
			case "1":
				searchById();
				break;
			case "2":
				searchByName();
				break;
			case "3":
				searchByAuthor();
				break;
			case "4":
				searchByPublisher();
				break;
			default:
				System.out.println("\nPlease Enter a Valid Option...");
				SearchMenu();
		}
	}
	
	public void SearchMenu() throws Exception {
		System.out.println("\n1.Search By ISBN ID");
		System.out.println("2.Search By Book Name");
		System.out.println("3.Search By Author");
		System.out.println("4.Search By Publisher");
		System.out.print("\nSelect Filters From the above Option : ");
		choice = s.nextLine();
		initiator();
	}
	
	public void searchById()throws Exception {
		System.out.print("\nEnter the ISBN ID : ");
		int id = Integer.parseInt(s.nextLine());
		query = "SELECT * FROM library WHERE isbn_id = "+id;
		op.viewRecord(query);
	}
	
	public void searchByName()throws Exception {
		System.out.print("\nEnter the Book Name : ");
		String b_name = s.nextLine();
		query = "SELECT * FROM library WHERE title like '"+b_name+"%'";
		op.viewRecord(query);
	}
	
	public void searchByAuthor()throws Exception {
		System.out.print("\nEnter the Author Name : ");
		String a_name = s.nextLine();
		query = "SELECT * FROM library WHERE author_name like '"+a_name+"%'";
		op.viewRecord(query);
	}
	
	public void searchByPublisher()throws Exception {
		System.out.print("\nEnter the Publisher Name : ");
		String p_name = s.nextLine();
		query = "SELECT * FROM library WHERE publisher like '"+p_name+"%'";
		op.viewRecord(query);
	}
}
