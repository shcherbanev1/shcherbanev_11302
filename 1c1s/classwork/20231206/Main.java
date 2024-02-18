public class Main {
	
	public static void main(String [] args) {
		try {
			RationalFraction fraction = new RationalFraction(5, 0);
		} catch (ZeroDenomException e) {
			System.out.println("Знаменатель не может быть равен 0");
		}
	}
	
}