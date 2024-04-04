package com.orange.subject.application.convert;


import com.orange.subject.application.dto.SubjectCategoryDTO;
import com.orange.subject.domain.entity.SubjectCategoryBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectCategoryDTOConvert {

    SubjectCategoryDTOConvert INSTANCE= Mappers.getMapper(SubjectCategoryDTOConvert.class);

    SubjectCategoryBO convertBoToCategory(SubjectCategoryDTO subjectCategoryDTO);

    List<SubjectCategoryDTO> convertBoToCategoryDTOList(List<SubjectCategoryBO> subjectCategoryDTO);

    SubjectCategoryBO convertDtoToCategoryBO(SubjectCategoryDTO subjectCategoryDTO);
}
