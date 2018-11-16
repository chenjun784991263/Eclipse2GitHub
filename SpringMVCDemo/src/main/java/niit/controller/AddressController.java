package niit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import niit.model.Address;
import niit.model.User;
import niit.service.AddressService;

@Controller
public class AddressController {
	@Autowired
	private AddressService addressService;

	@RequestMapping(value = "/addAddress",method=RequestMethod.GET)
	public ModelAndView listAddress(ModelAndView model) throws IOException {
		List<Address> listaddress =addressService.getAllAddress();
		model.addObject("addresslist",listaddress);
		model.setViewName("addresshome");
		return model;
	}

	@RequestMapping(value = "/newAddress", method = RequestMethod.GET)
	public ModelAndView newAddress(ModelAndView model) {
	    Address address= new Address();
		model.addObject("address", address);
		model.setViewName("AddressForm");
		return model;
	}

	@RequestMapping(value = "/saveAddress", method = RequestMethod.POST)
	public ModelAndView saveAddress(@ModelAttribute Address address) {
		if (address.getId() == 0) { 
			addressService.addAddress(address);
		} else {
			addressService.updateAddress(address);
		}
		ModelAndView model=new ModelAndView();
		List<Address> listaddress =addressService.getAllAddress();
		model.addObject("addresslist",listaddress);
		model.setViewName("addresshome");
		return model;
	}

	@RequestMapping(value = "/deleteAddress", method = RequestMethod.GET )
	public ModelAndView deleteAddress(HttpServletRequest request) {
		int addressid = Integer.parseInt(request.getParameter("id"));
	    addressService.deleteAddress(addressid);
	    ModelAndView model=new ModelAndView();
		List<Address> listaddress =addressService.getAllAddress();
		model.addObject("addresslist",listaddress);
		model.setViewName("addresshome");
		return model;
	}

	@RequestMapping(value = "/editAddress", method = RequestMethod.GET )
	public ModelAndView editContact(HttpServletRequest request) {
		int addressid = Integer.parseInt(request.getParameter("id"));
	    Address address=addressService.getAddress(addressid);
		ModelAndView model = new ModelAndView("AddressForm");
		model.addObject("address",address);

		return model;
	}
	
	@RequestMapping(value = "/AddUser", method = RequestMethod.GET)
	public ModelAndView newUser(ModelAndView model) {
	    User user= new User();
	    List<Address> listaddress =addressService.getAllAddress();
	    model.addObject("addresslist",listaddress);
	    model.addObject("user", user);
		model.setViewName("UserForm");
		return model;
	}
	
	
	

}