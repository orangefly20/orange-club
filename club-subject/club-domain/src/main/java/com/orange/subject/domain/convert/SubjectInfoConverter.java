package com.orange.subject.domain.convert;

import com.orange.subject.domain.entity.SubjectCategoryBO;
import com.orange.subject.domain.entity.SubjectInfoBO;
import com.orange.subject.infra.basic.entity.SubjectCategory;
import com.orange.subject.infra.basic.entity.SubjectInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectInfoConverter {

    SubjectInfoConverter INSTANCE= Mappers.getMapper(SubjectInfoConverter.class);

    SubjectInfo convertBOToInfo(SubjectInfoBO subjectInfoBO);


}
