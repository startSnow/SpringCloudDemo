package org.open.eureka.oauth2.server.service;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class DomainUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {


		boolean enables = true; // 是否可用
		boolean accountNonExpired = true; // 是否过期
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		// 封装成spring security的user
	String password=	DigestUtils.sha256Hex("123456");
		User userdetail = new User(username,password,
				enables, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authSet);
		return userdetail;
	}
}
