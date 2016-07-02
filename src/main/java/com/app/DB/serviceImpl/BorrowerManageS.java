package com.app.DB.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DB.DAO.BookRepository;
import com.app.DB.DAO.BorrowerRepository;
import com.app.DB.DAO.FineRepository;
import com.app.DB.model.Book;
import com.app.DB.model.Borrower;
import com.app.DB.model.Fine;

@Service
public class BorrowerManageS {

	@Autowired
	BorrowerRepository borrowerRepository;
	
	 @Autowired
	FineRepository fineRepository;
	
	/*@Autowired
	BookRepository bookRepository;
	*/
	public boolean addBorrower(String cardNo,String fname,String lname,String ssn,String address,String PhoneNumber){
		
		if(borrowerRepository.exists(ssn)){
			return false;
		}
		else{
			Borrower borrower=new Borrower();
			borrower.setCardNo(cardNo);
			borrower.setFname(fname);
			borrower.setLname(lname);
			borrower.setSsn(ssn);
			borrower.setAddress(address);
			borrower.setPhone(PhoneNumber);
			borrowerRepository.save(borrower);
			return true;
			//borrowerRepository.saveBorrower(fname,lname,ssn,address);
		}
	}
	
	public Fine fines(String fname,String lname){
		Fine fines=fineRepository.getFines(fname,lname);
		return fines;
		
	}
	
	public List<Book> getOverdue(String fname,String lname){
		return null;
		/*List<Book> books=bookRepository.getOverdueBook(fname,lname);
		return books;*/
	}
}
