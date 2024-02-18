package storage;

import models.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Storage {
	
	private User [] users;
	private Subscription [] subs;
	private Group [] groups;
	private Member [] members;
	
	public Storage() {
		
	}
	
	public void init() throws FileNotFoundException {
		getUser(new File("resources/Users.txt"));
		getGroup(new File("resources/Groups.txt"));
		getSubs(new File("resources/Subscriptions.txt"));
		getMembers(new File("resources/Members.txt"));
	}
	
	public void getUser(File file) throws FileNotFoundException {
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
			this.users[i] = user;
		}
	}
	
	public User getUserById(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public Group getGroupById(int id) {
		for (Group group : groups) {
			if (group.getId() == id) {
				return group;
			}
		}
		return null;
	}
	
	public void getSubs(File file) throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		int n = sc.nextInt();
		Subscription[] subs = new Subscription[n];
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String[] str = sc.nextLine().split(" ");
			User user1 = getUserById(Integer.parseInt(str[0]));
			User user2 = getUserById(Integer.parseInt(str[1]));
			Subscription sub = new Subscription(user1, user2);
			this.subs[i] = sub;
		}
	}

	public void getGroup(File file) throws FileNotFoundException {
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
			this.groups[i] = group;
		}
	}
	
	public void getMembers(File file) throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		int n = sc.nextInt();
		Member[] members = new Member[n];
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String[] str = sc.nextLine().split(" ");
			User user = getUserById(Integer.parseInt(str[0]));
			Group group = getGroupById(Integer.parseInt(str[1]));
			User admin = getUserById(Integer.parseInt(str[2]));
			Member member = new Member(user, group, admin);
			this.members[i] = member;
		}
	}
		
}