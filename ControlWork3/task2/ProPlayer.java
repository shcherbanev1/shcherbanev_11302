public class ProPlayer extends AbstractPlayer {
	
	private int rating;
	
	public ProPlayer(String name, int age, int rating) {
		super(name, age);
		this.rating = rating;
	}
	
	public void sayMyRating() {
		System.out.println("my rating is " + rating);
	}
	
	public int getRating() {
		return rating;
	}
	
	
	
}