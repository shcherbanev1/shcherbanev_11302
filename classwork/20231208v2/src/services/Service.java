package services;

import models.*;
import storage.*;

public class Service {
	
	private IStorage db;
	
	public Service(IStorage db) {
		this.db = db;
	}
	
	public User [] getUser() {
		return db.getUsers();
	}
	
}