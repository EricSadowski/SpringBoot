package com.video.blog.model;

import java.time.LocalDateTime;

public record Article(Integer id, String title, String content, LocalDateTime publishedOn) {
}
