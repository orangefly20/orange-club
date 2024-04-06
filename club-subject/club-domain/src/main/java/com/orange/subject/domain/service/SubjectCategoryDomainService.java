package com.orange.subject.domain.service;

import com.orange.subject.domain.entity.SubjectCategoryBO;
import com.orange.subject.infra.basic.entity.SubjectCategory;

import java.util.List;

public interface SubjectCategoryDomainService {

    /**
     * 新增分类
     * @return
     */
    void add(SubjectCategoryBO subjectCategoryBO);

    /**
     * 查询分类大类
     * @return
     */
    List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO);

    /**
     * 更新分类
     * @return
     */
    Boolean update(SubjectCategoryBO subjectCategoryBO);

    /**
     * 删除分类
     * @return
     */
    Boolean delete(SubjectCategoryBO subjectCategoryBO);

}
