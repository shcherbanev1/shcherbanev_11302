import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

// 1ый подписан на 2ого
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
		
		System.out.println(task1(users, subs));
		
		
		for (int i = 0; i < subs.length; i++) {
			System.out.println(subs[i]);
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
	
	public static String task1(User [] users, Subscription [] subs) {
		String ans = "";
		if (users != null && subs != null) {
			int maxcount = 0;
			for (int i = 0; i < users.length; i++) {
				// идем по пользователям, для каждого пользователя считаем сколько чел
				// из его города подписаны на него. для этого смотрит в subs
				// второй должен совпадать с айдишником пользователя по которому мы проходимся (currentId)
				// а первый должен быть из того же города что и второй
				int count = 0;
				
				// int currentId = users[i].getId();
				for (int j = 0; j < subs.length; j++) {
					String s = users[subs[j].getFirstId() - 1].getCity();
					if (users[i].getId() == subs[j].getSecondId()  && users[i].getCity().equals(s)) {
						count += 1;
					}
				}
				System.out.println(count);
				if (count > maxcount) {
					maxcount = count;
					ans = users[i].getName();
				}
				
			}
			
		}
		return ans;
	}
	
}