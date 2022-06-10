package com.example.SpringbootProject.Controller;

import com.example.SpringbootProject.DTO.ArticleForm;
import com.example.SpringbootProject.entity.Article;
import com.example.SpringbootProject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        // 리다이렉트 적용
        return "redirect:/articles/" + saved.getId();


    }

    //1,url요청하기

    @GetMapping("articles/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id = " + id);
        //1.id로 데이터로 가져옴
        Article articleEntity =articleRepository.findById(id).orElse(null);

        //2.가져온 데이터를 모델에 등록
        model.addAttribute("article",articleEntity);

        //3.보여줄 페이지를 설정!
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model){
        //1.모든 아티클을 가져온다
        List<Article> articleEntityList= articleRepository.findAll();

        // 2.가져온 Article 묶음을 뷰로 가져온다
        model.addAttribute("articleList",articleEntityList);
        return "articles/index";
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id,Model model){
        //수정할 데이터를 가져오기!
        Article articleEntity=articleRepository.findById(id).orElse(null);
        //모델에 데이터를 등록!
        model.addAttribute("article",articleEntity);
        //  뷰페이지 설정
        return "articles/edit";

    }
    @PostMapping("/articles/update")
    public String update(ArticleForm form){
        log.info(form.toString());

        //1.dto를 엔티티로 변환한다
        Article articleEntity =form.toEntity();
        log.info(articleEntity.toString());

        //2.엔티티를 DB로 저장한다
        //2-1: DB에 기존데이터를 가져온다
        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);
        //2-2:기존 데이터가있다면 값을 갱신한다.
        if (target != null) {
            articleRepository.save(articleEntity); //엔티티가 DB로 갱신된다
        }

       // 3.수정 결과 페이지로 리다이렉트 한다.
        return "";
    }


}
