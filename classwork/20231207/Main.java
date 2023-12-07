import java.util.Scanner;
import java.io.File;

public class Main {
	
	public static void main(String [] args) {
		File file = new File("Users.txt");
		fillUser(file);
	}
	
	public static void fillUser(File file) {
		try {
			Scanner sc = new Scanner(file);
			int n = sc.nextInt();
			sc.nextLine();
			for (int i = 0; i < n; i++) {
				String str = sc.nextLine();
				System.out.println(str);
			}
		} catch (Exception e) {
			System.out.println("error");
		}
	}
	
}