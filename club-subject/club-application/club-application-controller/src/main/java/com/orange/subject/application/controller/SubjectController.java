package com.orange.subject.application.controller;


import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.orange.subject.application.convert.SubjectAnswerDTOConvert;
import com.orange.subject.application.convert.SubjectCategoryDTOConvert;
import com.orange.subject.application.convert.SubjectInfoDTOConvert;
import com.orange.subject.application.dto.SubjectInfoDTO;
import com.orange.subject.common.entity.Result;

import com.orange.subject.domain.convert.SubjectInfoConverter;
import com.orange.subject.domain.entity.SubjectAnswerBO;
import com.orange.subject.domain.entity.SubjectInfoBO;
import com.orange.subject.domain.service.SubjectInfoDomainService;
import com.orange.subject.infra.basic.service.SubjectCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

//刷题Controller

@RestController
@Slf4j
public class SubjectController {

    @Resource
    private SubjectInfoDomainService subjectInfoDomainService;

    /**
     * 新增题目
     * @param subjectInfoDTO
     * @return
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectInfoDTO subjectInfoDTO){
        try {
            if(log.isInfoEnabled()){
                log.info("SubjectController.add.dto:{}", JSON.toJSONString(subjectInfoDTO));
            }
            //入参校验
            Preconditions.checkArgument(!StringUtils.isBlank(subjectInfoDTO.getSubjectName()),"题目名称不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectDifficult(),"题目难度不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectType(),"题目类型不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectScore(),"题目分数不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectType(),"题目分类不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getCategoryIds()),"分类id不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getLabelIds()),"标签id不能为空");

            SubjectInfoBO subjectInfoBO= SubjectInfoDTOConvert.INSTANCE.convertDTOToBO(subjectInfoDTO);
            List<SubjectAnswerBO> subjectAnswerBOS = SubjectAnswerDTOConvert.INSTANCE.convertListDTOToBO(subjectInfoDTO.getOptionList());
            subjectInfoBO.setOptionList(subjectAnswerBOS);

            subjectInfoDomainService.add(subjectInfoBO);
            return Result.ok(true);
        } catch (Exception e) {
            log.error("SubjectController.add.error:{}",e.getMessage(),e);
            return Result.fail("新增题目失败");
        }
    }
}
