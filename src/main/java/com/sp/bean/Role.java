package com.sp.bean;

import lombok.Getter;

@Getter
public enum Role {

	USER(1011, "USER"), ADMIN(1012, "ADMIN");
	
	private int roleId;
	private String roleName;
	
	private Role(int roleId, String roleName) {
		this.roleId = roleId;
		this.roleName = roleName;
	}
	
	public static Role getRoleById(int roleId) {
		for (Role role : Role.values()) {
			if (role.getRoleId() == roleId) {
				return role;
			}
		}
		return null;
	}
	
}
