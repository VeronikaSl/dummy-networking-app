package com.dummy.networkapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dummy.networkapp.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	public User findUserByUser(String user);

}
