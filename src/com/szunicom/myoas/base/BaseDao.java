package com.szunicom.myoas.base;

import java.util.List;

@Deprecated
public interface BaseDao<T> {

	void save(T t);
	
	void delete(Long id);
	
	void update(T t);

	T getById(Long id);
	
	List<T> getByIds(Long[] ids);
	
	List<T> findAll();
	
}
