package com.wofeng.articlemanagement.service.impl;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wofeng.articlemanagement.ArticleManagementApplication;
import com.wofeng.articlemanagement.baseDao.BusinessMessage;
import com.wofeng.articlemanagement.entity.Article;
import com.wofeng.articlemanagement.mapper.ArticleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;

/**
 * @author yueyueyue
 * @date 2019/4/22 13:59
 * Description: article-management
 */
@Slf4j
@Service
public class ArticleServiceImpl {

    @Autowired
    private ArticleMapper articleMapper;

    public BusinessMessage<List> getAll(){
        BusinessMessage<List> businessMessage = new BusinessMessage<>();
        try {

            List articleList = this.articleMapper.selectAll();
            if (articleList.size() >0) {
                businessMessage.setSuccess(true);
                businessMessage.setData(articleList);
                businessMessage.setMsg("查询成功");
            }else {
                businessMessage.setSuccess(false);
                businessMessage.setMsg("查询无数据");
            }

        }catch(Exception e) {
            log.error("查询失败:{}"+e);
            businessMessage.setSuccess(false);
            businessMessage.setMsg("查询失败");
        }
        return businessMessage;
    }

    public BusinessMessage save(Article article) {
        BusinessMessage businessMessage = new BusinessMessage();
        try {

            int i = this.articleMapper.insert(article);
            if (i >0) {
                businessMessage.setSuccess(true);
                businessMessage.setMsg("保存成功");
            }else {
                businessMessage.setSuccess(false);
                businessMessage.setMsg("保存失败");
            }

        }catch(Exception e) {
            log.error("保存失败:{}"+e);
            businessMessage.setSuccess(false);
            businessMessage.setMsg("保存失败");
        }
        return businessMessage;
    }

    public BusinessMessage selectById(int id) {
        BusinessMessage businessMessage = new BusinessMessage();
        try {
            Article article = this.articleMapper.selectByPrimaryKey(id);
            if (article != null) {
                businessMessage.setSuccess(true);
                businessMessage.setMsg("查询成功");
                businessMessage.setData(article);
            }else {
                businessMessage.setSuccess(false);
                businessMessage.setMsg("查询无数据");
            }
        }catch (Exception e ){
            log.error("查询失败:{}"+e);
            businessMessage.setSuccess(false);
            businessMessage.setMsg("查询失败");
        }
        return businessMessage;
    }

    public BusinessMessage edit(Article article) {
        BusinessMessage businessMessage = new BusinessMessage();
        try {
            int i = this.articleMapper.updateByPrimaryKeySelective(article);
            if (i >0) {
                businessMessage.setSuccess(true);
                businessMessage.setMsg("修改成功");
            }else {
                businessMessage.setSuccess(false);
                businessMessage.setMsg("修改失败");
            }
        }catch (Exception e){
            log.error("修改失败:{}"+e);
            businessMessage.setSuccess(false);
            businessMessage.setMsg("修改失败");
        }
        return businessMessage;
    }
}
