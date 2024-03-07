package com.video.blog.repository;

import com.video.blog.model.Article;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class ArticleRepository {

    private List<Article> articles;

    public ArticleRepository(){
        articles = List.of(
                new Article(1,"Hi", "Welcome", LocalDateTime.now()),
                new Article(2,"bye", "Welcome to cheese world", LocalDateTime.now()),
                new Article(3,"ok", "Please help im crushed by cheese", LocalDateTime.now())
        );
    }

    public List<Article> findAll(){
        return articles;
    }

    public Article findById(Integer id){
        return articles.stream().filter(article -> article.id().equals(id)).findFirst().orElse(null);
    }
}
