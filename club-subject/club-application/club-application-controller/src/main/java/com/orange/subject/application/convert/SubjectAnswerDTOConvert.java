package com.orange.subject.application.convert;


import com.orange.subject.application.dto.SubjectAnswerDTO;
import com.orange.subject.application.dto.SubjectInfoDTO;
import com.orange.subject.domain.entity.SubjectAnswerBO;
import com.orange.subject.domain.entity.SubjectInfoBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectAnswerDTOConvert {

    SubjectAnswerDTOConvert INSTANCE= Mappers.getMapper(SubjectAnswerDTOConvert.class);

    SubjectAnswerBO convertDTOToBO(SubjectAnswerDTO subjectAnswerDTO);

    List<SubjectAnswerBO> convertListDTOToBO(List<SubjectAnswerDTO> subjectAnswerDTO);

}
