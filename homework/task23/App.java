import java.util.Scanner;

public class App {
	public static void main(String [] args) {
		
		final int MAX_HP = (args.length == 1) ? Integer.parseInt(args[0]) : 100;
		Scanner in = new Scanner(System.in);
		System.out.println("play with bot or with human?");
		System.out.println("1. bot");
		System.out.println("2. human");
		int choice;
		do {
			choice = in.nextInt();
		} while (choice != 1 && choice != 2);
		AbstractGame g;
		if (choice == 1) {
			g = new GameWithComputer(MAX_HP);
		} else {
			g = new GameWithHuman(MAX_HP);
		}
		g.go();
	}
	
}