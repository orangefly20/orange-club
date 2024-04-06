package com.orange.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.orange.subject.common.enums.IsDeletedFlagEnum;
import com.orange.subject.domain.convert.SubjectCategoryConverter;
import com.orange.subject.domain.convert.SubjectLabelConverter;
import com.orange.subject.domain.entity.SubjectCategoryBO;
import com.orange.subject.domain.entity.SubjectLabelBO;
import com.orange.subject.domain.service.SubjectCategoryDomainService;
import com.orange.subject.domain.service.SubjectLabelDomainService;
import com.orange.subject.infra.basic.entity.SubjectCategory;
import com.orange.subject.infra.basic.entity.SubjectLabel;
import com.orange.subject.infra.basic.entity.SubjectMapping;
import com.orange.subject.infra.basic.service.SubjectCategoryService;
import com.orange.subject.infra.basic.service.SubjectLabelService;
import com.orange.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SubjectLabelDomainServiceImpl implements SubjectLabelDomainService {

    @Resource
    private SubjectLabelService subjectLabelService;
    @Resource
    private SubjectMappingService subjectMappingService;


    @Override
    public Boolean add(SubjectLabelBO subjectLabelBO) {
        if(log.isInfoEnabled()){
            log.info("SubjectLabelDomainServiceImpl.add.bo:{}",JSON.toJSONString(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.
                convertBoToLabel(subjectLabelBO);
        subjectLabel.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
       int count = subjectLabelService.insert(subjectLabel);
       return count>0;
    }

    @Override
    public Boolean update(SubjectLabelBO subjectLabelBO) {
        if(log.isInfoEnabled()){
            log.info("SubjectLabelDomainServiceImpl.update.bo:{}",JSON.toJSONString(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.
                convertBoToLabel(subjectLabelBO);
        int count = subjectLabelService.update(subjectLabel);
        return count>0;
    }

    @Override
    public Boolean delete(SubjectLabelBO subjectLabelBO) {
        if(log.isInfoEnabled()){
            log.info("SubjectLabelDomainServiceImpl.delete.bo:{}",JSON.toJSONString(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.
                convertBoToLabel(subjectLabelBO);
        subjectLabel.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        int count = subjectLabelService.update(subjectLabel);
        return count>0;
    }

    @Override
    public List<SubjectLabelBO> queryLabelByCategoryId(SubjectLabelBO subjectLabelBO) {
        Long categoryId = subjectLabelBO.getCategoryId();
        SubjectMapping subjectMapping=new SubjectMapping();
        subjectMapping.setCategoryId(categoryId);
        subjectMapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectMapping> subjectMappingList = subjectMappingService.queryLabelId(subjectMapping);
        if(CollectionUtils.isEmpty(subjectMappingList)){
            return Collections.emptyList();
        }
        List<Long> labelIdList = subjectMappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());
        List<SubjectLabel> labelList = subjectLabelService.batchQueryById(labelIdList);
        List<SubjectLabelBO> boList = new LinkedList<>();
        labelList.forEach(label->{
            SubjectLabelBO bo=new SubjectLabelBO();
            bo.setId(label.getId());
            bo.setLabelName(label.getLabelName());
            bo.setCategoryId(categoryId);
            bo.setSortNum(label.getSortNum());
            boList.add(bo);
        });
        return boList;
    }
}
