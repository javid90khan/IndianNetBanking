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

public class ShowBalanceAction extends ActionSupport implements ServletContextAware,SessionAware {
	private ServletContext sCtx;
	private SessionMap<String,Object> sessionMap;  
	private double balance;
	
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public ShowBalanceAction(){
		
	}
	
	@Override
	public void setSession(Map<String, Object> map) {
		 sessionMap=(SessionMap)map;  
		
	}

	@Override
	public void setServletContext(ServletContext sCtx) {
		this.sCtx=sCtx;
		
	}
	
	public String execute(){
		WebApplicationContext waCtx = WebApplicationContextUtils.getWebApplicationContext(sCtx);
		AccountDAO aDao = (AccountDAO)waCtx.getBean("accountDAO");
		this.balance=aDao.getBalance(Integer.parseInt(""+sessionMap.get("acc_no")));
		return SUCCESS;
		
	}

}
