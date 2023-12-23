public class Match {
	
	private int time;
	private Team team1;
	private Team team2;
	
	public Match(int time, Team team1, Team team2) {
		this.time = time;
		this.team1 = team1;
		this.team2 = team2;
	} 
	
	public void start() {
		System.out.println("Match started");
		System.out.println("Today " + team1.getName() + " plays vs " + team2.getName());
	}
	
	public void showResultOfMatch() {
		if (team1.getTeamRating() > team2.getTeamRating() + 10) {
			System.out.println("First team wins");
		} else if (team2.getTeamRating() > team1.getTeamRating() + 10) {
			System.out.println("Second team wins");
		} else {
			System.out.println("Friendship wins");
		}
	}
	
}