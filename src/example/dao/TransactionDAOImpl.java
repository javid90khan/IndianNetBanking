package example.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import example.entity.Account;
import example.entity.Customer;
import example.entity.Transaction;

public class TransactionDAOImpl  extends HibernateDaoSupport implements TransactionDAO {

	@Override
	public List<Transaction> getTransactions(int acc_no) {
		
			
		
			HibernateTemplate hTemplate = getHibernateTemplate();
	
			Account account  = (Account)hTemplate.load(Account.class, acc_no);
			List<Transaction> transaction = account.getTransactions();
			if(transaction!=null){
				return transaction;
			}
			
		return null;
}
}
