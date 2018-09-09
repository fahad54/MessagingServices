package fi.yasir.messaging.respositories;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

	private final List<String> userNames = new ArrayList<>();

	public String addUser(String name) throws Exception {
		if (userNames.contains(name)) {
			throw new IllegalArgumentException("user :" + name + " already exist");
		}
		userNames.add(name);
		return name + " added";
	}

	public String remove(String name) throws Exception {
		if (!userNames.contains(name)) {
			throw new IllegalArgumentException("user :" + name + " not exist");
		}
		userNames.remove(name);
		return name + " removed ";
	}

	public List<String> getUsers() {
		return userNames;
	}

}
