public class Task28 {
	
	public static void main(String [] args) {
	
		String [][] strings = {{"abc", "cda", "api", "vec"}, 
								{"altwer", "dcsape", "object", "aerkom"}, 
								{"scp", "adj", "psad", "qoade"}};
		
		boolean flag = true;
		
		for (int i = 0; i < strings[0].length && flag; i++) {
			boolean flagVowel = false;
			for (int j  = 0; j < strings.length && !flagVowel; j++) {
				char ch = strings[j][i].charAt(0);
				if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'y') {
					flagVowel = true;
				}
			}
			flag = flagVowel;
		}
		
		System.out.println(flag);
	}
	
}