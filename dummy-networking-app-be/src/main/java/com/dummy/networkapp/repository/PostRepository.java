package com.dummy.networkapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dummy.networkapp.domain.Post;


@Repository
public interface PostRepository extends CrudRepository<Post, Long>{

	// TODO: @Daniel it is pure practice to use native SQL Queries. The Spring Data Jpa query method naming should be
	// used when possible https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details
	//@Query("select p from Post p where p.refPostId = ?1")
	List<Post> findByRefPostId(Long id);
}
