package ru.spb.pes.www.dao;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import ru.spb.pes.www.entity.User;

@Component
public class UserDAO implements DAO<User> {

	@Resource(name = "userCollection")
	HashMap<Integer, User> userCollection;

	@Override
	public void addUser(User user) {
		if (user != null) {
			User tmp = null;
			for (User userIterable : userCollection.values()) {
				if (userIterable.getName() == user.getName()) {
					tmp = userIterable;
				}
			}
			if (tmp == null) {
				userCollection.put(user.getId(), user);
			}

		}
	}

	@Override
	public User getUser(int id) {
		return userCollection.get(id);
	}

	@Override
	public User patchUser(User user) throws Exception {
		if (user != null) {
			if (userCollection.containsKey(user.getId())) {
				userCollection.put(user.getId(), user);
				return user;

			} else {
				throw new Exception();
			}

		} else {
			throw new Exception();
		}
	}

}
