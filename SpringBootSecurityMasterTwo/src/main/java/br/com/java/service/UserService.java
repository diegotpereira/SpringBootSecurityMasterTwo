package br.com.java.service;

import br.com.java.model.User;

public interface UserService {
	
	void save(User user);
	User findByUsername(String username);
}
