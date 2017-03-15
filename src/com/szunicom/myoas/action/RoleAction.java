package com.szunicom.myoas.action;

import java.util.List;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.szunicom.myoas.base.BaseAction;
import com.szunicom.myoas.bean.Role;

@Component
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String list(){
		List<Role> roles = roleService.findAll();
		ActionContext.getContext().put("roles", roles);
		return "list";
	}
	public String add(){

		roleService.save(model);
		return "toList";
	}
	public String edit(){
		roleService.update(model);
		return "toList";
	}
	public String delete(){
		roleService.delete(model.getId());
		return "toList";
	}
	public String addUI(){
		model.setId(null);
		model.setName("");
		model.setDescription("");
		return "saveUI";
	}
	public String editUI(){
		Role r = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(r);
		return "saveUI";
	}

}
