package example.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import example.entity.Customer;
import example.entity.User;

public class CustomerDAOImpl extends HibernateDaoSupport implements CustomerDAO {
	
	public CustomerDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addCustomer(Customer customer) {
		System.out.println("in add customer");
		// TODO Auto-generated method stub
		System.out.println(customer.getCust_id()+customer.getPassword());
		try {
			HibernateTemplate hTemplate = getHibernateTemplate();
			
			User user=new User();
			user.setUsername(customer.getUsername());
			user.setPassword(customer.getPassword());
			user.setPrivilege("customer");
			
			hTemplate.save(customer);
			hTemplate.save(user);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}

	

}











