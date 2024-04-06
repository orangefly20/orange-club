package com.orange.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.orange.subject.common.enums.IsDeletedFlagEnum;
import com.orange.subject.domain.convert.SubjectCategoryConverter;
import com.orange.subject.domain.entity.SubjectCategoryBO;
import com.orange.subject.domain.service.SubjectCategoryDomainService;
import com.orange.subject.infra.basic.entity.SubjectCategory;
import com.orange.subject.infra.basic.service.SubjectCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.ognl.JavaSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {

    @Resource
    private SubjectCategoryService subjectCategoryService;


    @Override
    public void add(SubjectCategoryBO subjectCategoryBO) {
        if(log.isInfoEnabled()){
            log.info("SubjectCategoryDomainServiceImpl.add.bo:{}",JSON.toJSONString(subjectCategoryBO));
        }
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.
                convertBoToCategory(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectCategoryService.insert(subjectCategory);
    }

    @Override
    public List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory=SubjectCategoryConverter.INSTANCE.
                convertBoToCategory(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectCategory> subjectCategoryList= subjectCategoryService.queryCategory(subjectCategory);
        List<SubjectCategoryBO> boList=SubjectCategoryConverter.INSTANCE.convertBoToCategory(subjectCategoryList);
        if(log.isInfoEnabled()){
            log.info("SubjectCategoryDomainServiceImpl.queryPrimaryCategory.boList:{}", JSON.toJSONString(boList));
        }
        return boList;
    }

    @Override
    public Boolean update(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory=SubjectCategoryConverter.INSTANCE.
                convertBoToCategory(subjectCategoryBO);
        int count=subjectCategoryService.update(subjectCategory);
        return count>0;
    }

    @Override
    public Boolean delete(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory=SubjectCategoryConverter.INSTANCE.
                convertBoToCategory(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        int count=subjectCategoryService.update(subjectCategory);
        return count>0;
    }
}
