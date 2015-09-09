package example.action;

import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import example.dao.CustomerDAO;
import example.entity.Customer;

public class CreateCustomerAction extends ActionSupport implements ServletContextAware, ModelDriven{
	private ServletContext sCtx;
	private Customer customer = new Customer();
	
 public CreateCustomerAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setServletContext(ServletContext sCtx) {
		// TODO Auto-generated method stub
		this.sCtx = sCtx;
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return customer;
	}
	
	@Override
	public void validate(){
		if(customer.getFirstname().equals(""))
			addFieldError("firstname","firstname can not be Empty");
		if(customer.getLastname().equals(""))
			addFieldError("lastname","lastname can not be Empty");	
	}
	
	public String execute(){
		System.out.println("in execute");
		String result = ERROR;
		WebApplicationContext waCtx = WebApplicationContextUtils.getWebApplicationContext(sCtx);
		CustomerDAO cDao = (CustomerDAO)waCtx.getBean("customerDAO");

		customer.setPassword(customer.generateRandomPassword());
		
		boolean addSuccess = cDao.addCustomer(customer);
		if (addSuccess)
			result = SUCCESS;
		return result;
		
		
	}


}
