package com.demo.jobpostingapp.Repositories;

import com.demo.jobpostingapp.models.Post;

import java.util.List;

public interface SearchRepository {

    List<Post> findByText(String text);
}
