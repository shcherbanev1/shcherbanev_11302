public class Team {
	
	private String name;
	private AbstractPlayer [] players;
	
	public Team(String name, AbstractPlayer [] players) {
		this.name = name;
		this.players = players;
	}
	
	public String getName() {
		return name;
	}
	
	public AbstractPlayer [] getPlayers() {
		return players;
	}
	
	public int getTeamRating() {
		int ratingTeam = 0;
		for (AbstractPlayer player : players) {
			if (player instanceof ProPlayer) {
				ratingTeam += ((ProPlayer)player).getRating();
			}
		}
		return ratingTeam;
	}
	
}