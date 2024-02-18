import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Main {
	
	public static void main(String [] args) {
		
		User [] users = null;
		Subscription [] subs = null;
		Group [] groups = null;
		Member [] members = null;
		
		try {
			File usersFile = new File("Users.txt");
			users = fillUser(usersFile);
		} catch (Exception e) {
			System.out.println("error in reading Users.txt");
		}
		
		try {
			File subsFile = new File("Subscriptions.txt");
			subs = fillSubs(subsFile);
		} catch (Exception e) {
			System.out.println("error in reading Subscriptions.txt");
		}
		
		try {
			File groupFile = new File("Groups.txt");
			groups = fillGroup(groupFile);
		} catch (Exception e) {
			System.out.println("error in reading Groups.txt");
		}
		
		try {
			File membersFile = new File("Members.txt");
			members = fillMembers(membersFile);
		} catch (Exception e) {
			System.out.println("error in reading Members.txt");
		}
		
		System.out.println(task1(users, subs));
		System.out.println(task2(groups, members, users));
		
		
		
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

	public static Group[] fillGroup(File file) throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		int n = sc.nextInt();
		Group[] groups = new Group[n];
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String[] str = sc.nextLine().split(" ");
			int id = Integer.parseInt(str[0]);
			String name = str[1];
			String city = str[2];
			Group group = new Group(id, name, city);
			groups[i] = group;
		}
		return groups;
	}
	
	public static Member[] fillMembers(File file) throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		int n = sc.nextInt();
		Member[] members = new Member[n];
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String[] str = sc.nextLine().split(" ");
			int user_id = Integer.parseInt(str[0]);
			int group_id = Integer.parseInt(str[1]);
			Member member = new Member(user_id, group_id);
			members[i] = member;
		}
		return members;
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
				if (count > maxcount) {
					maxcount = count;
					ans = users[i].getName();
				}
				
			}
			
		}
		return ans;
	}
	
	// работает неправильно
	public static String task2(Group [] groups, Member [] members, User [] users) {
		String ans = "";
		if (members != null && groups != null && users != null) {
			// идем по группам, смотрим ее город. дальше идем по мемберс,
			// members[j].group_id() == groups[i].getId()
			// если город совпадает то флаг = false
			for (int i = 0; i < groups.length; i++) {
				boolean flag = true;
				for (int j = 0; j < members.length && flag == true; j++) {
					String s = users[members[j].getUserId() - 1].getCity();
					if (groups[i].getId() == members[j].getGroupId()) {
						if (groups[i].getCity().equals(s)) {
							flag = false;
						}
					}
					
				}
				if (flag) {
					ans = groups[i].getName();
					return ans;
				}
			}

		}
		return ans;
	}
	
	
}