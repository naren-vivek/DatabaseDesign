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
public class BorrowerManagement {
	
	@Autowired
	BorrowerManageS borrowerManageService;
	
	Gson gson=new Gson();
	
	@RequestMapping(value="/addBorrower", method=RequestMethod.POST)
	public ResponseEntity<String> borrower(
			@RequestParam(required=true) int ssn,
			@RequestParam(required=true) String name,
			@RequestParam(required=true) String address){
		/*if(!borrowerManageService.isSsnPresent(ssn)){
return new ResponseEntity<String>(gson.toJson(borrowerManageService.addBorrower(name, ssn, address)),HttpStatus.OK);
		}
		else{
			return new ResponseEntity<String>(gson.toJson("User already exist"),HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/fines")
	public ResponseEntity<String> fines(
			@RequestParam(required=true)String borrower
		){
		return new ResponseEntity<String>(gson.toJson(borrowerManageService.fines(borrower)),HttpStatus.OK); 	
	}
	
	@RequestMapping(value="/fineEntry")
	public ResponseEntity<String> fineEntry( 
			@RequestParam(required=true)boolean isPaid
			){
		return new ResponseEntity<String>(gson.toJson(borrowerManageService.FinePaid(isPaid)), HttpStatus.OK)*/;
		
		return new ResponseEntity<String>("hello",HttpStatus.OK);
	}
}
