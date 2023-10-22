package com.staragile.financeme.financeme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinancemeService {
	

	@Autowired
	FinancemeDAORepository financemeDAORepository;

	//https://github.com/vilasvarghese/microservices/blob/master/training/day1/SpringBoot/4CompanyServiceImplementation.txt
	//continue from line : 115
	public List<Financeme> getPolicies(){
		/*return Arrays.asList(
			new Policy("1", "shunbul", "shunbul address", "123456789"),
			new Policy("2", "Yashwant", "Yashwant address", "234567891"),
			new Policy("3", "Krishna", "Krishna address", "345678912")
		);*/
		
		List<Financeme> policyList = new ArrayList<Financeme>();
		financemeDAORepository.findAll().forEach(policyList::add);
		return policyList;
	}
	
	public Optional<Financeme> getPolicy(String id) {
		return financemeDAORepository.findById(id);
	}
	
	public void addPolicy(Financeme policy) {
		financemeDAORepository.save(policy);
	}
	
	public void updatePolicy(String id, Financeme policy) {
		financemeDAORepository.save(policy);
	}
	
	public void deletePolicy(String id) {
		financemeDAORepository.deleteById(id);
	}
	
}
