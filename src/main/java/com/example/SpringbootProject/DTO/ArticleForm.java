package com.example.SpringbootProject.DTO;

import com.example.SpringbootProject.entity.Article;

public class ArticleForm {
    private String title;
    private String content;

    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
   //1.Dto를 변환 Entity!
    public Article toEntity() {
        return new Article(null,title,content);
    }
}
