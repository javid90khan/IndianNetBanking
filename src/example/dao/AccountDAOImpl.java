package example.dao;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import example.entity.Account;
import example.entity.Customer;
import example.entity.Transaction;

public class AccountDAOImpl  extends HibernateDaoSupport implements AccountDAO{

	@Override
	public boolean createAccount(Account account,int cust_id) {

		HibernateTemplate hTemplate = getHibernateTemplate();
		Date now = new Date();
		account.setCreationDate(now);
		hTemplate.save(account);
		
		Customer customer=hTemplate.load(Customer.class,cust_id);
		Account acc=hTemplate.load(Account.class,account.getAcc_no());
		
		customer.addAccount(acc);
		
		return true;
		
	}

	@Override
	public List<Account> getAccounts(String username) {
			try {
			System.out.println("username="+username);
			int cust_id=0;
			HibernateTemplate hTemplate = getHibernateTemplate();
		/*	
			Object[] params  = {cust_id};
			
			String hql_query="from Account a where a.cust_id= ?";
			
			List<Account> accounts=  hTemplate.find(hql_query,params);*/
			Object[] params  = {username};
			
			String hql_query="Select c.cust_id from Customer c where username=?";
			List<Object[]> rows=hTemplate.find(hql_query,username);
			for (Object row: rows) {
			  cust_id=Integer.parseInt( row.toString());
			}

			Customer c = (Customer)hTemplate.load(Customer.class, cust_id);
			List<Account> accounts = c.getAccounts();
			if(accounts!=null){
				return accounts;
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public double getBalance(int acc_no) {
		HibernateTemplate hTemplate = getHibernateTemplate();
		Object[] params  = {acc_no};
		String hql_query="Select balance from Account a where acc_no=?";
		double balance=0;
		List<Object[]> rows=hTemplate.find(hql_query,params);
		for (Object row: rows) {
		  balance=Double.parseDouble( row.toString());
		}
		return balance;
	}

	@Override
	public boolean fundTransfer(int from_acc_no, int to_acc_no, double amount) {
		
		HibernateTemplate hTemplate = getHibernateTemplate();
		Transaction destTrans = new Transaction();
		Transaction sourceTrans = new Transaction();
		destTrans.setCredit(amount);
		sourceTrans.setDebit(amount);
		Date now = new Date();
		destTrans.setTdate(now);
		sourceTrans.setTdate(now);
		sourceTrans.setDescription("Deposited to Account Number: "+to_acc_no);
		destTrans.setDescription("Credited from Account Number: "+from_acc_no);
		
		int sId = (Integer) hTemplate.save(sourceTrans);
		int dId = (Integer) hTemplate.save(destTrans);
		
		Account destination = hTemplate.load(Account.class, from_acc_no);
		Account sourceAcc = hTemplate.load(Account.class, to_acc_no);
	
		sourceAcc.withdraw(amount);
		destination.deposit(amount);
		
		sourceTrans = hTemplate.load(Transaction.class, sId);
		destTrans = hTemplate.load(Transaction.class, dId);
		sourceAcc.addTransaction(sourceTrans);
		destination.addTransaction(destTrans);
		return true;
		
	}


	
	
	
	

}
