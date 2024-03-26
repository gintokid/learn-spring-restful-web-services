package com.madroid.rest.webservices.restfulwebservices.jpa;

import com.madroid.rest.webservices.restfulwebservices.user.Post;
import com.madroid.rest.webservices.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}
