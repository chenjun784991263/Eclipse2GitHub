package niit.service;

import java.util.List;

import niit.model.Address;;

public interface AddressService {
	public void addAddress(Address address);

	public List<Address> getAllAddress();

	public void deleteAddress(Integer addressid);

	public Address getAddress(int adressid);

	public Address updateAddress(Address address);
}
