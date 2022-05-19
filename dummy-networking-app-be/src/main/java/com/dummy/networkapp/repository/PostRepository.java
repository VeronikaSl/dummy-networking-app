package com.dummy.networkapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dummy.networkapp.domain.Post;


@Repository
public interface PostRepository extends CrudRepository<Post, Long>{
	
	@Query("select p from Post p where p.refPostId = ?1")
	List<Post> findByRefId(Long id);
}
