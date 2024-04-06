package com.orange.subject.domain.service;

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
     * @return
     */
    void add(SubjectInfoBO subjectInfoBO);


}
