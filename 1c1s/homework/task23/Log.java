public class Log {
	
	public static void out(Object x) {
		System.out.println(x);
	}

	public static void logResult(boolean result, AbstractPlayer p) {
		if (result) {
			out("Success, " + p.getName() + "'s hp is " + p.getHp() + ".");
		} else {
			out("Miss");
		}
	}
	
}