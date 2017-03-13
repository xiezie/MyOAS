package com.szunicom.myoas.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.szunicom.myoas.bean.Department;

public class DepartmentUtils {
	
	public static List<Department> getAllDepartments(List<Department> topList){
		List<Department> departments = new ArrayList<Department>();
		traverseDepartmentTree(departments,"┠",topList);
		return departments;
	}

	private static void traverseDepartmentTree(List<Department> departments,String prefix,Collection<Department> topList) {
		for(Department department:topList){
			Department copy = new Department();
			copy.setId(department.getId());
			copy.setName(prefix + department.getName());
			departments.add(copy);
			traverseDepartmentTree(departments, "　"+prefix, department.getChildren());
		}
	} 
	
}
