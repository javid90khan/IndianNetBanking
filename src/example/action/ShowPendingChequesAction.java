package example.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;

import example.dao.ChequeDAO;
import example.dao.TransactionDAO;
import example.entity.Account;
import example.entity.Cheque;
import example.entity.Transaction;

public class ShowPendingChequesAction extends ActionSupport implements ServletContextAware,SessionAware{
	private ServletContext sCtx;
	private List<Cheque> cheques;
	private List<String> chequeIds;
	
	private SessionMap<String,Object> sessionMap;  
	

	public ShowPendingChequesAction(){
		cheques=new ArrayList<Cheque>();
		chequeIds=new ArrayList<String>();
	}
	


	public List<String> getChequeIds() {
		return chequeIds;
	}

	public void setChequeIds(List<String> chequeIds) {
		this.chequeIds = chequeIds;
	}


	public List<Cheque> getCheques() {
		return cheques;
	}

	public void setCheques(List<Cheque> cheques) {
		this.cheques = cheques;
	}


	@Override
	public void setServletContext(ServletContext sCtx) {
		this.sCtx=sCtx;
		
	}
	
	public String execute(){
		try {
			WebApplicationContext waCtx = WebApplicationContextUtils.getWebApplicationContext(sCtx);
			ChequeDAO cDao = (ChequeDAO)waCtx.getBean("chequeDAO");
			cheques=cDao.getCheques();
			Iterator itr=cheques.iterator();
			while(itr.hasNext()){
				System.out.println("adding to cheque ids");
				Cheque cheque=(Cheque) itr.next();
				chequeIds.add(""+cheque.getCheque_id());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
		
	}
	
	@Override
	public void setSession(Map<String, Object> map) {
		 sessionMap=(SessionMap)map;  
		
	}

}
