import java.util.Scanner;

public class LibraryMain {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		System.out.println("LIBRARY MANAGEMENT SYSTEM");
		printMenu();
		String choice = "-1";
		operations op = new operations();
		while(!choice.equalsIgnoreCase("6")) {
			choice = s.nextLine();
			switch (choice) {
	            case "1":
	            	op.addRecord();
	            	printMenu();
	                break;
	            case "2":
	            	op.viewRecord("select * from library");
	            	printMenu();
	                break;
	            case "3":
	            	SearchFeature sf = new SearchFeature();
	            	sf.SearchMenu();
	            	printMenu();
	                break;
	            case "4":
	            	op.updateRecord();
	            	printMenu();
	                break;
	            case "5":
	            	op.deleteRecord();
	            	printMenu();
	                break;
	            case "6":
	            	System.out.println("\nThank You!!!");
	                break;        
	            default:
	                System.out.println("\nPlease Enter a Valid Choice!!!");
	                printMenu();
	                break;
			}
		}
	}
	
	public static void printMenu() {
		System.out.println();
		System.out.println("              MENU");
        System.out.println("\n1.Add Book");
        System.out.println("2.Display Book");
        System.out.println("3.Search Book");
        System.out.println("4.Update Record");
        System.out.println("5.Delete Book");
        System.out.println("6.Exit");
        System.out.print("\nEnter Your Choice : ");
	}
}
