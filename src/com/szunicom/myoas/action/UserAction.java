package com.szunicom.myoas.action;

import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.szunicom.myoas.base.BaseAction;
import com.szunicom.myoas.bean.Department;
import com.szunicom.myoas.bean.Role;
import com.szunicom.myoas.bean.User;
import com.szunicom.myoas.utils.DepartmentUtils;

@Component
@Scope("prototype")
public class UserAction extends BaseAction<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long departmentId;
	private Long[] roleIds;
	
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public Long[] getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}
	public String list(){
		List<User> users = userService.findAll();
		ActionContext.getContext().put("users", users);
		return "list";
	}
	public String add(){
		model.setDepartment(departmentService.getById(departmentId));
		model.setRoles(new HashSet<>(roleService.getByIds(roleIds)));
		model.setPassword("1234");
		userService.save(model);
		return "toList";
	}
	public String edit(){
		model.setDepartment(departmentService.getById(departmentId));
		model.setRoles(new HashSet<>(roleService.getByIds(roleIds)));
		userService.update(model);
		return "toList";
	}
	public String delete(){
		userService.delete(model.getId());
		return "toList";
	}
	public String addUI(){
		List<Department> topList = departmentService.findTopList();
		List<Department> departments = DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("departments", departments);
		List<Role> roles = roleService.findAll();
		ActionContext.getContext().put("roles", roles);
		return "saveUI";
	}
	public String editUI(){
		
		List<Department> topList = departmentService.findTopList();
		List<Department> departments = DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("departments", departments);
		
		List<Role> roles = roleService.findAll();
		ActionContext.getContext().put("roles", roles);
		
		User user = userService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(user);
		
		if(user.getDepartment()!=null){
			departmentId = user.getDepartment().getId();
		}
		if(user.getRoles()!=null){
			roleIds = new Long[user.getRoles().size()];
			int index = 0 ;
			for(Role role : user.getRoles()){
				roleIds[ index++ ] = role.getId();
			}
		}
		
		return "saveUI";
	}
	
	public String deletePassword(){
		model.setPassword("1234");
		model.setDepartment(departmentService.getById(departmentId));
		model.setRoles(new HashSet<>(roleService.getByIds(roleIds)));
		userService.update(model);
		return "toList";
	}

}
