package services;

import models.*;
import storage.*;

public class Service {
	
	private IStorage db;
	
	public Service(IStorage db) {
		this.db = db;
	}
	
	public User [] getUsers() {
		return db.getUsers();
	}
	
	public Subscription [] getSubs() {
		return db.getSubs();
	}
	
	public Group [] getGroups() {
		return db.getGroups();
	}
	
	public Member [] getMembers() {
		return db.getMembers();
	}
	
	
	// хрень какая-то вместо нее должно быть то что в AbstractStorage щас
	/*
	public Group [] getGroupParametr1() {
		Group [] allGroups = db.getGroups();
		
		for (Group group : allGroups) {
			String adminCity = group.getAdmin().getCity();
			
		}
	}
	*/
	
	public int getCountMembersFromGroup(Group group) {
		int count = 0;
		Member [] members = this.getMembers();
		for (int i = 0; i < members.length; i++) {
			if (group.getId() == members[i].getGroup().getId()) {
				count += 1;
			}
		}
		return count;
	} 
	
	public User [] getUsersFromGroup(Group group) {
		User [] ans = new User[getCountMembersFromGroup(group)];
		Member [] members = this.getMembers();
		int count = 0;
		for (int i = 0; i < members.length; i++) {
			if (group.getId() == members[i].getGroup().getId()) {
				ans[count] = members[i].getUser();
				count++;
			}
		}
		return ans;
	}
	
	public boolean isMember(User user, Group group) {
		Member [] members = this.getMembers();
		for (int i = 0; i < members.length; i++) {
			if (members[i].getUser().getId() == user.getId() && members[i].getGroup().getId() == group.getId()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isFriends(User user1, User user2) {
		Subscription [] subs = this.getSubs();
		boolean flag1 = false;
		boolean flag2 = false;
		for (int i = 0; i < subs.length; i++) {
			if (subs[i].getUser1().getId() == user1.getId() && subs[i].getUser2().getId() == user2.getId()) {
				flag1 = true;

			} else if (subs[i].getUser2().getId() == user1.getId() && subs[i].getUser1().getId() == user2.getId()) {
				flag2 = true;
			}
		}
		return flag1 && flag2;
	}
		
	public boolean isFriendly(Group group, int n) {
		User [] users = this.getUsersFromGroup(group);
		if (n == 1) {
			for (int i = 0; i < users.length; i++) {
				for (int j = i + 1; j < users.length; j++) {
					if (!(this.isFriends(users[i], users[j]))) {
						return false;
					}
				}
				
			}
			return true;
		} else if (n == 2) {
			boolean ans = true;
			for (int i = 0; i < users.length; i++) {
				boolean flag = false;
				for (int j = 0; j < users.length; j++) {
					if (this.isFriends(users[i], users[j])) {
						flag = true;	
					}
				}
				if (flag == false) {
					ans = false;
				}
			}
			return ans;
		} else if (n == 3) {
			return false;
		} else {
			return false;
		}
	}
	
}