package com.szunicom.myoas.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.szunicom.myoas.bean.Privilege;

public class PrivilegeUtils {
	
	public static List<Privilege> getAllPrivileges(List<Privilege> topList){
		List<Privilege> privileges = new ArrayList<>();
		traversePrivilegeTree(privileges,topList);
		return privileges;
	}

	private static void traversePrivilegeTree(List<Privilege> privileges,Collection<Privilege> topList) {
		for(Privilege privilege:topList){
			privileges.add(privilege);
			traversePrivilegeTree(privileges, privilege.getChildren());
		}
	} 
	
}
