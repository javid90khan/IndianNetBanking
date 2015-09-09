package example.action;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import example.dao.AccountDAO;
import example.dao.CustomerDAO;
import example.entity.Account;
import example.entity.Customer;

public class CreateAccountAction extends ActionSupport implements ServletContextAware, ModelDriven{

	private ServletContext sCtx;
	private Account account = new Account();
	private int custId;
	
	public CreateAccountAction(){
		
	}

	public int getCustId() {
		System.out.println("OK");
		return custId;
	}




	public void setCustId(int custId) {
		System.out.println("OK");
		this.custId = custId;
	}




	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return account;
	}

	@Override
	public void setServletContext(ServletContext sCtx) {

		this.sCtx = sCtx;
		
	}

	public String execute(){
		System.out.println("cust_id"+custId);
		String result = ERROR;
		WebApplicationContext waCtx = WebApplicationContextUtils.getWebApplicationContext(sCtx);
		AccountDAO aDao = (AccountDAO)waCtx.getBean("accountDAO");
		
		boolean addSuccess = aDao.createAccount(account,custId);
		if (addSuccess)
			result = SUCCESS;
		return result;
		
		
	}
}
