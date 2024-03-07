package com.video.blog.controller;

import com.video.blog.model.Article;
import com.video.blog.repository.ArticleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/api/articles")
public class ArticleController {

    private final ArticleRepository articleRepository;

    public ArticleController(){
        this.articleRepository = new ArticleRepository();
    }

    @GetMapping
    public List<Article> findAll(){
        return articleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Article findById(@PathVariable Integer id){
        return articleRepository.findById(id);
    }
}
