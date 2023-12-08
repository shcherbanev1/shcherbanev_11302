package storage;

import models.*;
import java.io.FileNotFoundException;

public interface IStorage {
	
	void init() throws FileNotFoundException;
	User [] getUsers();
	Group [] getGroups();
	Subscription [] getSubs();
	Member [] getMembers();
	User getUserById(int id);
	Group getGroupById(int id); 
	
}