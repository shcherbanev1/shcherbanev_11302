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
	

		
}