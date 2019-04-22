package com.wofeng.articlemanagement.service;

import com.wofeng.articlemanagement.baseDao.BusinessMessage;
import com.wofeng.articlemanagement.entity.Article;

import java.util.List;

/**
 * @author yueyueyue
 * @date 2019/4/22 13:59
 * Description: article-management
 */
public interface ArticleService {

    public BusinessMessage<List> getAll();
}
