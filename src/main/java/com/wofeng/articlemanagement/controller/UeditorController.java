package com.wofeng.articlemanagement.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baidu.ueditor.ActionEnter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cn on 2018/4/22.
 */
@RestController
@Slf4j
@RequestMapping("baidueditor")
public class UeditorController {

    @Autowired
    private Environment environment;

    //@Autowired
    //private GridFsTemplate fsTemplate;

    /**
     * 百度编辑器 读取附件配置
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "ueditorconfig", method = RequestMethod.GET)
    public JSONObject getUeditorConfig(HttpServletRequest request, HttpServletResponse response, String action) {
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        log.debug("ueditorconfig.rootPath = {}", rootPath);
        ActionEnter actionEnter = new ActionEnter(request, rootPath);
        return JSON.parseObject(actionEnter.exec());
    }

    /**
     * 附件、图片保存
     *
     * @param upfile
     * @param request
     * @return
     */
    @RequestMapping(value = "ueditorconfig", method = RequestMethod.POST)
    public Map<String, Object> dispatch(MultipartFile upfile, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        if (upfile == null) {
            return null;
        }
        try {
            String fileName = upfile.getOriginalFilename();
            //获取扩展名
            String suffix = fileName.substring(fileName.lastIndexOf("."));
            if (!StringUtils.isEmpty(fileName)) {
                fileName = new Date().getTime() + suffix;
            }
            map.put("title", fileName);
            String fileImagePath = environment.getProperty("api.fileImagePath");
            //保存路径
            upfile.transferTo(new File(fileImagePath + fileName));
            Thread.sleep(3000);
            map.put("state", "SUCCESS");
            String baseUrl = environment.getProperty("api.netimagePath");
            map.put("url", baseUrl + fileName);
            map.put("size", upfile.getSize());
            map.put("original", fileName);
            map.put("type", upfile.getContentType());
        } catch (Exception e) {
            log.error("附件保存失败", e);
            map.put("state", "FAIL");
        }
        return map;
    }

   /* @RequestMapping(value = "ueditorconfig", method = RequestMethod.POST)
    public Map<String, Object> dispatch(MultipartFile upfile, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        if (upfile == null) {
            return null;
        }
        try {
            String fileName = upfile.getOriginalFilename();
            //获取扩展名
            String suffix = fileName.substring(fileName.lastIndexOf("."));
            if (!StringUtils.isEmpty(fileName)) {
                fileName = new Date().getTime() + suffix;
            }
            map.put("title", fileName);
            //保存文件
            String fileId = "";
            String serverImgFront = "";

            fileId= this.saveImg(upfile);
            String contextPath = request.getContextPath();
            serverImgFront= environment.getProperty("api.domain")+"/api/img/show?id=" + fileId;

            map.put("state", "SUCCESS");
            map.put("url",serverImgFront);
            map.put("size", upfile.getSize());
            map.put("original", fileName);
            map.put("type", upfile.getContentType());
        } catch (Exception e) {
            log.error("附件保存失败", e);
            map.put("state", "FAIL");
        }
        return map;
    }*/

    /**
     * 保存文件
     * @param image_data
     * @return mongdb中的id
     * @throws Exception
     */
    /*private String saveImg(MultipartFile image_data) throws Exception{
        //获取文件全名
        String fileName = image_data.getOriginalFilename();
        //获取前缀
        String prefix = fileName.substring(0, fileName.lastIndexOf("."));
        //加入时间戳
        prefix += "-" + ZonedDateTime.now().toInstant().toEpochMilli();
        //获取扩展名
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        //设置新名称
        String newFileName = prefix + suffix;
        //保存文件
        GridFSFile gridFSFile = fsTemplate.store(image_data.getInputStream(), newFileName, image_data.getContentType());
        //校验文件
        gridFSFile.validate();
        String serverImgId = gridFSFile.getId().toString();
        return serverImgId;
    }*/
}
