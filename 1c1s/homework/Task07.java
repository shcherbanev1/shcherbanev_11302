public class Task07 {
	
	public static void main(String [] args) {
		
		int s = 0;
		String str = args[0];
		int i = 0;
		char ch;
		
		while (i < str.length() && s != -1) {
			ch = str.charAt(i);
			if (s == 0) {
				if (isCharBetween('A', 'Z', ch) || isCharBetween('a', 'z', ch) || ch == '$' || ch == '_') {
					s = 1;
				} else {
					s = -1;
				}
			} else if (s == 1) {
				if (isCharBetween('A', 'Z', ch) || isCharBetween('a', 'z', ch) || ch == '$' || ch == '_' || isCharBetween('0', '9', ch)) {
					s = 1;
				} else {
					s = -1;
				}
			}
			i++;
		}
		
		System.out.println(s != -1 && s!= 0);
	}
	
	public static boolean isCharBetween(char start, char end, char now) {
		return (start <= now && now <= end);
	}
	
}