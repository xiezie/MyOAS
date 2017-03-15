package com.szunicom.myoas.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Deprecated
@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {

	@Resource
	private SessionFactory factory;
	
	private Class<T> clazz;
	
	public BaseDaoImpl() {
		//使用反射获取类型
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class<T>) type.getActualTypeArguments()[0];
		System.out.println("class-->"+clazz);
	}

	protected Session getSession(){
		return factory.getCurrentSession();
	}

	@Override
	public void save(T t) {
		getSession().save(t);
	}

	@Override
	public void delete(Long id) {
		Object object = getById(id);
		if(object != null){
			getSession().delete(object);
		}
	}

	@Override
	public void update(T t) {
		getSession().update(t);
	}


	@Override
	public T getById(Long id) {
		if(id==null){
			return null;
		}
		return (T) getSession().get(clazz, id);
	}

	@Override
	public List<T> getByIds(Long[] ids) {
		return getSession()//
				.createQuery("from " + clazz.getSimpleName() + " where id = (:ids)")//
				.setParameterList("ids", ids)//
				.list();
	}

	@Override
	public List<T> findAll() {
		return getSession()//
				.createQuery("from " + clazz.getSimpleName())//
				.list();
	}

}
