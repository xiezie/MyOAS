package com.szunicom.myoas.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.szunicom.myoas.base.DaoSupportImpl;
import com.szunicom.myoas.bean.Privilege;
import com.szunicom.myoas.service.PrivilegeService;

@SuppressWarnings("unchecked")
@Service
public class PrivilegeServiceImpl extends DaoSupportImpl<Privilege> implements PrivilegeService {

	@Override
	public List<Privilege> findTopList() {
		return factory.getCurrentSession().createQuery("FROM Privilege d WHERE d.parent IS NULL").list();
	}

	
	@Override
	public List<Privilege> findChildren(Long parentId) {
		return factory.getCurrentSession().createQuery("FROM Privilege d WHERE d.parent.id=?")//d.parent.id=?为面向对象的查询
				.setParameter(0, parentId)//
				.list();
	}

}
