package com.sgm.spring.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sgm.spring.dao.StudentGroupDao;
import com.sgm.spring.model.StudentGroup;

@Repository
public class StudentGroupDaoImpl implements StudentGroupDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addGroup(StudentGroup studentGroup) {
		getCurrentSession().save(studentGroup);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentGroup> getGroups(String facultyTitle, Long courseID, String subjectTitle) {
		String sql = "select g from StudentGroup g " + "inner join g.faculty as f " + "inner join g.subject as s "
				+ "where f.title = :faculty and " + "s.title = :subject and " + "g.course = :course";
		Query query = getCurrentSession().createQuery(sql).setParameter("faculty", facultyTitle)
				.setParameter("subject", subjectTitle).setParameter("course", courseID);
		List<StudentGroup> studentGroup = query.list();
		return studentGroup;
	}

	@Override
	public StudentGroup getGroup(Long groupID) {
		StudentGroup group = (StudentGroup) getCurrentSession().get(StudentGroup.class, groupID);
		return group;
	}

	@SuppressWarnings("unchecked")
	@Override
	public StudentGroup getGroup(String groupTitle) {
		String sql = "from StudentGroup g where g.title = :title";
		Query query = getCurrentSession().createQuery(sql).setParameter("title", groupTitle);
		List<StudentGroup> groups = query.list();
		return groups.get(0);
	}

}
