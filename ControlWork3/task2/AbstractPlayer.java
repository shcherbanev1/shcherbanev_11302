public abstract class AbstractPlayer {
	
	protected String name;
	protected int age;
	
	public AbstractPlayer(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public abstract void sayMyRating();
	
	public String toString() {
		return "I am sportsman" + name + ". I am " + age + "y.o.";
	}
	
}