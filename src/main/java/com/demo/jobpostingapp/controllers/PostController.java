package com.demo.jobpostingapp.controllers;

import com.demo.jobpostingapp.Repositories.PostRepository;
import com.demo.jobpostingapp.Repositories.SearchRepository;
import com.demo.jobpostingapp.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

//    @RequestMapping(value = "/")
//    public void redirect(HttpServletResponse response) throws IOException {
//        response.sendRedirect("/swagger-ui.html");
//    }

    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepository srepo;

    @GetMapping(value = "/posts")
    public List<Post> getAllPosts(){
        System.out.println("getallposts");
        return repo.findAll();
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post post){
        return repo.save(post);
    }

    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text){
        return srepo.findByText(text);
    }
}
