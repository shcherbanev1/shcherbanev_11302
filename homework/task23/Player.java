import java.util.Scanner;

public class Player extends AbstractPlayer {

	public Player(String name, int maxHP) {
		super(name, maxHP);
	}
	
	public boolean kick(AbstractPlayer enemy, int f) {
		double d = (f - 1.0) / 10;
		if (Math.random() > d) {
			enemy.hp -= f;
			return true;
		} else {
			return false;
		}
	}
	
}