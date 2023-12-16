import models.*;
import services.*;
import storage.*;

public class Main {
	
	public static void main(String [] args) {
		IStorage db1 = new MockStorage();
		IStorage db2 = new FileStorage();
		try {
			db1.init();
			db2.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Service s = new Service(db2);
		User [] users = s.getUsers();
		Subscription [] subs = s.getSubs();
		Group [] groups = s.getGroups();
		Member [] members = s.getMembers();
		
		boolean [] answer = {s.isFriends(users[1], users[3]),
							s.isFriends(users[1], users[5]),
							s.isFriends(users[1], users[7]),
							s.isFriends(users[7], users[4])};
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		for (Group group : groups) {
			if (s.isFriendly(group, 1)) {
				count1++;
			}
			if (s.isFriendly(group, 2)) {
				count2++;
			}
			if (s.isFriendly(group, 3)) {
				count3++;
			}
		}
		System.out.println(count1 + " " + count2 + " " + count3);
		/*
		User [] answer1 = s.getUsersFromGroup(groups[2]);;
		boolean answer2 = s.isFriendly(groups[2], 3);
		
		for (int i = 0; i < answer1.length; i++) {
			System.out.println(answer1[i]);
		}
		System.out.println(answer2);
		*/
	}
	
}