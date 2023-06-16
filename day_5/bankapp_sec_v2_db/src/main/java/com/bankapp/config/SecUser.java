package com.bankapp.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.bankapp.entity.UserEntity;

public class SecUser implements UserDetails{

	private static final long serialVersionUID = 1L;
	
	private UserEntity userEntity;

	public SecUser(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	
	

	public UserEntity getUserEntity() {
		return userEntity;
	}




	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<String> rolesList=userEntity.getRoles();
		//now i need to convert this rolesList ie List<String> to String[]
		//how to convert this rolesList to the collection of GrantedAuthority
		
		String []rolesArray=rolesList.toArray(new String[rolesList.size()]);
		
		return AuthorityUtils.createAuthorityList(rolesArray);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userEntity.getPassword();
	}

	@Override
	public String getUsername() {
		return userEntity.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
