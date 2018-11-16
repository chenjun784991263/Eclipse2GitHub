package niit.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import niit.model.Address;

@Repository
public class AddressDaoImpl implements AddressDao{
  
	@Autowired
	SessionFactory sessionFactory;
	
	
	
	public void addAddress(Address address) {
	
		sessionFactory.getCurrentSession().saveOrUpdate(address);
	}

	@SuppressWarnings("unchecked")
	public List<Address> getAllAddress() {
	
		return sessionFactory.getCurrentSession().createQuery("from Address").list();
		
		
	}

	public void deleteAddress(Integer addressid) {
	
		Address address=(Address) sessionFactory.getCurrentSession().load(Address.class, addressid);
		
		sessionFactory.getCurrentSession().delete(address);
		
	}

	public Address getAddress(int addressid) {
		return (Address) sessionFactory.getCurrentSession().get(Address.class, addressid);
	}

	public Address updateAddress(Address address) {
		
		sessionFactory.getCurrentSession().update(address);
		return address;
	}

}
