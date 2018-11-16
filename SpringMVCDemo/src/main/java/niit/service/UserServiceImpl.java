package niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import niit.dao.UserDao;

import niit.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userdao;

	
    @Transactional
	public void addUser(User User) {
		userdao.addUser(User);
		
	}
    @Transactional
	public void deleteUser(Integer userid) {
	 
    	userdao.deleteUser(userid);
		
	}

    @Transactional
	public User getUser(int userid) {
	
	return	userdao.getUser(userid);
	}
   
    @Transactional
	public User updateUser(User user) {
	
    	return userdao.updateUser(user);
    	
	}
 
    @Transactional
	public List<User> getAllUsers() {
		return userdao.getAllUsers();
	}

}
