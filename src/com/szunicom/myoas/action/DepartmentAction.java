package com.szunicom.myoas.action;

import java.util.List;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.szunicom.myoas.base.BaseAction;
import com.szunicom.myoas.bean.Department;
import com.szunicom.myoas.utils.DepartmentUtils;

@Component
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long parentId;
	
	public String list(){
		List<Department> departments = null;
		if(parentId==null){
			departments = departmentService.findTopList();
		}else{
			departments = departmentService.findChildren(parentId);
			Department parent = departmentService.getById(parentId);
			ActionContext.getContext().put("parent", parent);
		}
		ActionContext.getContext().put("departments", departments);
		return "list";
	}
	public String add(){
		Department department = departmentService.getById(parentId);
		model.setParent(department);
		departmentService.save(model);
		return "toList";
	}
	public String edit(){
		Department department = departmentService.getById(parentId);
		model.setParent(department);
		departmentService.update(model);
		return "toList";
	}
	public String delete(){
		departmentService.delete(model.getId());
		return "toList";
	}
	public String addUI(){
		model.setId(null);
		model.setName("");
		model.setDescription("");
		List<Department> topList = departmentService.findTopList();
		List<Department> departments = DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("departments", departments);
		return "saveUI";
	}
	public String editUI(){
		List<Department> topList = departmentService.findTopList();
		List<Department> departments = DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("departments", departments);
		
		Department d = departmentService.getById(model.getId());
		if(d.getParent()!=null){
			parentId = d.getParent().getId();
		}
		
		ActionContext.getContext().getValueStack().push(d);
		
		return "saveUI";
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}
