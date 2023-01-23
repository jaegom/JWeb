package com.jweb.sbb.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Jasonlt
 * UserSecurityService는 스프링 시큐리티 로그인 처리의 핵심 부분이다.
 * UserDetailService 구현
 */

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService {
	
	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<SiteUser> _siteUser = this.userRepository.findByUsername(username);
		
		if (_siteUser.isEmpty()) {
			throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
		}
		
		SiteUser siteUser = _siteUser.get(); //isEmpty 통과 후 실제 user에 대한 권한 심사
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		if ("admin".equals(username)) {
			authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
		} else {
			authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
		}
		
		return new User(siteUser.getUsername(), siteUser.getPassword(), authorities); 
	
	}
	
}
