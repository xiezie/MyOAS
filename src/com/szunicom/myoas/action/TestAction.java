package com.szunicom.myoas.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.szunicom.myoas.service.TestService;

@Component
public class TestAction extends ActionSupport{
	
	@Resource
	private TestService service;
	
	@Override
	public String execute() throws Exception {
		service.addTwo();
		return "success";
	}
	
}
