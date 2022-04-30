package com.cybage.airline.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class CustomerUserDetails implements UserDetails {

	 private User user;
     
	    public CustomerUserDetails(User user) {
	        this.user = user;
	    }
	 
	 
	    @Override
	    public boolean isEnabled() {
	        return user.isEnabled();
	    }


		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public String getPassword() {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return false;
		}


		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return false;
		}


		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return false;
		}
	     

}
