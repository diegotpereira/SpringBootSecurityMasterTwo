package br.com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.java.model.User;

public interface UserRepository  extends JpaRepository<User, Long>{
	User findByUsername (String username);
}
