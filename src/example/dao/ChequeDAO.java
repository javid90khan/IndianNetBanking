package example.dao;

import java.util.List;

import example.entity.Account;
import example.entity.Cheque;
import example.entity.Transaction;

public interface ChequeDAO {
	
		boolean depositCheque(int accId,Cheque cheque);
		public List<Cheque> getCheques();
		public boolean approveCheques(List<String> selectedChequeIds);
}
