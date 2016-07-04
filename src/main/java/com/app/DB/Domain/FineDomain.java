package com.app.DB.Domain;

public class FineDomain {

	public FineDomain(int loanId, float fineAmt, byte paid) {
		this.loanId = loanId;
		this.fineAmt = fineAmt;
		this.paid = paid;
	}
	private int loanId;
	private float fineAmt;
	private byte paid;

	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public float getFineAmt() {
		return fineAmt;
	}
	public void setFineAmt(float fineAmt) {
		this.fineAmt = fineAmt;
	}
	public byte getPaid() {
		return paid;
	}
	public void setPaid(byte paid) {
		this.paid = paid;
	}
}
