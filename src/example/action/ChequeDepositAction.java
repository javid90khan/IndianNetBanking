package example.action;

import java.util.Date;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import example.dao.ChequeDAO;
import example.entity.Cheque;

public class ChequeDepositAction extends ActionSupport implements ServletContextAware, ModelDriven {

	private ServletContext sCtx;
	private Cheque cheque = new Cheque();

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return cheque;
	}

	@Override
	public void setServletContext(ServletContext sCtx) {
		// TODO Auto-generated method stub
		this.sCtx= sCtx;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String result= ERROR;
		System.out.println("CHeque Deposit execute");
		WebApplicationContext waCtx = WebApplicationContextUtils.getWebApplicationContext(sCtx);
		ChequeDAO cDao = (ChequeDAO)waCtx.getBean("chequeDAO");
		cheque.setStatus("pending");
		
		Date depositDate = new Date();
		cheque.setDep_date(depositDate);
		
		boolean isSuccess = cDao.depositCheque(cheque.getTo_acc_no(),cheque);
		
		System.out.println(isSuccess);
		
		if(isSuccess){
			result = SUCCESS;
		}
		
		return result;
	}

	@Override
	public void validate() {
		super.validate();
		/*System.out.println("CHeque Deposit execute");
		// TODO Auto-generated method stub
		
		if(cheque.getCheque_id()==0){
			addFieldError("cheque_id",getText("Please enter cheque id."));
		}
		if(cheque.getTo_acc_no()==0){
			addFieldError("to_acc_no",getText("Please enter account number."));
		}
	
		if(cheque.getB_details().equals("")){
			addFieldError("b_details",getText("Please enter bank details."));
		}
		if(cheque.getCheque_no()==0){
			addFieldError("cheque_no",getText("Please enter cheque number."));
		}
		
		if(cheque.getAmount()==0){
			addFieldError("amount",getText("Please enter amount."));
		}
		*/
		
	}

}
