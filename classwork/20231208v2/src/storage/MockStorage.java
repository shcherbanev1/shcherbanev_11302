package storage;

import models.*;


public class MockStorage extends AbstractStorage {
	
	public MockStorage() {
		
	}
	
	public void init() {
		initUsers();
		initGroups();
		initSubs();
		initMembers();
	}
	
	public void initUsers() {
		users = new User[4];
		users[0] = new User(1, "vasya", "new-york");
		users[1] = new User(2, "eva", "london");
		users[2] = new User(3, "alise", "san-francisco");
		users[3] = new User(4, "bob", "moscow");
	}
	
	public void initSubs() {
		subs = new Subscription[6];
		subs[0] = new Subscription(users[0], users[2]);
		subs[1] = new Subscription(users[1], users[2]);
		subs[2] = new Subscription(users[2], users[1]);
		subs[3] = new Subscription(users[3], users[0]);
		subs[4] = new Subscription(users[2], users[1]);
		subs[5] = new Subscription(users[1], users[0]);
	}

	public void initGroups() {
		groups = new Group[4];
		groups[0] = new Group(1, "ctf", "kazan", users[0]);
		groups[1] = new Group(2, "inno-lyceum", "innopolis", users[3]);
		groups[2] = new Group(3, "hse", "moscow", users[1]);
		groups[3] = new Group(4, "MIT", "Cambridge", users[1]);
	}
	
	public void initMembers() {
		members = new Member[6];
		members[0] = new Member(users[0], groups[1]);
		members[1] = new Member(users[0], groups[3]);
		members[2] = new Member(users[1], groups[2]);
		members[3] = new Member(users[2], groups[0]);
		members[4] = new Member(users[1], groups[1]);
		members[5] = new Member(users[3], groups[0]);
	}
	
}