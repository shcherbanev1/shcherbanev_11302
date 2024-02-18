// вариант 2

import java.util.Scanner;

public class Task1 {
	
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		String [] strings = sc.nextLine().split(" ");
		//String [] strings = {"aSSS13", "as35681qd", "asq22165460d", "as15qd"};
		
		int countAns = 0;
		
		for (int i = 0; i < strings.length && countAns < 3; i++) {
			int countNumbers = 0;
			int countLetters = 0;
			for (int j = 0; j < strings[i].length(); j++) {
				char ch = strings[i].charAt(j);
				if (ch >= '0' && ch <= '9') {
					countNumbers++;
				} else if ((ch >= 'a' && ch <= 'z')) {
					countLetters++;
				}
			}
			if (countNumbers > countLetters) {
				countAns += 1;
			}
		}
		
		System.out.println(countAns >= 3);
		
	}
	
}