package com.orange.subject.domain.convert;

import com.orange.subject.domain.entity.SubjectAnswerBO;
import com.orange.subject.domain.entity.SubjectCategoryBO;
import com.orange.subject.infra.basic.entity.SubjectCategory;
import com.orange.subject.infra.basic.entity.SubjectRadio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RadioSubjectConverter {

    RadioSubjectConverter INSTANCE= Mappers.getMapper(RadioSubjectConverter.class);

    SubjectRadio convertBoToEntity(SubjectAnswerBO subjectAnswerBO);


}
