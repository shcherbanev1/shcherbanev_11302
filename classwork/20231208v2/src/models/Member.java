package models;

public class Member {
	
	private User user;
	private Group group;
	
	
	public Member(User user, Group group) {
		this.user = user;
		this.group = group;
	}

	public User getUser() {
		return user;
	}
	
	public Group getGroup() {
		return group;
	}
	
	public String toString() {
		return user.toString() + " " + group.toString();
	}
	
}