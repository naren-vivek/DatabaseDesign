package com.app.DB.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.DB.serviceImpl.BorrowerManageS;
import com.google.gson.Gson;

@RestController
@RequestMapping("/borrower")
public class BorrowerController {
	
	@Autowired
	BorrowerManageS borrowerManageService;
	
	Gson gson=new Gson();
	
	@RequestMapping(value="/addBorrower", method=RequestMethod.POST)
	public ResponseEntity<String> borrower(
			@RequestParam(required=true) String cardNo,	
			@RequestParam(required=true) String ssn,
			@RequestParam(required=true) String firstName,
			@RequestParam(required=true) String lastName,
			@RequestParam(required=true) String address,
			@RequestParam(required=false) String phoneNo){
			String check=borrowerManageService.addBorrower(cardNo,firstName,lastName, ssn, address,phoneNo);
			
			if(check.equals("success")){
				return new ResponseEntity<String>(gson.toJson(check),HttpStatus.OK);
			}else{
				return new ResponseEntity<String>(gson.toJson(check),HttpStatus.BAD_REQUEST);
			}
		
	}
	
	@RequestMapping(value="/fines",method=RequestMethod.GET)
	public ResponseEntity<String> fines(
			@RequestParam(required=true)String cardNo,
			@RequestParam (required=false)int paid
		){
		if(paid==1){
			return new ResponseEntity<String>(gson.toJson(borrowerManageService.getFinesPaid(cardNo)),HttpStatus.OK);
		}
		else if(paid==2){
			return new ResponseEntity<String>(gson.toJson(borrowerManageService.getFinesUnpaid(cardNo)),HttpStatus.OK);
		}
		else{
			return new ResponseEntity<String>(gson.toJson(borrowerManageService.getFinesBoth(cardNo)),HttpStatus.OK);
			
		}
 	
	}
	
	@RequestMapping(value="/overdue",method=RequestMethod.GET)
	public ResponseEntity<String> overdue(
			@RequestParam(required=true)String cardNo){
		return new ResponseEntity<String>(gson.toJson(borrowerManageService.getOverdue(cardNo)),HttpStatus.OK);
	}
	
	@RequestMapping(value="/pay",method=RequestMethod.POST)
	public ResponseEntity<String> fineEntry( 
			@RequestParam(required=true)int loanId
			){
		return new ResponseEntity<String>(gson.toJson(borrowerManageService.finePaid(loanId)), HttpStatus.OK);
	}
}
