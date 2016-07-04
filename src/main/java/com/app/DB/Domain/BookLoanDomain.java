package com.app.DB.Domain;

import java.util.Date;

public class BookLoanDomain {
	
	public BookLoanDomain(int loanId,int bookId,String cardNo,Date dateOut,Date dueDate,Date dateIn) {
		this.loanId = loanId;
		this.dateIn = dateIn;
		this.dateOut = dateOut;
		this.dueDate = dueDate;
		this.cardNo = cardNo;
		this.bookId = bookId;
	}
	private int loanId;
	private Date dateIn;
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public Date getDateIn() {
		return dateIn;
	}
	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}
	public Date getDateOut() {
		return dateOut;
	}
	public void setDateOut(Date dateOut) {
		this.dateOut = dateOut;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	private Date dateOut;
	private Date dueDate;
	private String cardNo;
	private int bookId;
}
