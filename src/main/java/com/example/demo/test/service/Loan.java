package com.example.demo.test.service;

public sealed interface Loan permits UnSecuredLoan, SecuredLoan{

}
