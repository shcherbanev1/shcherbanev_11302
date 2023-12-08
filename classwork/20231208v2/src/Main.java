import models.*;
import services.*;
import storage.*;

public class Main {
	
	public static void main(String [] args) {
		FileStorage db1 = new FileStorage();
		try {
			db1.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Service s = new Service(db1);
		User [] a = s.getUser();
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
}