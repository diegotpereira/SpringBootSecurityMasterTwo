package br.com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.java.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
