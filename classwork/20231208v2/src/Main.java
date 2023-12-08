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
		User [] a = s.getUsers();
		Subscription [] b = s.getSubs();
		Group [] c = s.getGroups();
		Member [] d = s.getMembers();
		
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
	
	}
	
}