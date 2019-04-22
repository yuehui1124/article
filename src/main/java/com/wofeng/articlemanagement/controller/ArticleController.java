package com.wofeng.articlemanagement.controller;

import com.wofeng.articlemanagement.baseDao.BusinessMessage;
import com.wofeng.articlemanagement.entity.Article;
import com.wofeng.articlemanagement.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yueyueyue
 * @date 2019/4/22 13:56
 * Description: article-management
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleServiceImpl articleService;

    @GetMapping("/getAll")
    public BusinessMessage<List> getAll() {
        return this.articleService.getAll();
    }

    @PostMapping("/save")
    public BusinessMessage save(Article article) {
        return this.articleService.save(article);
    }

    @GetMapping("selectById")
    public BusinessMessage selectById(int id) {
        return this.articleService.selectById(id);
    }

    @PostMapping("/edit")
    public BusinessMessage edit(Article article) {
        return this.articleService.edit(article);
    }
}
