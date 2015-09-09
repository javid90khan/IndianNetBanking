package example.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {

	 private static  final double MIN_BAL=1000;
	 private static  final double OVERDRAFT_LIMIT=5000;
	 
	private int acc_no;
	private String acc_type;
	private double balance;
	private Date creationDate;
	//private int cust_id;

	private List<Transaction> transactions;
	private List<Cheque> cheques;
	
	public Account() {
		transactions=new ArrayList<Transaction>();
		cheques = new ArrayList<Cheque>();
		
	}


	public List<Cheque> getCheques() {
		return cheques;
	}


	public void setCheques(List<Cheque> cheques) {
		this.cheques = cheques;
	}


	public void addCheque(Cheque cheque){
		this.cheques.add(cheque);
	}
	
	
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}


	public void addTransaction(Transaction transaction){
		transactions.add(transaction);
	}
	
	public int getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}

	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/*public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}*/
	
	public boolean withdraw(double amount){
		if(acc_type.equals("Saving")){
		
			if((balance - amount)>=MIN_BAL){
				balance -= amount;
				return true;
			}
		}
		else if(acc_type.equals("Curren")){
			if(amount <= balance + OVERDRAFT_LIMIT){
				balance -= amount;
				return true;
			}
		}
		return false;
	}
	
	public boolean deposit(double amount){
		
				balance += amount;
				return true;
		
	}
}
