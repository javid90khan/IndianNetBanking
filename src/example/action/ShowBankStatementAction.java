package example.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;

import example.dao.AccountDAO;
import example.dao.TransactionDAO;
import example.entity.Account;
import example.entity.Transaction;

public class ShowBankStatementAction extends ActionSupport implements ServletContextAware,SessionAware{

	private ServletContext sCtx;
	private SessionMap<String,Object> sessionMap;  
	private List<Transaction> transactions;
	

	public ShowBankStatementAction(){
		transactions=new ArrayList<Transaction>();
	}
	
	
	public List<Transaction> getTransactions() {
		return transactions;
	}


	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
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
		try {
			WebApplicationContext waCtx = WebApplicationContextUtils.getWebApplicationContext(sCtx);
			TransactionDAO tDao = (TransactionDAO)waCtx.getBean("transactionDAO");
			transactions=tDao.getTransactions(Integer.parseInt(""+sessionMap.get("acc_no")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
		
	}

}
