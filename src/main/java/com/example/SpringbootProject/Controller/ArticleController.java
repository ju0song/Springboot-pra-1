package com.example.SpringbootProject.Controller;

import com.example.SpringbootProject.DTO.ArticleForm;
import com.example.SpringbootProject.entity.Article;
import com.example.SpringbootProject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j //로깅을 위한 골뱅이(어노테이션)
public class ArticleController {
    @Autowired //스프링부트가 미리 생성해놓은 객체를 가져다가 자동 연결!
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleController(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
//        System.out.println(form.toString()); ->로깅 기능으로 대체
        log.info(form.toString());
        
        //1.dto를 변환 enrity로 변환(form데이터를 entity로 변환)
        Article article = form.toEntity();
//        System.out.println(article.toString());
        log.info(article.toString());

        //2. Repository에게 Entity를 DB안에 저장하게 한다.
        Article saved = articleRepository.save(article);
//        System.out.println(saved.toString());
        log.info(saved.toString());
        return "";
    }
}
