package com.app.DB.serviceImpl;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.DB.DAO.BookLoans;
import com.app.DB.DAO.BookSearchRepository;
import com.app.DB.model.BookCopy;
import com.app.DB.model.BookLoan;

@Transactional
@Service
public class BookLoanS{

	@Autowired
	BookSearchRepository bookSearchRepository;
	
	@Autowired
	BookLoans bookLoans;
	
	public String checkOut(String fname,String lname,String cardNo,int bookId) {
		// TODO Auto-generated method stub
		
		Long count=bookSearchRepository.check(cardNo);
		
		int val=bookSearchRepository.avaliable(bookId);
		System.out.println("value:"+ val);
		if(bookSearchRepository.check(cardNo)>=3){
			return "User already borrowed 3 books";
		}/*else if(bookSearchRepository.isOverDue(cardNo)>0){
			return "User has overDue";
		}*/
		else if(bookSearchRepository.isPaid(cardNo)>0){
			return "user has Unpaid Amount";
		}
		else if(bookSearchRepository.avaliable(bookId)==1){
			
			Date dateOut = new Date(new java.util.Date().getTime());
			Date dueDate = new Date(new java.util.Date().getTime()); 
			BookLoan bookLoan=new BookLoan();
			BookCopy bookCopy=new BookCopy();
			bookLoan.setBookId(bookId);
			bookLoan.setCardNo(cardNo);
			bookLoan.setDateOut(dateOut);
			int date=dueDate.getDate()+14;
			dueDate.setDate(date);
			bookLoan.setDueDate(dueDate);
			bookLoans.save(bookLoan);
			bookSearchRepository.setBackAvailable(bookId,0);
			return "success";
		}else{
			return "already book borrowed";
		}
		
	}

	public int numOfBooks(String borrower) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean checkIn(String borrower, String Bookname) {
		// TODO Auto-generated method stub
		
		//fetch the data to check fines
		//if(bookSearchRepository.)
		return false;
	}

}
