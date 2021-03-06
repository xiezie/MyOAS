package com.szunicom.myoas.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.szunicom.myoas.service.TestService;

@Component
@Scope("prototype")
public class TestAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private TestService service;
	
	@Override
	public String execute() throws Exception {
		service.addTwo();
		return "success";
	}
	
}
