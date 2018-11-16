package niit.service;

import java.util.List;

import niit.model.User;

public interface UserService {
	
	public void addUser(User User);

	public List<User> getAllUsers();

	public void deleteUser(Integer userid);

	public User getUser(int userid);

	public User updateUser(User user);
}
