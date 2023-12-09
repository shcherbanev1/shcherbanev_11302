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
		Service s = new Service(db1);
		User [] a = s.getUsers();
		Subscription [] b = s.getSubs();
		Group [] c = s.getGroups();
		Member [] d = s.getMembers();
		
		boolean answer1 = s.isFriends(a[0], a[2]);
		User [] answer3 = s.getUsersFromGroup(c[2]);
		//boolean answer4 = s.isFriendly(c[1], 1);
		boolean answer5 = s.isFriendly(c[2], 2);
		//System.out.println(answer1);
		for (int i = 0; i < answer3.length; i++) {
			System.out.println(answer3[i]);
		}
		//System.out.println(answer4);
		System.out.println(answer5);
		
		
		/*
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
		
		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i]);
		}
		
		for (int i = 0; i < d.length; i++) {
			System.out.println(d[i]);
		}
		*/
	}
	
}