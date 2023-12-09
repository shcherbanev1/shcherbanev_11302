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
		users = new User[10];
		users[0] = new User(1, "vasya", "new-york");
		users[1] = new User(2, "eva", "london");
		users[2] = new User(3, "alise", "san-francisco");
		users[3] = new User(4, "bob", "moscow");
		users[4] = new User(5, "ivan", "moscow");
		users[5] = new User(6, "chess", "moscow");
		users[6] = new User(7, "andrew", "moscow");
		users[7] = new User(8, "cris", "moscow");
		users[8] = new User(9, "bill", "moscow");
		users[9] = new User(10, "jack", "moscow");
	}
	
	public void initSubs() {
		subs = new Subscription[17];
		subs[0] = new Subscription(users[5], users[1]);
		subs[1] = new Subscription(users[1], users[5]);
		subs[2] = new Subscription(users[2], users[1]);
		subs[3] = new Subscription(users[1], users[2]);
		subs[4] = new Subscription(users[3], users[0]);
		subs[5] = new Subscription(users[3], users[1]);
		subs[6] = new Subscription(users[1], users[3]);
		subs[7] = new Subscription(users[0], users[3]);
		subs[8] = new Subscription(users[6], users[2]);
		subs[9] = new Subscription(users[7], users[4]);
		subs[10] = new Subscription(users[4], users[7]);
		subs[11] = new Subscription(users[3], users[8]);
		subs[12] = new Subscription(users[8], users[3]);
		subs[13] = new Subscription(users[5], users[0]);
		subs[14] = new Subscription(users[1], users[7]);
		subs[15] = new Subscription(users[5], users[1]);
		subs[16] = new Subscription(users[9], users[0]);
	}

	public void initGroups() {
		groups = new Group[4];
		groups[0] = new Group(1, "ctf", "kazan", users[0]);
		groups[1] = new Group(2, "inno-lyceum", "innopolis", users[3]);
		groups[2] = new Group(3, "hse", "moscow", users[1]);
		groups[3] = new Group(4, "MIT", "Cambridge", users[1]);
	}
	
	public void initMembers() {
		members = new Member[9];
		members[0] = new Member(users[0], groups[1]);
		members[1] = new Member(users[0], groups[3]);
		members[2] = new Member(users[1], groups[2]);
		members[3] = new Member(users[2], groups[0]);
		members[4] = new Member(users[1], groups[1]);
		members[5] = new Member(users[3], groups[0]);
		members[6] = new Member(users[5], groups[2]);
		members[7] = new Member(users[7], groups[2]);
		members[8] = new Member(users[4], groups[2]);
	}
	
}