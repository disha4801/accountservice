package com.dnb.accountservice.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dnb.accountservice.dto.Account;
import com.dnb.accountservice.dto.Customer;
import com.dnb.accountservice.exceptions.IdNotFoundException;
import com.dnb.accountservice.exceptions.InvalidAccountIdException;
import com.dnb.accountservice.exceptions.InvalidAddressException;
import com.dnb.accountservice.exceptions.InvalidContactNumberException;
import com.dnb.accountservice.exceptions.InvalidDateException;
import com.dnb.accountservice.exceptions.InvalidNameException;
import com.dnb.accountservice.repo.AccountRepository;

@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
//	@Autowired
//	private ApiClient apiClient;
	@Autowired
	RestTemplate restTemplate;
	@Value("${api.customer}")
	private String URL;
//	@Autowired
//	private CustomerRepository customerRepository;

	@Override
	public Account createAccount(Account account)
			throws IdNotFoundException, InvalidNameException, InvalidContactNumberException, InvalidAddressException {
		System.out.println("customer id" + account.getCustomerId());
		System.out.println(URL);
		//Optional<Customer> customer=customerRepository.findById(account.getCustomer().getCustomerId());
		try {
			ResponseEntity<Customer> responseEntity = restTemplate.getForEntity(URL + "/" + account.getCustomerId(),
					Customer.class);
// 		if(customer.isPresent()) {
// 			account.setCustomer(customer.get());
			System.out.println(responseEntity.getBody());
//		Optional<Customer>customer = apiClient.getCustomerById(123);
//		try{
//			
			//if(customer.isPresent()) {
				return accountRepository.save(account);
			//}	

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
}
//	}
//	else
//			customer.orElseThrow(()->new IdNotFoundException("customer id Not valid"));
//		return null;


	@Override
	public Optional<Account> getAccountById(String accountId) {// throws InvalidNameException, InvalidDateException,
//			InvalidAccountIdException, InvalidAccountTypeException, InvalidBalanceException,
//			InvalidContactNumberException, InvalidAddressException, InvalidAccountStatusException {
		// TODO Auto-generated method stub
		return accountRepository.findById(accountId);
	}

	@Override
	public Iterable<Account> getAllAccounts() throws InvalidNameException, InvalidDateException,
			InvalidAccountIdException, InvalidContactNumberException, InvalidAddressException {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

	@Override
	public boolean deleteAccountById(String accountId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if (accountRepository.existsById(accountId)) {
			accountRepository.deleteById(accountId);
			if (accountRepository.existsById(accountId)) {
				return false;
			}
			return true;
		} else {
			throw new IdNotFoundException("AccountId not found");
		}
	}

	@Override
	public boolean accountExistsById(String accountId) {
		// TODO Auto-generated method stub
		if (accountRepository.existsById(accountId))
			return true;
		else
			return false;
	}

//	@Override
//	public Optional<Account> getAccountByContactNumber(String contactNumber) {
//		// TODO Auto-generated method stub
//		return accountRepository.findByContactNumber(contactNumber);
//	}

	@Override
	public List<Account> getAllAccountsByContactNumber(String contactNumber) {
		// TODO Auto-generated method stub
		return accountRepository.findByContactNumber(contactNumber);
	}

}


