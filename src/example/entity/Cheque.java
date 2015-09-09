package example.entity;

import java.util.Date;

public class Cheque {

	
	int cheque_id,cheque_no,to_acc_no;
	String b_details,status;
	double amount;
	Date cheque_date,dep_date;

	public Cheque() {
		//account=new Account();
		// TODO Auto-generated constructor stub
	}

	public int getCheque_id() {
		return cheque_id;
	}

	public void setCheque_id(int cheque_id) {
		this.cheque_id = cheque_id;
	}

	public int getTo_acc_no() {
		return to_acc_no;
	}

	public void setTo_acc_no(int to_acc_no) {
		this.to_acc_no = to_acc_no;
	}

	public int getCheque_no() {
		return cheque_no;
	}

	public void setCheque_no(int cheque_no) {
		this.cheque_no = cheque_no;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getB_details() {
		return b_details;
	}

	public void setB_details(String b_details) {
		this.b_details = b_details;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getCheque_date() {
		return cheque_date;
	}

	public void setCheque_date(Date cheque_date) {
		this.cheque_date = cheque_date;
	}

	public Date getDep_date() {
		return dep_date;
	}

	public void setDep_date(Date dep_date) {
		this.dep_date = dep_date;
	}
	
}
