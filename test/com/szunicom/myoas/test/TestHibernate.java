package com.szunicom.myoas.test;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.szunicom.myoas.service.TestService;

public class TestHibernate {

	ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
	
	@Test
	public void test(){
		SessionFactory factory = (SessionFactory) ac.getBean("sessionFactory");
		System.out.println(factory);
		TestService service = (TestService) ac.getBean("testService");
		service.addTwo();
	}
	
}
