package com.app.DB.serviceImpl;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DB.DAO.BookSearchRepository;

@Service
public class BookLoanS{

	@Autowired
	BookSearchRepository bookSearchRepository;
	
	public boolean checkOut(Date dateOut, Date Datedue, String borrower) {
		// TODO Auto-generated method stub
		return false;
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
