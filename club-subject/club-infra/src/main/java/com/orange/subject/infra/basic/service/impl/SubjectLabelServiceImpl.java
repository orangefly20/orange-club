package com.orange.subject.infra.basic.service.impl;

import com.orange.subject.infra.basic.entity.SubjectLabel;
import com.orange.subject.infra.basic.mapper.SubjectLabelDao;
import com.orange.subject.infra.basic.service.SubjectLabelService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

/**
 * 题目标签表(SubjectLabel)表服务实现类
 *
 * @author makejava
 * @since 2024-04-04 21:38:22
 */
@Service("subjectLabelService")
public class SubjectLabelServiceImpl implements SubjectLabelService {
    @Resource
    private SubjectLabelDao subjectLabelDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectLabel queryById(Long id) {
        return this.subjectLabelDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param subjectLabel 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @Override
//    public Page<SubjectLabel> queryByPage(SubjectLabel subjectLabel) {
//        long total = this.subjectLabelDao.count(subjectLabel);
//        return new PageImpl<>(this.subjectLabelDao.queryAllByLimit(subjectLabel),  total);
//    }

    /**
     * 新增数据
     *
     * @param subjectLabel 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(SubjectLabel subjectLabel) {
       return this.subjectLabelDao.insert(subjectLabel);
    }

    /**
     * 修改数据
     *
     * @param subjectLabel 实例对象
     * @return 实例对象
     */
    @Override
    public int update(SubjectLabel subjectLabel) {
       return this.subjectLabelDao.update(subjectLabel);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectLabelDao.deleteById(id) > 0;
    }

    @Override
    public List<SubjectLabel> batchQueryById(List<Long> labelIdList) {
        return this.subjectLabelDao.batchQueryById(labelIdList);
    }

    @Override
    public List<SubjectLabel> queryByCondition(SubjectLabel subjectLabel) {
        return this.subjectLabelDao.queryByCondition(subjectLabel);
    }

}