package com.orange.subject.application.controller;


import com.alibaba.fastjson.JSON;
import com.orange.subject.infra.basic.entity.SubjectCategory;
import com.orange.subject.infra.basic.service.SubjectCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

//刷题Controller

@RestController
@Slf4j
public class SubjectController {

    @Resource
    private SubjectCategoryService subjectCategoryService;

    @GetMapping("test")
    public String test(){

        SubjectCategory subjectCategory=subjectCategoryService.queryById(1L);
        return subjectCategory.getCategoryName();
    }
}
