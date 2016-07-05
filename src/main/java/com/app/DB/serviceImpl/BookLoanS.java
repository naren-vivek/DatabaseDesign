package com.app.DB.serviceImpl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.DB.DAO.BookLoans;
import com.app.DB.DAO.BookSearchRepository;
import com.app.DB.DAO.BorrowerRepository;
import com.app.DB.DAO.FineRepository;
import com.app.DB.model.BookLoan;
import com.app.DB.model.Fine;

@Transactional
@Service
public class BookLoanS {

	@Autowired
	BookSearchRepository bookSearchRepository;

	@Autowired
	BookLoans bookLoans;
	
	@Autowired
	FineRepository fineRepository;
	
	@Autowired
	BorrowerRepository borrowerRepository;
	
	public String checkOut(String cardNo, int bookId) {
		
		if(borrowerRepository.exists(cardNo)){
		if (bookSearchRepository.check(cardNo) >= 3) {
			return "User already borrowed 3 books";
		} else if (bookSearchRepository.isOverDueCheckOut(cardNo) > 0) {
			return "User has overDue";
		} else if (bookSearchRepository.isPaid(cardNo) > 0) {
			return "user has Unpaid Amount";
		} else if (bookSearchRepository.avaliable(bookId) == 1) {

			Date dateOut = new Date(new java.util.Date().getTime());
			Date dueDate = new Date(new java.util.Date().getTime());
			BookLoan bookLoan = new BookLoan();
			bookLoan.setBookId(bookId);
			bookLoan.setCardNo(cardNo);
			bookLoan.setDateOut(dateOut);
			int date = dueDate.getDate() + 14;
			dueDate.setDate(date);
			bookLoan.setDueDate(dueDate);
			bookLoans.save(bookLoan);
			bookSearchRepository.setBookAvailable(bookId, 0);
			return "success";
		} else {
			return "already book borrowed";
		}
		}else{
			return "Borrower not found";
		}
	}

	public List<BookLoan> checkIn(String cardNo, int BookId) {
		// TODO Auto-generated method stub
		if (bookSearchRepository.isOverDue(BookId) > 0) {
			int loanId = bookSearchRepository.OverDueLoanId(BookId);
			float fineamt = bookSearchRepository.OverDueLoan(BookId);
			fineamt=(float) ((float)fineamt * 0.25);
			//bookSearchRepository.UpdateOverDue(loanId, dateDiff);
			Fine fine=new Fine();
			fine.setLoanId(loanId);
			fine.setFineAmt(fineamt);
			fine.setPaid((byte)0);
			fineRepository.save(fine);
		}
		bookSearchRepository.checkIn(cardNo, BookId);
		bookSearchRepository.setBookAvailable(BookId, 1);
		List<BookLoan> bookLoan=bookSearchRepository.getSingleBooks(cardNo, BookId);
		return bookLoan;
	}
	
	public List<BookLoan> getActiveBooksCardNum(String cardNo){
		
		List<BookLoan>books=bookSearchRepository.getActiveBooksCardNo(cardNo);
		return books;
	}
	
	public List<BookLoan> getActiveBooks(String isbn){
		List<BookLoan> books=bookSearchRepository.getActiveBooks(isbn);
		return books;
	}

}
