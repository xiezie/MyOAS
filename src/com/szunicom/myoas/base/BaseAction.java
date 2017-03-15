package com.szunicom.myoas.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.szunicom.myoas.service.DepartmentService;
import com.szunicom.myoas.service.RoleService;

public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected T model;
	
	@SuppressWarnings("unchecked")
	public BaseAction(){
		Class<T> clazz = null;
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
		try {
			model = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public T getModel() {
		return model;
	}
	
	@Resource
	protected DepartmentService departmentService;
	@Resource
	protected RoleService roleService;

}
