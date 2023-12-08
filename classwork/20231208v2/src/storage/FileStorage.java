package storage;

import models.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class FileStorage extends AbstractStorage {
	
	public FileStorage() {
		
	}
	
	public void init() throws FileNotFoundException {
		initUsers(new File("C:/Users/shche/Documents/infa/shcherbanev_11302/classwork/20231208v2/resources/Users.txt"));
		initGroups(new File("C:/Users/shche/Documents/infa/shcherbanev_11302/classwork/20231208v2/resources/Groups.txt"));
		initSubs(new File("C:/Users/shche/Documents/infa/shcherbanev_11302/classwork/20231208v2/resources/Subscriptions.txt"));
		initMembers(new File("C:/Users/shche/Documents/infa/shcherbanev_11302/classwork/20231208v2/resources/Members.txt"));
	}
	
	public void initUsers(File file) throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		int n = sc.nextInt();
		this.users = new User[n];
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
	
	public void initSubs(File file) throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		int n = sc.nextInt();
		this.subs = new Subscription[n];
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String[] str = sc.nextLine().split(" ");
			User user1 = getUserById(Integer.parseInt(str[0]));
			User user2 = getUserById(Integer.parseInt(str[1]));
			Subscription sub = new Subscription(user1, user2);
			this.subs[i] = sub;
		}
	}

	public void initGroups(File file) throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		int n = sc.nextInt();
		this.groups = new Group[n];
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String[] str = sc.nextLine().split(" ");
			int id = Integer.parseInt(str[0]);
			String name = str[1];
			String city = str[2];
			User admin = getUserById(Integer.parseInt(str[3]));
			Group group = new Group(id, name, city, admin);
			this.groups[i] = group;
		}
	}
	
	public void initMembers(File file) throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		int n = sc.nextInt();
		this.members = new Member[n];
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String[] str = sc.nextLine().split(" ");
			User user = getUserById(Integer.parseInt(str[0]));
			Group group = getGroupById(Integer.parseInt(str[1]));
			Member member = new Member(user, group);
			this.members[i] = member;
		}
	}
		
}