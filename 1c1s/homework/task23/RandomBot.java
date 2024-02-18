import java.util.Random;

public class RandomBot extends Bot {

	public RandomBot(int maxHP) {
		super(maxHP);
		this.name = "RandomBot";
	}

	public boolean kick(AbstractPlayer ap) {
		Random rand = new Random();
		int force = rand.nextInt(10) + 1;
		this.kick(ap, force);
		return true;
	}
}