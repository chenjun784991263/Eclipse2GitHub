package niit.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import niit.model.User;

@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
	private SessionFactory sessionFactory;
	
	public void addUser(User User) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(User);
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
	
		return sessionFactory.getCurrentSession().createQuery("from User").list();
		
		
	}

	public void deleteUser(Integer userid) {
		User user=(User) sessionFactory.getCurrentSession().load(User.class, userid);
		
		
		
		sessionFactory.getCurrentSession().delete(user);
	}

	public User getUser(int userid) {
		
		return (User) sessionFactory.getCurrentSession().get(User.class, userid);
	}

	public User updateUser(User user) {
	
		sessionFactory.getCurrentSession().update(user);
		
		return user;
	}

	
	
	
	
	
	
}
