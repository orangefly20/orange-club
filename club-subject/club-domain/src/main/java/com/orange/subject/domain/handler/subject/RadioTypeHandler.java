package com.orange.subject.domain.handler.subject;

import com.orange.subject.common.enums.SubjectInfoTypeEnum;
import com.orange.subject.domain.convert.RadioSubjectConverter;
import com.orange.subject.domain.entity.SubjectInfoBO;
import com.orange.subject.infra.basic.entity.SubjectRadio;
import com.orange.subject.infra.basic.service.SubjectRadioService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 单选题目的策略类
 */
@Component
public class RadioTypeHandler implements SubjectTypeHandler{

    @Resource
    private SubjectRadioService subjectRadioService;


    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.RADIO;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {

        List<SubjectRadio> subjectRadioList= new LinkedList<>();
        subjectInfoBO.getOptionList().forEach(option->{
            SubjectRadio subjectRadio = RadioSubjectConverter.INSTANCE.convertBoToEntity(option);
            subjectRadio.setSubjectId(subjectInfoBO.getId());
            subjectRadioList.add(subjectRadio);
        });
        subjectRadioService.batchInsert(subjectRadioList);
    }
}
