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
	
}