package niit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import niit.model.Address;
import niit.model.User;
import niit.service.AddressService;
import niit.service.UserService;

@Controller

public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AddressService addressService;

	@RequestMapping(value = "/")
	public ModelAndView listUser(ModelAndView model) throws IOException {
		List<User> listuser = userService.getAllUsers();
		List<Address> listaddress =addressService.getAllAddress();
        model.addObject("addresslist",listaddress);
		model.addObject("listuser", listuser);
		model.setViewName("userhome");
		return model;
	}
	
	@RequestMapping(value="/checkUsername", method = RequestMethod.GET)
    public @ResponseBody ModelAndView  submittedFromData(HttpServletRequest request) {	
	
		ModelAndView model=new ModelAndView();
			model.addObject("name", "username is not available");
		
		return model;
	}	

	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public ModelAndView newUser(ModelAndView model) {
	    User user= new User();
	    List<Address> listaddress =addressService.getAllAddress();
	    model.addObject("addresslist",listaddress);
	    model.addObject("user", user);
		model.setViewName("UserForm");
		return model;
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute("user") User user) {
		if (user.getId() == 0) { 
			userService.addUser(user);
		} else {
			userService.updateUser(user);
		}
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public ModelAndView deleteUser(HttpServletRequest request) {
		int userid = Integer.parseInt(request.getParameter("id"));
		userService.deleteUser(userid);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int userid = Integer.parseInt(request.getParameter("id"));
		User user=userService.getUser(userid);
		ModelAndView model=new ModelAndView("UserEditForm");
		List<Address> listaddress =addressService.getAllAddress();
		model.addObject("user",user);
		model.addObject("addresslist",listaddress);
		
		/*Map<String, Object> map=new HashMap<>();
		map.put("user", user);
		map.put("addresslist", listaddress);*/
		
		
		return model;
	}
	
	
	
	
	
	
	
	
}
