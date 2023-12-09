package storage;

import models.*;
import java.io.FileNotFoundException;

public abstract class AbstractStorage implements IStorage {
	
	protected User [] users;
	protected Subscription [] subs;
	protected Group [] groups;
	protected Member [] members;
	
	public User getUserById(int id) {
		for (User user : users) {
			if (id == user.getId()) {
				return user;
			}
		}
		return null;
	}
	
	public Group getGroupById(int id) {
		for (Group group : groups) {
			if (id == group.getId()) {
				return group;
			}
 		}
		return null;
	}
	
	abstract public void init();
	
	public User [] getUsers() {
		return users;
	}
	public Group [] getGroups() {
		return groups;
	}
	public Subscription [] getSubs() {
		return subs;
	}
	public Member [] getMembers() {
		return members;
	}
	
	public int getCountGroupsMembers(Group group) {
		int count = 0;
		for (Member member : members) {
			if (group.getId() == member.getGroup().getId()) {
				count++;
			}
		}
		return count;
	}
	
	// работа не проверена его вообще надо в сервисы
	// Storage - только к тому что в его атрибутах
	public Group [] getGroupTask1() {
		Group [] ans = new Group[groups.length];
		for (Group group : groups) {
			int count = 0;
			int countGroupMembers = 0;
			for (Member member : members) {
				if (group.getId() == member.getGroup().getId()) {
					countGroupMembers++;
					if (!(group.getAdmin().getCity().equals(member.getUser().getCity()))) {
						count++;
					}
				}
			}
			if (count > (double)countGroupMembers / 2) {
				for(int i = 0; i < ans.length; i++) {
					if(ans[i] == null) {
						ans[i] = group;
						break;
					}
				}
			}
			
		}
		return ans;
	}
		
}