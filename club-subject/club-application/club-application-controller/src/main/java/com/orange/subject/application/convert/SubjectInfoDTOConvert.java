package com.orange.subject.application.convert;


import com.orange.subject.application.dto.SubjectCategoryDTO;
import com.orange.subject.application.dto.SubjectInfoDTO;
import com.orange.subject.domain.entity.SubjectCategoryBO;
import com.orange.subject.domain.entity.SubjectInfoBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectInfoDTOConvert {

    SubjectInfoDTOConvert INSTANCE= Mappers.getMapper(SubjectInfoDTOConvert.class);

    SubjectInfoBO convertDTOToBO(SubjectInfoDTO subjectInfoDTO);

}
