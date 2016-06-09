package com.sgm.spring.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sgm.spring.dao.StudentGroupDao;
import com.sgm.spring.model.StudentGroup;
import com.sgm.spring.model.User;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentGroup> getGroups(String facultyTitle, Long courseID, String subjectTitle, User professor) {
		String sql = "select g from StudentGroup g " + "inner join g.faculty as f " + "inner join g.subject as s "
				+ "where f.title = :faculty and " + "s.title = :subject and " + "g.course = :course and "
				+ "g.user = :professor";
		Query query = getCurrentSession().createQuery(sql).setParameter("faculty", facultyTitle)
				.setParameter("subject", subjectTitle).setParameter("course", courseID)
				.setParameter("professor", professor);
		List<StudentGroup> studentGroup = query.list();
		return studentGroup;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentGroup> getAllGroups(Long facultyID) {
		String sql = "select g from StudentGroup g " + "inner join g.faculty as f " + "where f.id = :faculty";
		Query query = getCurrentSession().createQuery(sql).setParameter("faculty", facultyID);
		List<StudentGroup> groups = query.list();
		return groups;

	}

	@Override
	public void deleteGroup(Long id) {
		StudentGroup group = getGroup(id);
		getCurrentSession().delete(group);
	}

	@Override
	public void updateGroup(StudentGroup group) {
		StudentGroup groupToUpdate = getGroup(group.getId());
		groupToUpdate.setCourse(group.getCourse());
		groupToUpdate.setFaculty(group.getFaculty());
		groupToUpdate.setGroups(group.getGroups());
		groupToUpdate.setSubject(group.getSubject());
		groupToUpdate.setTitle(group.getTitle());
		groupToUpdate.setUser(group.getUser());
		getCurrentSession().update(groupToUpdate);
	}

}
