package example.dao;
import java.util.List;

import example.entity.Transaction;
public interface TransactionDAO {

	public List<Transaction> getTransactions(int acc_no);
}
