public class NoobiePlayer extends AbstractPlayer {
	
	public NoobiePlayer(String name, int age) {
		super(name, age);
	}
	
	public void sayMyRating() {
		System.out.println("I am noobie I don't have rating");
	}
	
	public String toString() {
		String str1 = super.toString();
		String str2 = " I am just a begginer player";
		return str1 + str2;
	}
	
}