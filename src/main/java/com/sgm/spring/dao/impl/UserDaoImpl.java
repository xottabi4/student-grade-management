package com.sgm.spring.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sgm.spring.dao.UserDao;
import com.sgm.spring.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addUser(User user) {
		getCurrentSession().save(user);
	}

	@Override
	public User getUser(Long id) {
		User user = (User) getCurrentSession().get(User.class, id);
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUser(String username) {
		String sql = "from User u where u.username = :username";
		Query query = getCurrentSession().createQuery(sql).setParameter("username", username);
		List<User> users = query.list();
		return users.get(0);
	}

	@Override
	public void updateUser(User user) {
		User userToUpdate = getUser(user.getId());
		userToUpdate.setName(user.getName());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setSurname(user.getSurname());
		userToUpdate.setUsername(user.getUsername());
		getCurrentSession().update(userToUpdate);

	}

	@Override
	public void deleteUser(Long id) {
		User user = getUser(id);
		getCurrentSession().delete(user);

	}

}
