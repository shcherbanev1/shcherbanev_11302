public class Task25 {
	
	public static void main(String [] args) {
		
		int count = 0;
		String str = "e6556dfuOlkzl";
		str = str.toLowerCase();
		
		for (int i = 0; i < str.length() && count < 4; i++) {
			char ch = str.charAt(i);
			if (ch >= 'a' && ch <= 'z') {
				if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'y') {
					count += 1;	
				}
			}
		}
		
		System.out.println(count == 3);
	}
	
}