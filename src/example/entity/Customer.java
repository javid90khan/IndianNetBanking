package example.entity;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Customer {
	
	private int cust_id;
	private String firstname,lastname,dob,address,username,password,mobile;
	private List<Account> accounts;
	
	
	
	
	
	public Customer() {
		accounts=new ArrayList<Account>();
		
	}

	

	public void addAccount(Account account){
		accounts.add(account);
	}

	public List<Account> getAccounts() {
		return accounts;
	}



	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}



	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
		System.out.println(this.cust_id);
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
		System.out.println(this.address);
	}


	public String getUsername() {
		return firstname+mobile.substring(4,7 )+lastname;
	}


	public void setUsername(String username) {
		this.username = username;
		System.out.println(this.username);
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		 
		this.password=password;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
		System.out.println(this.mobile);
	}
	
	
	public String generateRandomPassword(){
		
	    String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789+@";
	    Random RANDOM = new SecureRandom();
	    String pw = "";
	    for (int i=0; i<8; i++)
	    {
	        int index = (int)(RANDOM.nextDouble()*letters.length());
	        pw += letters.substring(index, index+1);
	    }
	    return pw;
	}
	
}
