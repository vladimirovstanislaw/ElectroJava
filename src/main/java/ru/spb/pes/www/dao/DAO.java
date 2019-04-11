package ru.spb.pes.www.dao;

import ru.spb.pes.www.entity.User;

public interface DAO<T> {
	void addUser(User user) throws Exception;

	User getUser(int id);

	User patchUser(User user) throws Exception;
}
