package com.demo.jobpostingapp.Repositories;

import com.demo.jobpostingapp.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {


}
