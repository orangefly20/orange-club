package com.orange.subject.infra.basic.service;

import com.orange.subject.infra.basic.entity.SubjectMultiple;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 多选题信息表(SubjectMultiple)表服务接口
 *
 * @author makejava
 * @since 2024-04-06 17:16:47
 */
public interface SubjectMultipleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectMultiple queryById(Long id);

    /**
     * 分页查询
     *
     * @param subjectMultiple 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    Page<SubjectMultiple> queryByPage(SubjectMultiple subjectMultiple, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param subjectMultiple 实例对象
     * @return 实例对象
     */
    SubjectMultiple insert(SubjectMultiple subjectMultiple);

    /**
     * 修改数据
     *
     * @param subjectMultiple 实例对象
     * @return 实例对象
     */
    SubjectMultiple update(SubjectMultiple subjectMultiple);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 批量插入
     */
    void batchInsert(List<SubjectMultiple> subjectMultipleList);


    List<SubjectMultiple> queryByCondition(SubjectMultiple subjectJudge);

}
