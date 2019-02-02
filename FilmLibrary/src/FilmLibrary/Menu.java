package FilmLibrary;
import java.util.Scanner;

public class Menu {

	private int sel;
	private int con;
	Scanner s = new Scanner(System.in);
	Scanner t = new Scanner(System.in);
	
	public void displaymenu() {
		System.out.println("Welcome...");
		System.out.println("1. ADD movie to the entry");
		System.out.println("2. READ movie list");
		System.out.println("3. CLEAR data");
		System.out.println("4. END program");
	}
	
	public int selmenu() {
		System.out.printf("ENTER your selection: \t");
		sel = s.nextInt();
		return sel;
	}
	
	public int selcontinue() {
		System.out.println("\n\n" + "Do you want to CONTINUE or END program?");
		System.out.println("\t 1. CONTINUE");
		System.out.println("\t 2. END");
		System.out.printf("Enter your selection: \t");
		con = t.nextInt();
		System.out.printf("\n\n");
		return con;
	}
	
}
