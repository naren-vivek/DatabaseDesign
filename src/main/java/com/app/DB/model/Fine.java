package com.app.DB.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the fines database table.
 * 
 */
@Entity
@Table(name="fines")
@NamedQuery(name="Fine.findAll", query="SELECT f FROM Fine f")
public class Fine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="loan_id")
	private int loanId;

	@Column(name="fine_amt")
	private float fineAmt;

	@Column(name="paid")
	private byte paid;

	//bi-directional one-to-one association to BookLoan
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="loan_id")
	private BookLoan bookLoan;

	public Fine() {
	}

	public int getLoanId() {
		return this.loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public float getFineAmt() {
		return this.fineAmt;
	}

	public void setFineAmt(float fineAmt) {
		this.fineAmt = fineAmt;
	}

	public byte getPaid() {
		return this.paid;
	}

	public void setPaid(byte paid) {
		this.paid = paid;
	}

	public BookLoan getBookLoan() {
		return this.bookLoan;
	}

	public void setBookLoan(BookLoan bookLoan) {
		this.bookLoan = bookLoan;
	}

}