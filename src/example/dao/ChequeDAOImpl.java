package example.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.html.HTML;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import example.entity.Account;
import example.entity.Cheque;
import example.entity.Transaction;

public class ChequeDAOImpl extends HibernateDaoSupport implements ChequeDAO  {

	@Override
	public boolean depositCheque(int accId,Cheque cheque) {
		// TODO Auto-generated method stub
		try{
			HibernateTemplate hTemplate = getHibernateTemplate();
			cheque.setDep_date(new Date());
			cheque.setTo_acc_no(accId);
			cheque.setStatus("pending");
			hTemplate.save(cheque);

			Account account = (Account)hTemplate.load(Account.class, accId);

			account.addCheque(cheque);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public List<Cheque> getCheques() {
		
		HibernateTemplate hTemplate = getHibernateTemplate();
		
		List<Cheque> cheques=hTemplate.find("from Cheque c where c.status='pending'");
		
		if(cheques!=null){
			return cheques;
		}
		return null;

	}

	@Override
	public boolean approveCheques(List<String> selectedChequeIds) {
		
		HibernateTemplate hTemplate = getHibernateTemplate();
		Iterator itr=selectedChequeIds.iterator();
		
		
		while (itr.hasNext()) {
			String selectedChequeId = (String) itr.next();
			Cheque cheque=hTemplate.load(Cheque.class, Integer.parseInt(selectedChequeId));
			cheque.setStatus("Approved");
			Account account=hTemplate.load(Account.class,cheque.getTo_acc_no());
			Transaction transaction = new Transaction();
			transaction.setCredit(cheque.getAmount());
			transaction.setDebit(0);
			transaction.setDescription("Cheque Deposit");
			transaction.setTdate(new Date());
			account.addTransaction(transaction);
			account.deposit(cheque.getAmount());
			
			hTemplate.save(account);
			hTemplate.save(cheque);
			hTemplate.save(transaction);
		}
		
		
		
		
	
		return true;
	}

}
