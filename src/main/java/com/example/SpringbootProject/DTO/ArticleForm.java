package com.example.SpringbootProject.DTO;

import com.example.SpringbootProject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {
    private String title;
    private String content;

   //1.Dto를 변환 Entity!
    public Article toEntity() {
        return new Article(null,title,content);
    }
}
