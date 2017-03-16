package com.szunicom.myoas.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.szunicom.myoas.base.DaoSupportImpl;
import com.szunicom.myoas.bean.User;
import com.szunicom.myoas.service.UserService;

@Service
public class UserServiceImpl extends DaoSupportImpl<User> implements UserService {

}
