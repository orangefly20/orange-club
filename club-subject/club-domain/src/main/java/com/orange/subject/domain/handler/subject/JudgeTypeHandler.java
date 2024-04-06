package com.orange.subject.domain.handler.subject;

import com.orange.subject.common.enums.SubjectInfoTypeEnum;
import com.orange.subject.domain.entity.SubjectInfoBO;
import org.springframework.stereotype.Component;

/**
 * 判断题目的策略类
 */
@Component
public class JudgeTypeHandler implements SubjectTypeHandler{
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.JUDGE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {

    }
}
