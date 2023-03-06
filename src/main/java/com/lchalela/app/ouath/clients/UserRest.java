package com.lchalela.app.ouath.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lchalela.app.ouath.models.UserDTO;

@FeignClient(name = "user-service")
public interface UserRest {
	
	@GetMapping("/v1/findByEmail")
	public UserDTO findByEmail(@RequestParam String email);
}
