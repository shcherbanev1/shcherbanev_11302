package ru.kpfu.itis.group302.networkproj.services;

import ru.kpfu.itis.group302.networkproj.models.*;
import ru.kpfu.itis.group302.networkproj.storage.*;

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
	
	// Задание 30
	public String getMaxSubsFromUserCity() {
		
		Subscription [] subs = this.getSubs();
		User [] users = this.getUsers();
		int max = -1;
		String ans = "error";
		for (User user : users) {
			int id = user.getId();
			String city = user.getCity();
			int countSubs = 0;
			for (Subscription sub : subs) {
				if (sub.getUser1().getId() == id) {
					if (sub.getUser1().getCity().equals(city)){
						countSubs++;
					}
				}
			}
			if (countSubs > max) {
				max = countSubs;
				ans = user.getName();
			}
		}
		return ans;
	}
	
	// Задание 31
	public String groupAllMembersNotFromAdminCity() {
		
		Member [] members = this.getMembers();
		Group [] groups = this.getGroups();
		String ans = "not exist";
		boolean found = false;
		for (int i = 0; i < groups.length && !found; i++) {
			boolean flag = true;
			int groupId = groups[i].getId();
			String adminCity = groups[i].getAdmin().getCity();
			for (int j = 0; j < members.length && flag; j++) {
				if (members[j].getGroup().getId() == groupId) {
					if (members[j].getUser().getCity().equals(adminCity)) {
						flag = false;
					}
				}
			}
			if (flag) {
				ans = groups[i].getName();
				found = true;
			}
		}
		return ans;
	}
	
	// Задание 33
	public Group [] getGroupTask1() {

		Group [] groups = this.getGroups();
		Group [] ans = new Group[groups.length];
		Member [] members = this.getMembers();
		int index = 0;
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
				ans[index] = group;
				index++;
			}
			
		}
		return ans;
	}
	
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
	
	public static boolean contains(int[] array, int num) {
		for (int elem : array) {
			if (elem == num) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean contains(User[] array, int num) {
		for (User user : array) {
			try {
				if (user.getId() == num) {
					return true;
				}
			} catch (Exception e) {
				return false;
			}
		}
		return false;
	}
	
	// Задания 34, 35, 36
	public boolean isFriendly(Group group, int n) {
		User [] groupMembers = this.getUsersFromGroup(group);
		if (n == 1) {
			for (int i = 0; i < groupMembers.length; i++) {
				for (int j = i + 1; j < groupMembers.length; j++) {
					if (!(this.isFriends(groupMembers[i], groupMembers[j]))) {
						return false;
					}
				}
				
			}
			return true;
		} else if (n == 2) {
			boolean ans = true;
			for (int i = 0; i < groupMembers.length; i++) {
				boolean flag = false;
				for (int j = 0; j < groupMembers.length; j++) {
					if (this.isFriends(groupMembers[i], groupMembers[j])) {
						flag = true;	
					}
				}
				if (flag == false) {
					ans = false;
				}
			}
			return ans;
		} else if (n == 3) {
			int [] colored = new int[groupMembers.length];
			User [] q = new User[groupMembers.length];
			int nextRead = 0;
			int nextNeighbour = 0;
			q[nextNeighbour] = groupMembers[0];
			nextNeighbour++;
			while (nextRead != nextNeighbour) {
				colored[nextRead] = q[nextRead].getId();
				for (User member : groupMembers) {
					if (isFriends(q[nextRead], member)) {
						if ((!contains(colored, member.getId())) && (!contains(q, member.getId()))) {
							q[nextNeighbour] = member;
							nextNeighbour++;
						}
					}
				}
				nextRead++;
			}
			return nextNeighbour == groupMembers.length;
		} else {
			return false;
		}
	}
	
}