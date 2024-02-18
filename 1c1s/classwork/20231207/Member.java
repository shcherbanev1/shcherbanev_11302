public class Member {
	
	private int user_id;
	private int group_id;
	
	public Member(int user_id, int group_id) {
		this.user_id = user_id;
		this.group_id = group_id;
	}

	public int getUserId() {
		return user_id;
	}
	
	public int getGroupId() {
		return group_id;
	}
	
	public String toString() {
		return user_id + " " + group_id;
	}
	
}