package com.szunicom.myoas.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.szunicom.myoas.bean.Department;
import com.szunicom.myoas.dao.DepartmentDao;
import com.szunicom.myoas.service.DepartmentService;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class DepartmentServiceImpl implements DepartmentService {

	@Resource
	private DepartmentDao dao;
	@Resource
	private SessionFactory factory;
	
	@Override
	public List<Department> findAll() {
		return dao.findAll();
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

	@Override
	public void add(Department d) {
		dao.save(d);
	}

	@Override
	public void edit(Department d) {
		dao.update(d);
	}

	@Override
	public Department getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public List<Department> findTopList() {
		return factory.openSession().createQuery("FROM Department d WHERE d.parent IS NULL").list();
	}

	@Override
	public List<Department> findChildren(Long parentId) {
		return factory.openSession().createQuery("FROM Department d WHERE d.parent.id=?")//d.parent.id=?为面向对象的查询
				.setParameter(0, parentId)//
				.list();
	}

}
