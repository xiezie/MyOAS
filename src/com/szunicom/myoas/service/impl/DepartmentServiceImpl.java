package com.szunicom.myoas.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.szunicom.myoas.bean.Department;
import com.szunicom.myoas.dao.DepartmentDao;
import com.szunicom.myoas.service.DepartmentService;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	@Resource
	private DepartmentDao dao;
	
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

}
