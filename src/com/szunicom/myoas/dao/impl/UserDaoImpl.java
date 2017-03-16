package com.szunicom.myoas.dao.impl;

import org.springframework.stereotype.Repository;

import com.szunicom.myoas.base.BaseDaoImpl;
import com.szunicom.myoas.bean.User;
import com.szunicom.myoas.dao.UserDao;

@SuppressWarnings("deprecation")
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
}
