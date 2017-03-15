package com.szunicom.myoas.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.szunicom.myoas.base.DaoSupportImpl;
import com.szunicom.myoas.bean.Department;
import com.szunicom.myoas.service.DepartmentService;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class DepartmentServiceImpl extends DaoSupportImpl<Department> implements DepartmentService {

	@Resource
	private SessionFactory factory;

	@Override
	public List<Department> findTopList() {
		return factory.getCurrentSession().createQuery("FROM Department d WHERE d.parent IS NULL").list();
	}

	@Override
	public List<Department> findChildren(Long parentId) {
		return factory.getCurrentSession().createQuery("FROM Department d WHERE d.parent.id=?")//d.parent.id=?为面向对象的查询
				.setParameter(0, parentId)//
				.list();
	}

}
