package example.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javassist.bytecode.Descriptor.Iterator;

import javax.servlet.ServletContext;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;

import example.dao.AccountDAO;
import example.entity.Account;

public class ComboBoxAction extends ActionSupport implements SessionAware,ServletContextAware{
	private SessionMap<String,Object> sessionMap;  
	private List<Account> accounts;
	private List<String> acc_nos;
	private ServletContext sCtx;
 
	public List<String> getAcc_nos() {
		return acc_nos;
	}


	public void setAcc_nos(List<String> acc_nos) {
		this.acc_nos = acc_nos;
	}


	public ComboBoxAction(){
		
	}
 
	
	public String execute() {
		return SUCCESS;
	}
 
	public String display() {
		try {
			acc_nos=new ArrayList<String>();
			WebApplicationContext waCtx = WebApplicationContextUtils.getWebApplicationContext(sCtx);
			AccountDAO aDao = (AccountDAO)waCtx.getBean("accountDAO");
			System.out.println("getAccounts called");
			accounts=aDao.getAccounts(""+sessionMap.get("username"));
			System.out.println("accounts:"+accounts);
			
			java.util.Iterator<Account> iterator = accounts.iterator();
			while(iterator.hasNext()){
				
				Account acc = iterator.next();
				acc_nos.add(((Integer)acc.getAcc_no()).toString());
			}
			System.out.println(acc_nos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return NONE;
	}


	@Override
	public void setSession(Map<String, Object> map) {
		 sessionMap=(SessionMap)map;  
		
	}


	@Override
	public void setServletContext(ServletContext sCtx) {
		this.sCtx=sCtx;
		
	}
 
}
