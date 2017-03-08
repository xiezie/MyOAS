package com.szunicom.myoas.service;

import java.util.List;

import com.szunicom.myoas.bean.Role;

public interface RoleService {

	List<Role> findAll();
	void delete(Long id);
	void add(Role r);
	void edit(Role r);
	Role getById(Long id);
	
}
