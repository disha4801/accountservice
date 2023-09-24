package com.dnb.accountservice.service;

import java.util.List;
import java.util.Optional;

import com.dnb.accountservice.dto.Account;
import com.dnb.accountservice.exceptions.IdNotFoundException;
import com.dnb.accountservice.exceptions.InsufficientBalanceException;
import com.dnb.accountservice.exceptions.InvalidAccountIdException;
import com.dnb.accountservice.exceptions.InvalidAddressException;
import com.dnb.accountservice.exceptions.InvalidContactNumberException;
import com.dnb.accountservice.exceptions.InvalidDateException;
import com.dnb.accountservice.exceptions.InvalidNameException;



public interface AccountService {
	public Account createAccount(Account account) throws IdNotFoundException, InvalidNameException,  InvalidContactNumberException, InvalidAddressException;
	
	public Optional<Account> getAccountById(String accountId);// throws InvalidNameException, InvalidDateException, InvalidAccountIdException, InvalidAccountTypeException, InvalidBalanceException, InvalidContactNumberException, InvalidAddressException, InvalidAccountStatusException;
	
	//public Optional<Account> getAccountByContactNumber(String contactNumber);
	public List<Account>getAllAccountsByContactNumber(String contactNumber);
	public Iterable<Account> getAllAccounts() throws InvalidNameException, InvalidDateException, InvalidAccountIdException,   InvalidContactNumberException, InvalidAddressException, InsufficientBalanceException;

	public boolean accountExistsById(String accountId);
	public boolean deleteAccountById(String accountId) throws IdNotFoundException;
}