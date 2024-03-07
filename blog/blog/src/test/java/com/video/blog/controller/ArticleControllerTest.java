package com.video.blog.controller;

import com.video.blog.model.Article;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArticleControllerTest {

    ArticleController controller;

    @BeforeEach
    void setUp(){
        controller = new ArticleController();
    }

    @Test
    void shouldReturnAllArticles(){
        assertEquals(2, controller.findAll().spliterator().getExactSizeIfKnown());
    }

    void shouldReturnArticleWithValidId(){
        Article article = controller.findById(1);
        assertNotNull(article);
    }

}