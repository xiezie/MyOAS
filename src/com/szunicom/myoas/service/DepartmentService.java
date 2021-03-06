package com.szunicom.myoas.service;

import java.util.List;

import com.szunicom.myoas.base.DaoSupport;
import com.szunicom.myoas.bean.Department;

public interface DepartmentService extends DaoSupport<Department> {

//	List<Department> findAll();
	List<Department> findTopList();
//	void delete(Long id);
//	void add(Department d);
//	void edit(Department d);
//	Department getById(Long id);
	List<Department> findChildren(Long parentId);
	
}
