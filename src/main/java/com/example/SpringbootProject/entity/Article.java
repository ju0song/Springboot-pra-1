package com.example.SpringbootProject.entity;

import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity //db가 해당 객체를 인식 가능!
@RequiredArgsConstructor
public class Article {

    @Id //대표값을 지정
    @GeneratedValue //1,2,3,...자동생성하게해주는 어노테이션
    private Long id;



    @Column
    private String title;

    public Article(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    private String content;



    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }


    public Long getId() {
        return  id;
    }
}
