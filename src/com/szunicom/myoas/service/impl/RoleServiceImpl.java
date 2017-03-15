package com.szunicom.myoas.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.szunicom.myoas.base.DaoSupportImpl;
import com.szunicom.myoas.bean.Role;
import com.szunicom.myoas.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl extends DaoSupportImpl<Role> implements RoleService {


}
