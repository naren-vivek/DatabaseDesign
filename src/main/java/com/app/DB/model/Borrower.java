package com.app.DB.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the borrower database table.
 * 
 */
@Entity
@NamedQuery(name="Borrower.findAll", query="SELECT b FROM Borrower b")
public class Borrower implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="card_no")
	private String cardNo;

	private String address;

	private String fname;

	private String lname;

	private String phone;

	private String ssn;
	

	//bi-directional many-to-one association to BookLoan
	
	@OneToMany(mappedBy="borrower",fetch=FetchType.LAZY)
	private List<BookLoan> bookLoans;

	public Borrower() {
	}

	public String getCardNo() {
		return this.cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSsn() {
		return this.ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public List<BookLoan> getBookLoans() {
		return this.bookLoans;
	}

	public void setBookLoans(List<BookLoan> bookLoans) {
		this.bookLoans = bookLoans;
	}

	public BookLoan addBookLoan(BookLoan bookLoan) {
		getBookLoans().add(bookLoan);
		bookLoan.setBorrower(this);

		return bookLoan;
	}

	public BookLoan removeBookLoan(BookLoan bookLoan) {
		getBookLoans().remove(bookLoan);
		bookLoan.setBorrower(null);

		return bookLoan;
	}

}