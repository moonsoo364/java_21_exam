package com.example.demo.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.test.service.Loan;
import com.example.demo.test.service.SecuredLoan;
import com.example.demo.test.service.UnSecuredLoan;

@RestController
public class TestController {
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name") String name) {
		Loan loan = switch (name) {
			case "moonsoo" -> new SecuredLoan();
			default -> new UnSecuredLoan(0.3f);
		};
		String message = switch(loan) {
		case SecuredLoan securedLoan-> name+"님은 무이자입니다.";
		case UnSecuredLoan(float interest)-> name+"님은 이율이 "+ interest;
		};
		return message;
	}
}
