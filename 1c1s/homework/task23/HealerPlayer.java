public class HealerPlayer extends Player {
	
	private int healPoints;
	
	public HealerPlayer(String name, int maxHP, int healPoints) {
		super(name, maxHP);
		this.healPoints = healPoints;
	}
	
	public void heal(int p) {
		if (p < healPoints) {
			setHp(getHp() + p);
			healPoints -= p;
		}
	}
	
	public int getHealPoints() {
		return healPoints;
	}
	
}