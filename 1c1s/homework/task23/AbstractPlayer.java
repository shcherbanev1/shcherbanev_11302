public abstract class AbstractPlayer {
	
	protected String name;
	protected int hp;

	public String getName() {
		return name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public AbstractPlayer(int maxHP) {
		this.hp = maxHP;
	}
	
	public AbstractPlayer(String name, int maxHP) {
		this(maxHP);
		this.name = name;
	}

	public String toString() {
		return name + "(" + hp + ")";
	}

	public boolean alive() {
		return hp > 0;
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