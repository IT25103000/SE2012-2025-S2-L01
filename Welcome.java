import java.util.Scanner;

public class Welcome {

	public static void main(String[]args) {
	
		Scanner input = new Scanner(System.in);

		System.out.print("Enter your first name:");
		String firstname = input.nextLine();
		
		System.out.print("Enter your Last name:");
		String Lastname = input.nextLine();

		System.out.println("Welcome to the second year " + " " + firstname + " " + Lastname);

		input.close();
		}
}

