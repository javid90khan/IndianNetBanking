package example.action;

import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import example.dao.AccountDAO;
import example.dao.CustomerDAO;
import example.entity.Customer;
import example.entity.Transaction;

public class FundTransferAction extends ActionSupport implements ServletContextAware, ModelDriven,SessionAware{

	private ServletContext sCtx;
	private SessionMap<String,Object> sessionMap; 
	private Transaction transaction;
	private int to_acc_no;
	private double amount;
	
	public int getTo_acc_no() {
		return to_acc_no;
	}

	public void setTo_acc_no(int to_acc_no) {
		this.to_acc_no = to_acc_no;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	
	public FundTransferAction() {
		transaction=new Transaction();
	}

	@Override
	public void setServletContext(ServletContext sCtx) {
		// TODO Auto-generated method stub
		this.sCtx = sCtx;
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return transaction;
	}
	
	@Override
	public void validate(){
		super.validate();
	}
	
	public String execute(){
		System.out.println("in execute");
		String result = ERROR;
		WebApplicationContext waCtx = WebApplicationContextUtils.getWebApplicationContext(sCtx);
		AccountDAO aDao = (AccountDAO)waCtx.getBean("accountDAO");

		boolean success =aDao.fundTransfer(Integer.parseInt(""+sessionMap.get("acc_no")), to_acc_no, amount);
		
		if (success)
			result = SUCCESS;
		return result;
		
		
	}

	@Override
	public void setSession(Map<String, Object> map) {
		 sessionMap=(SessionMap)map;  
		
	}
}
