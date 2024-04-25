package com.orange.subject.application.convert;


import com.orange.subject.application.dto.SubjectAnswerDTO;
import com.orange.subject.domain.entity.SubjectAnswerBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
/**
 * 题目答案dto转换器
 *
 */
@Mapper
public interface SubjectAnswerDTOConverter {

    SubjectAnswerDTOConverter INSTANCE= Mappers.getMapper(SubjectAnswerDTOConverter.class);

    SubjectAnswerBO convertDTOToBO(SubjectAnswerDTO subjectAnswerDTO);

    List<SubjectAnswerBO> convertListDTOToBO(List<SubjectAnswerDTO> subjectAnswerDTO);

}
