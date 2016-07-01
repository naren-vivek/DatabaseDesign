package com.app.DB.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DB.DAO.BorrowerRepository;
import com.app.DB.model.Borrower;

@Service
public class BorrowerManageS {

	@Autowired
	BorrowerRepository BorrowerRepository;
	
	public boolean addBorrower(String fname,String lname,String ssn,String address){
		
		if(BorrowerRepository.exists(ssn)){
			return false;
		}
		else{
			Borrower borrower=new Borrower();
			borrower.setFname(fname);
			borrower.setLname(lname);
			borrower.setSsn(ssn);
			borrower.setAddress(address);
			BorrowerRepository.save(borrower);
			return true;
		}
	}
}
