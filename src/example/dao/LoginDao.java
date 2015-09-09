package example.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import example.entity.User;

public class LoginDao extends HibernateDaoSupport implements LoginDAOI{

	public String checkUser(String username,String password){
		
		
		try {
			
			HibernateTemplate hTemplate = getHibernateTemplate();
			
			Object[] params  = {username,password};
			
			String hql_query="from User u where u.username= ? and u.password= ?";
			
			Iterator itr=  hTemplate.find(hql_query,params).iterator();
			
			if(itr.hasNext()){
				User usr=(User) itr.next();
				return usr.getPrivilege();
				}
			else
					return "invalid";
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "invalid";
	
	}

	@Override
	public void blockUser(User user) {
		HibernateTemplate hTemplate = getHibernateTemplate();
		hTemplate.delete(user);
		
	}
	
	
}
