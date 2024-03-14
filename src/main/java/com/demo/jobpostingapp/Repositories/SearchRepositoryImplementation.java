package com.demo.jobpostingapp.Repositories;

import com.demo.jobpostingapp.models.Post;
import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImplementation implements SearchRepository{

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public List<Post> findByText(String text) {

        final List<Post> posts = new ArrayList<>();

//        MongoDatabase database = client.getDatabase("job-posting");
//        MongoCollection<Document> collection = database.getCollection("JobPost");
//
//        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$Search",
//                new Document("text",
//                        new Document("query",text)
//                                .append("path", Arrays.asList("techs","desc","profile")))),
//                new Document("$sort",
//                        new Document("exp" , 1L)),
//                        new Document("$limit", 5L)));

        MongoDatabase database = client.getDatabase("job-posting");
        MongoCollection<Document> collection = database.getCollection("JobPost");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("text",
                        new Document("query", text)
                                .append("path", "desc")))));

        result.forEach(doc -> posts.add(converter.read(Post.class, doc)));


        return posts;
    }
}
