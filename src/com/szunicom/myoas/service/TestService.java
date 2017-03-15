package com.szunicom.myoas.service;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.szunicom.myoas.bean.User;

@Service
public class TestService {

	@Resource
	private SessionFactory factory;
	
	@Transactional
	public void addTwo(){
		Session currentSession = factory.getCurrentSession();
		try {
			currentSession.save(new User());
			currentSession.save(new User());
		} catch (Exception e) {
		}finally{
		}
		
	}
	
}
