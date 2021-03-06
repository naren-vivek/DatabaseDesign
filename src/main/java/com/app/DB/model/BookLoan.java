package com.app.DB.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the book_loans database table.
 * 
 */
@Entity
@Table(name="book_loans")
@NamedQuery(name="BookLoan.findAll", query="SELECT b FROM BookLoan b")
public class BookLoan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="loan_id")
	private int loanId;

	@Temporal(TemporalType.DATE)
	@Column(name="date_in")
	private Date dateIn;

	@Temporal(TemporalType.DATE)
	@Column(name="date_out")
	private Date dateOut;

	@Temporal(TemporalType.DATE)
	@Column(name="due_date")
	private Date dueDate;

	@Column(name="book_id")
	private int bookId;
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	@Column(name="card_no")
	private String cardNo;
	
	//bi-directional many-to-one association to BookCopy
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="book_id", insertable=false, updatable=false)
	private BookCopy bookCopy;

	//bi-directional many-to-one association to Borrower
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="card_no", insertable=false, updatable=false)
	private Borrower borrower;

	//bi-directional one-to-one association to Fine
	@OneToOne(mappedBy="bookLoan")
	private Fine fine;

	public BookLoan() {
	}

	public int getLoanId() {
		return this.loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public Date getDateIn() {
		return this.dateIn;
	}

	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}

	public Date getDateOut() {
		return this.dateOut;
	}

	public void setDateOut(Date dateOut) {
		this.dateOut = dateOut;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public BookCopy getBookCopy() {
		return this.bookCopy;
	}

	public void setBookCopy(BookCopy bookCopy) {
		this.bookCopy = bookCopy;
	}

	public Borrower getBorrower() {
		return this.borrower;
	}

	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}

	public Fine getFine() {
		return this.fine;
	}

	public void setFine(Fine fine) {
		this.fine = fine;
	}

}