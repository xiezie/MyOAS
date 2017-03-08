package com.szunicom.myoas.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.szunicom.myoas.bean.Department;
import com.szunicom.myoas.service.DepartmentService;

@Component
@Scope("prototype")
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{

	@Resource
	private DepartmentService service;
	private Department model = new Department();
	
	public String list(){
		List<Department> departments = service.findAll();
		ActionContext.getContext().put("departments", departments);
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
		Department d = service.getById(model.getId());
		ActionContext.getContext().getValueStack().push(d);
		return "saveUI";
	}
	@Override              
	public Department getModel() {
		return model;
	}

}