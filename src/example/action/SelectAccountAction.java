package example.action;

import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SelectAccountAction extends ActionSupport implements ServletContextAware, SessionAware{

	private ServletContext sCtx;
	private SessionMap<String,Object> sessionMap;  
	private int acc_no;
	
	
	public int getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}
	
	public SelectAccountAction(){
		
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
		sessionMap.put("acc_no", ""+acc_no);
		
		return SUCCESS;
		
	}
}
