package com.staragile.financeme.financeme;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FinancemeController {

	
	@Autowired
	FinancemeService policySvc;
	
	@RequestMapping("hello")
	public String doSomething(){
		return "Hello World!!!";
	}
	
	@RequestMapping("/seeddata")
	public String getPolicy(){
		System.out.println("Inside seeddata");
		Financeme p1 = new Financeme("1", "shunbul", "dhanbad", "123456789");
		policySvc.addPolicy(p1);
		
		p1 = new Financeme("2", "bul", "bulbul", "987654321");
		policySvc.addPolicy(p1);
		return "Data seeded successfully!!!";
	}
	
	@RequestMapping("/financeme/{id}")
	public Optional<Financeme> getPolicy(@PathVariable String id){
		System.out.println("Inside getPolicy");
		return policySvc.getPolicy(id);
	}
	
	@RequestMapping("/financeme")
	public List<Financeme> getPolicies(){
		return policySvc.getPolicies();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/policy")
	public String addPolicy(@RequestBody Financeme policy) {
		policySvc.addPolicy(policy);
		return "Successfully added!!";
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/financeme/{id}")
	public String updatePolicy(@RequestBody Financeme policy, @PathVariable String id) {
		policySvc.updatePolicy(id, policy);
		return "Updated successfully";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/financeme/{id}")
	public String deletePolicy(@PathVariable String id) {
		policySvc.deletePolicy(id);
		return "Updated successfully";
	}
	
	
}
