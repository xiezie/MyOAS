package com.szunicom.myoas.service;

import java.util.List;

import com.szunicom.myoas.bean.Department;

public interface DepartmentService {

	List<Department> findAll();
	void delete(Long id);
	void add(Department d);
	void edit(Department d);
	Department getById(Long id);
	
}
