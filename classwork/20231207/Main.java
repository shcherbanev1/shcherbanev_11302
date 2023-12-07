import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
	
	public static void main(String [] args) {
		
		User [] users = null;
		Subscription [] subs = null;
		
		try {
			File usersFile = new File("Users.txt");
			users = fillUser(usersFile);
		} catch (Exception e) {
			System.out.println("error");
		}
		
		try {
			File subsFile = new File("Subscriptions.txt");
			subs = fillSubs(subsFile);
		} catch (Exception e) {
			System.out.println("error");
		}
		
		if (users != null && subs != null) {

			for (int i = 0; i < users.length; i++) {
				System.out.println(users[i]);
			}
			for (int i = 0; i < subs.length; i++) {
				System.out.println(subs[i]);
			}
			
		}
	}
	
	public static User[] fillUser(File file) throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		int n = sc.nextInt();
		User[] users = new User[n];
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String[] str = sc.nextLine().split(" ");
			int id = Integer.parseInt(str[0]);
			String name = str[1];
			String city = str[2];
			User user = new User(id, name, city);
			users[i] = user;
		}
		return users;
	}
	
	public static Subscription[] fillSubs(File file) throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		int n = sc.nextInt();
		Subscription[] subs = new Subscription[n];
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String[] str = sc.nextLine().split(" ");
			int user1_id = Integer.parseInt(str[0]);
			int user2_id = Integer.parseInt(str[1]);
			Subscription sub = new Subscription(user1_id, user2_id);
			subs[i] = sub;
		}
		return subs;
	}
	
}