package com.sgm.spring.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sgm.spring.dao.UserTypeDao;
import com.sgm.spring.model.User;
import com.sgm.spring.model.UserType;

@Repository
public class UserTypeDaoImpl implements UserTypeDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public UserType getType(Long typeID) {
		UserType type = (UserType) getCurrentSession().get(UserType.class, typeID);
		return type;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserType> getTypes(User user) {
		String sql = "select t from UserType as t where t.user = :user";
		Query query = getCurrentSession().createQuery(sql).setParameter("user", user);
		List<UserType> types = query.list();
		return types;
	}

	@Override
	public boolean isStudent(User user) {
		List<UserType> types = getTypes(user);
		System.out.println(types.size());
		for (UserType type : types) {
			System.out.println(type.getName());
			if (type.getName().equals("student")) {
				return true;
			}
		}
		return false;
	}

}
