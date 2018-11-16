package niit.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import niit.model.Address;

public interface AddressDao {
	public void addAddress(Address address);

	public List<Address> getAllAddress();

	public void deleteAddress(Integer addressid);

	public Address getAddress(int adressid);

	public Address updateAddress(Address address);
}
