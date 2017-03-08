package com.szunicom.myoas.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.szunicom.myoas.bean.Role;
import com.szunicom.myoas.dao.RoleDao;
import com.szunicom.myoas.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleDao dao;
	
	@Override
	public List<Role> findAll() {
		return dao.findAll();
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

	@Override
	public void add(Role role) {
		dao.save(role);
	}

	@Override
	public void edit(Role role) {
		dao.update(role);
	}

	@Override
	public Role getById(Long id) {
		return dao.getById(id);
	}

}
