package niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import niit.dao.AddressDao;
import niit.model.Address;

@Service
@Transactional
public class AddressServiceImpl implements AddressService{

	@Autowired
	AddressDao addressdao;
	
	@Transactional
	public void addAddress(Address address) {
	
		addressdao.addAddress(address);
	}
	@Transactional
	public List<Address> getAllAddress() {
	
		return addressdao.getAllAddress();
	
	}
	@Transactional
	public void deleteAddress(Integer addressid) {
		
		addressdao.deleteAddress(addressid);
	}
	@Transactional
	public Address getAddress(int adressid) {
		
		return addressdao.getAddress(adressid);
		
	}
	@Transactional
	public Address updateAddress(Address address) {
		
		return addressdao.updateAddress(address);
		
	}

	
	
	
	
	
}
