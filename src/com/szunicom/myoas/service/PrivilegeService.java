package com.szunicom.myoas.service;

import java.util.List;

import com.szunicom.myoas.base.DaoSupport;
import com.szunicom.myoas.bean.Privilege;

public interface PrivilegeService extends DaoSupport<Privilege> {

	List<Privilege> findTopList();
	List<Privilege> findChildren(Long parentId);
	
}
