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
import com.szunicom.myoas.utils.DepartmentUtils;

@Component
@Scope("prototype")
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{

	@Resource
	private DepartmentService service;
	private Long parentId;
	private Department model = new Department();
	
	public String list(){
		List<Department> departments = null;
		if(parentId==null){
			departments = service.findTopList();
		}else{
			departments = service.findChildren(parentId);
			Department parent = service.getById(parentId);
			ActionContext.getContext().put("parent", parent);
		}
		ActionContext.getContext().put("departments", departments);
		return "list";
	}
	public String add(){
		Department department = service.getById(parentId);
		model.setParent(department);
		service.add(model);
		return "toList";
	}
	public String edit(){
		Department department = service.getById(parentId);
		model.setParent(department);
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
		List<Department> topList = service.findTopList();
		List<Department> departments = DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("departments", departments);
		return "saveUI";
	}
	public String editUI(){
		List<Department> topList = service.findTopList();
		List<Department> departments = DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("departments", departments);
		
		Department d = service.getById(model.getId());
		if(d.getParent()!=null){
			parentId = d.getParent().getId();
		}
		
		ActionContext.getContext().getValueStack().push(d);
		
		return "saveUI";
	}
	@Override              
	public Department getModel() {
		return model;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}
