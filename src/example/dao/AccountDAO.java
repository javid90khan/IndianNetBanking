package example.dao;

import java.util.List;

import example.entity.Account;
import example.entity.Transaction;

public interface AccountDAO {

	boolean createAccount(Account account,int cust_id);
	List<Account> getAccounts(String username);
	double getBalance(int acc_no);
	boolean fundTransfer(int from_acc_no,int to_acc_no,double amount);
}

