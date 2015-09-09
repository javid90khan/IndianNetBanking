package example.action;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import example.dao.AccountDAO;
import example.dao.ChequeDAO;
import example.dao.CustomerDAO;
import example.entity.Customer;

public class ApproveChequesAction  extends ActionSupport implements ServletContextAware {

	private ServletContext sCtx;
	private List<String> selectedChequeIds;
	private List<String> to_acc_nos;
	
	

	public ApproveChequesAction() {
		// TODO Auto-generated constructor stub
	}


	





	public List<String> getSelectedChequeIds() {
		return selectedChequeIds;
	}








	public void setSelectedChequeIds(List<String> selectedChequeIds) {
		this.selectedChequeIds = selectedChequeIds;
	}








	@Override
	public void setServletContext(ServletContext sCtx) {
		// TODO Auto-generated method stub
		this.sCtx = sCtx;
	}

	public String execute(){
		
		String result = ERROR;
		WebApplicationContext waCtx = WebApplicationContextUtils.getWebApplicationContext(sCtx);
		ChequeDAO chDao = (ChequeDAO)waCtx.getBean("chequeDAO");
		AccountDAO aDao=(AccountDAO)waCtx.getBean("accountDAO");
		
		boolean addSuccess = chDao.approveCheques(selectedChequeIds);
		if (addSuccess)
			result = SUCCESS;
		return result;
		
		
	}
}
