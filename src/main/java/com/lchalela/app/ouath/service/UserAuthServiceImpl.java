package com.lchalela.app.ouath.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lchalela.app.ouath.clients.UserRest;
import com.lchalela.app.ouath.models.UserDTO;

import feign.FeignException;

@Service
public class UserAuthServiceImpl implements UserAuthService , UserDetailsService {

	@Autowired
	private UserRest userRest;
	private Logger logger = LoggerFactory.getLogger(UserAuthServiceImpl.class);
	
	@Override
	public UserDTO findByEmail(String email) {
		return this.userRest.findByEmail(email);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

			UserDTO user = this.userRest.findByEmail(username);
			
			if(user == null ) {
				String error = "Error en el login, no existe el usuario '" + username + "' en el sistema";
				logger.error(error);
				throw new UsernameNotFoundException(error);
			}
			
			logger.info(user.toString());
			
			List<GrantedAuthority> authorities = user.getRoles()
					.stream()
					.map(role -> new SimpleGrantedAuthority(role.getName()))
					.peek( authority -> logger.info("Role: " + authority.getAuthority())).collect(Collectors.toList() );
			logger.info("User authenticated: " + username);
			
			return new User(user.getEmail(), user.getPassword(), user.getEnabled(), true, true, true,
					authorities);
		
	}
}
