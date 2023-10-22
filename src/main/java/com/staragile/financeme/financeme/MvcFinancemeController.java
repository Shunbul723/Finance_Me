package com.staragile.financeme.financeme;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MvcFinancemeController {

	
	@Autowired
	FinancemeService financemeSvc;
	
	@RequestMapping("mvchello")
	public String doSomething(){
		return "Hello World!!!";
	}
	
	
	@RequestMapping("/getallaccounts")
	public String getAllPolicies(HttpServletRequest req, HttpServletResponse res) {
		List<Financeme> policyList = financemeSvc.getPolicies();
		req.getSession().setAttribute("policyList", policyList);
		return "finance.jsp";
	}
	
	
	
	
	@RequestMapping("/createaccounts")
	public String addPolicy(HttpServletRequest req, HttpServletResponse res) {
		Financeme policy = new Financeme();
		policy.setAccountId(req.getParameter("id"));
		policy.setCustomerName(req.getParameter("name"));
		policy.setCustomerAddress(req.getParameter("address"));
		policy.setContactNumber(req.getParameter("contact"));
		financemeSvc.addPolicy(policy);
		return getAllPolicies(req,res);
	}
	
	@RequestMapping("/updateaccounts")
	public String updatePolicy(HttpServletRequest req, HttpServletResponse res) {
		Financeme policy = new Financeme();
		policy.setAccountId(req.getParameter("id"));
		policy.setCustomerName(req.getParameter("name"));
		policy.setCustomerAddress(req.getParameter("address"));
		policy.setContactNumber(req.getParameter("contact"));
		financemeSvc.updatePolicy(req.getParameter("id"),policy);
		return getAllPolicies(req,res);
	}
	
	
	
	@RequestMapping("/deleteaccounts")
	public String deletePolicy(HttpServletRequest req, HttpServletResponse res) {
		financemeSvc.deletePolicy(req.getParameter("id"));
		return getAllPolicies(req,res);
	}
}
