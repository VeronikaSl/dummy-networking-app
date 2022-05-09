package com.dummy.networkapp.repository;

import com.dummy.networkapp.domain.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends CrudRepository<Post, Long>{
    
}
