package com.lchalela.app.ouath.service;

import com.lchalela.app.ouath.models.UserDTO;

public interface UserAuthService {
	UserDTO findByEmail(String email);
}
