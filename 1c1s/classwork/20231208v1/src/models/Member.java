package models;

public class Member {
	
	private User user;
	private Group group;
	private User admin;
	
	
	public Member(User user, Group group, User admin) {
		this.user = user;
		this.group = group;
		this.admin = admin;
	}

	public User getUser() {
		return user;
	}
	
	public Group getGroup() {
		return group;
	}
	
	public User getAdmin() {
		return admin;
	}
	
	public String toString() {
		return user.toString() + " " + group.toString();
	}
	
}