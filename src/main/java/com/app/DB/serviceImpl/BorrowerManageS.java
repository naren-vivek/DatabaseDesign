package com.app.DB.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.DB.DAO.BookRepository;
import com.app.DB.DAO.BorrowerRepository;
import com.app.DB.DAO.FineRepository;
import com.app.DB.model.Book;
import com.app.DB.model.Borrower;
import com.app.DB.model.Fine;

@Service
@Transactional
public class BorrowerManageS {

	@Autowired
	BorrowerRepository borrowerRepository;

	@Autowired
	FineRepository fineRepository;

	@Autowired
	BookRepository bookRepository;

	public boolean addBorrower(String cardNo, String fname, String lname, String ssn, String address,
			String PhoneNumber) {

		if (borrowerRepository.isSsnValid(ssn)==0) {
			return false;
		} else {
			Borrower borrower = new Borrower();
			borrower.setCardNo(cardNo);
			borrower.setFname(fname);
			borrower.setLname(lname);
			borrower.setSsn(ssn);
			borrower.setAddress(address);
			borrower.setPhone(PhoneNumber);
			borrowerRepository.save(borrower);
			return true;
			// borrowerRepository.saveBorrower(fname,lname,ssn,address);
		}
	}

	public List<Fine> getFinesUnpaid(String cardNo) {
		List<Fine> fines = fineRepository.getFinesUnpaid(cardNo);
		return fines;

	}
	public List<Fine> getFinesPaid(String cardNo) {
		List<Fine> fines = fineRepository.getFinesPaid(cardNo);
		return fines;

	}
	public List<Fine> getFinesBoth(String cardNo) {
		List<Fine> fines = fineRepository.getFinesBoth(cardNo);
		return fines;

	}

	public List<Book> getOverdue(String cardNo) {
		List<Book> books = bookRepository.getOverdueBook(cardNo);
		return books;
	}

	public boolean finePaid(int loanId) {
		fineRepository.FineEntry(loanId);
		return true;
	}
}
