package example.action;

import java.util.Map;

import javax.servlet.ServletContext;

import example.dao.LoginDAOI;
import example.dao.LoginDao;
import example.entity.User;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class LoginAction  extends ActionSupport implements ServletContextAware, ModelDriven,SessionAware {

	private String result;
	private ServletContext sCtx;
	private User user=new User();
	private SessionMap<String,Object> sessionMap;  
	public LoginAction(){
		
	}
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		
		return user;
		
	}

	@Override
	public void setServletContext(ServletContext sCtx) {
		this.sCtx = sCtx;
		
	}
	
	
	public String execute(){
		
		if( tooManyAttempts(user.getUsername(), user.getPassword())){
			
			WebApplicationContext waCtx = WebApplicationContextUtils.getWebApplicationContext(sCtx);
			LoginDAOI loginDao = (LoginDAOI)waCtx.getBean("loginDaoBean");
			loginDao.blockUser(user);
			return "reset";
		}
		else{
			sessionMap.put("username", user.getUsername());
		
			return result;

		}
	}

	@Override
	public void setSession(Map<String, Object> map) {
		 sessionMap=(SessionMap)map;  
		
	}

	public boolean tooManyAttempts(String username,String password) {
		
		WebApplicationContext waCtx = WebApplicationContextUtils.getWebApplicationContext(sCtx);
		LoginDAOI loginDao = (LoginDAOI)waCtx.getBean("loginDaoBean");

		
       int attempts = getLoginAttemptValue(sessionMap.get("LOGIN_ATTEMPTS"));
        result= loginDao.checkUser(username, password);
       if(result=="invalid") {
    	   		attempts+=1;
    	   	  sessionMap.put("LOGIN_ATTEMPTS", attempts);
       }
       
       
        return attempts >= 3;
    }
	
	private Integer getLoginAttemptValue(Object object) {
			if(object==null)
				return 0;
			else
				return Integer.parseInt(""+sessionMap.get("LOGIN_ATTEMPTS"));
		
	}

	public String logout() { 
		try{
		
	    if(sessionMap!=null){  
	        sessionMap.invalidate();  
	    }  
		}catch(Exception e){
			e.printStackTrace();
		}
	    return SUCCESS;  
	}  
	  

}
