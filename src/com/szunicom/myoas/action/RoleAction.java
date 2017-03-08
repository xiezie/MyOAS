package com.szunicom.myoas.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.szunicom.myoas.bean.Role;
import com.szunicom.myoas.service.RoleService;

@Component
@Scope("prototype")
public class RoleAction extends ActionSupport implements ModelDriven<Role>{

	@Resource
	private RoleService service;

	private Role model = new Role();

	public String list(){
		List<Role> roles = service.findAll();
		ActionContext.getContext().put("roles", roles);
		return "list";
	}
	public String add(){

		service.add(model);
		return "toList";
	}
	public String edit(){
		service.edit(model);
		return "toList";
	}
	public String delete(){
		service.delete(model.getId());
		return "toList";
	}
	public String addUI(){
		model.setId(null);
		model.setName("");
		model.setDescription("");
		return "saveUI";
	}
	public String editUI(){
		Role r = service.getById(model.getId());
		ActionContext.getContext().getValueStack().push(r);
		return "saveUI";
	}
	@Override              
	public Role getModel() {
		return model;
	}

}
