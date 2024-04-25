package com.orange.subject.domain.service;

import com.orange.subject.common.entity.PageResult;
import com.orange.subject.domain.entity.SubjectInfoBO;
import com.orange.subject.domain.entity.SubjectLabelBO;

import java.util.List;

/**
 * 题目标签领域服务
 *
 */
public interface SubjectInfoDomainService {


    /**
     * 新增题目
     */
    void add(SubjectInfoBO subjectInfoBO);

    /**
     * 分页查询
     */
    PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO);

    /**
     * 查询题目信息
     */
    SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO);

    /**
     * 全文检索
     */
//    PageResult<SubjectInfoEs> getSubjectPageBySearch(SubjectInfoBO subjectInfoBO);

//    List<SubjectInfoBO> getContributeList();



}
