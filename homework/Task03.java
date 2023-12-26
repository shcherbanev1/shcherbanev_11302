public class Task03 {
	
	public static void main(String [] args) {

		final double EPS = 1e-6;
		double s = 0;
		double fact = 1;
		double x = Math.PI / 3;
		double deg = x;
		int sign = 1;
		double a = EPS + 1;
		int k = 1;
		while (Math.abs(a) > EPS) {
			a = sign * (deg / fact);
			s += a;
			sign = (-1) * sign;
			deg = deg * x * x;
			fact *= (k + 1) * (k + 2);
			k += 2;
			
		}
		System.out.println("answer " + s);
		System.out.println(Math.sin(x));
		System.out.println("dif " + Math.abs(Math.sin(x) - s));
		
	}	
}