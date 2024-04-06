package com.orange.subject.application.convert;


import com.orange.subject.application.dto.SubjectCategoryDTO;
import com.orange.subject.application.dto.SubjectLabelDTO;
import com.orange.subject.domain.entity.SubjectCategoryBO;
import com.orange.subject.domain.entity.SubjectLabelBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 标签dto的转换
 */
@Mapper
public interface SubjectLabelDTOConvert {

    SubjectLabelDTOConvert INSTANCE= Mappers.getMapper(SubjectLabelDTOConvert.class);


    SubjectLabelBO convertDtoToLabelBO(SubjectLabelDTO subjectLabelDTO);

    List<SubjectLabelDTO> convertBOToLabelDTOList(List<SubjectLabelBO> boList);
}
