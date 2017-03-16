package com.szunicom.myoas.action;

import java.util.HashSet;
import java.util.List;






import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.szunicom.myoas.base.BaseAction;
import com.szunicom.myoas.bean.Privilege;
import com.szunicom.myoas.bean.Role;
import com.szunicom.myoas.utils.PrivilegeUtils;

@Component
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{

	private Long[] privilegeIds;
	
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
	
	public String editPrivilegeUI(){
		Role r = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(r);
		
		if(r.getPrivileges()!=null){
			privilegeIds = new Long[r.getPrivileges().size()];
			int index = 0 ;
			for(Privilege p : r.getPrivileges()){
				privilegeIds[ index++ ] = p.getId();
			}
		}
		
		List<Privilege> topList = privilegeService.findTopList();
		List<Privilege> privileges = PrivilegeUtils.getAllPrivileges(topList);
		ActionContext.getContext().put("privileges", privileges);
		return "editPrivilegeUI";
	}
	
	public String editPrivilege(){
		Role role = roleService.getById(model.getId());
		role.setPrivileges(new HashSet<Privilege>(privilegeService.getByIds(privilegeIds)));
		roleService.save(role);
		return "toList";
	}
	public Long[] getPrivilegeIds() {
		return privilegeIds;
	}
	public void setPrivilegeIds(Long[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}

}
