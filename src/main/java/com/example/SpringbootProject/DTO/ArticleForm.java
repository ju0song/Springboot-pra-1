package com.example.SpringbootProject.DTO;

import com.example.SpringbootProject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {
    private Long id; //id 필드 추가
    private String title;
    private String content;

   //1.Dto를 변환 Entity!
    public Article toEntity()
    {
        return new Article(id,title,content);
    }
}
