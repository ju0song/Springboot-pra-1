package com.example.SpringbootProject.repository;

import com.example.SpringbootProject.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article,Long> {
}
