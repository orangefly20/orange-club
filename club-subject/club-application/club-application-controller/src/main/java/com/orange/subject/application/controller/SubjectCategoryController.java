package com.orange.subject.application.controller;


import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.orange.subject.application.convert.SubjectCategoryDTOConvert;
import com.orange.subject.application.dto.SubjectCategoryDTO;
import com.orange.subject.common.entity.Result;
import com.orange.subject.domain.entity.SubjectCategoryBO;
import com.orange.subject.domain.service.SubjectCategoryDomainService;
import com.orange.subject.infra.basic.entity.SubjectCategory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 刷题分类模块Controller
 *
 */


@RestController
@RequestMapping("/subject/category")
@Slf4j
public class SubjectCategoryController {

    @Resource
    private SubjectCategoryDomainService subjectCategoryDomainService;

    /**
     * 新增分类
     * @param subjectCategoryDTO
     * @return
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectCategoryDTO subjectCategoryDTO){
        try {
            if(log.isInfoEnabled()){
                log.info("SubjectCategoryController.add.dto:{}", JSON.toJSONString(subjectCategoryDTO));
            }
            //入参校验
            Preconditions.checkNotNull(subjectCategoryDTO.getCategoryType(),"分类类型不能为空");
            Preconditions.checkArgument(!StringUtils.isBlank(subjectCategoryDTO.getCategoryName()),"分类名不能为空");
            Preconditions.checkNotNull(subjectCategoryDTO.getParentId(),"分类父ID不能为空");

            SubjectCategoryBO subjectCategoryBO= SubjectCategoryDTOConvert.INSTANCE.convertBoToCategory(subjectCategoryDTO);
            subjectCategoryDomainService.add(subjectCategoryBO);
            return Result.ok(true);
        } catch (Exception e) {
            log.error("SubjectCategoryController.add.error:{}",e.getMessage(),e);
            return Result.fail(e.getMessage());
        }
    }

    /**
     * 查询大类分类
     * @return
     */
    @PostMapping("/queryPrimaryCategory")
    public Result<List<SubjectCategoryDTO>> queryPrimaryCategory(@RequestBody SubjectCategoryDTO subjectCategoryDTO){
        try {
            SubjectCategoryBO subjectCategoryBO=SubjectCategoryDTOConvert.INSTANCE.
                    convertDtoToCategoryBO(subjectCategoryDTO);
            List<SubjectCategoryBO> subjectCategoryBOList= subjectCategoryDomainService.queryCategory(subjectCategoryBO);
            List<SubjectCategoryDTO> subjectCategoryDTOList=SubjectCategoryDTOConvert.INSTANCE.convertBoToCategoryDTOList(subjectCategoryBOList);
            return Result.ok(subjectCategoryDTOList);
        }catch (Exception e){
            log.error("SubjectCategoryController.queryPrimaryCategory.error:{}",e.getMessage(),e);
            return Result.fail("查询失败");
        }

    }

    /**
     * 根据父类Id查询分类
     * @param subjectCategoryDTO
     * @return
     */
    @PostMapping("/queryCategoryByPrimary")
    public Result<List<SubjectCategoryDTO>> queryCategoryByPrimary(@RequestBody SubjectCategoryDTO subjectCategoryDTO){
        try {

            if(log.isInfoEnabled()){
                log.info("SubjectCategoryController.queryCategoryByPrimary.dto:{}",JSON.toJSONString(subjectCategoryDTO));
            }
            Preconditions.checkNotNull(subjectCategoryDTO.getParentId(),"分类Id不能为空");
            SubjectCategoryBO subjectCategoryBO=SubjectCategoryDTOConvert.INSTANCE.
                    convertDtoToCategoryBO(subjectCategoryDTO);
            List<SubjectCategoryBO> subjectCategoryBOList= subjectCategoryDomainService.queryCategory(subjectCategoryBO);
            List<SubjectCategoryDTO> subjectCategoryDTOList=SubjectCategoryDTOConvert.INSTANCE.convertBoToCategoryDTOList(subjectCategoryBOList);
            return Result.ok(subjectCategoryDTOList);
        }catch (Exception e){
            log.error("SubjectCategoryController.queryPrimaryCategory.error:{}",e.getMessage(),e);
            return Result.fail("查询失败");
        }

    }

    /**
     * 更新分类
     * @param subjectCategoryDTO
     * @return
     */
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody SubjectCategoryDTO subjectCategoryDTO){
        try {

            if(log.isInfoEnabled()){
                log.info("SubjectCategoryController.update.dto:{}",JSON.toJSONString(subjectCategoryDTO));
            }

            SubjectCategoryBO subjectCategoryBO=SubjectCategoryDTOConvert.INSTANCE.
                    convertDtoToCategoryBO(subjectCategoryDTO);
            Boolean result = subjectCategoryDomainService.update(subjectCategoryBO);

            return Result.ok(result);
        }catch (Exception e){
            log.error("SubjectCategoryController.update.error:{}",e.getMessage(),e);
            return Result.fail("更新分类失败");
        }

    }

    /**
     * 删除分类
     * @param subjectCategoryDTO
     * @return
     */
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestBody SubjectCategoryDTO subjectCategoryDTO){
        try {

            if(log.isInfoEnabled()){
                log.info("SubjectCategoryController.delete.dto:{}",JSON.toJSONString(subjectCategoryDTO));
            }

            SubjectCategoryBO subjectCategoryBO=SubjectCategoryDTOConvert.INSTANCE.
                    convertDtoToCategoryBO(subjectCategoryDTO);
            Boolean result = subjectCategoryDomainService.delete(subjectCategoryBO);

            return Result.ok(result);
        }catch (Exception e){
            log.error("SubjectCategoryController.delete.error:{}",e.getMessage(),e);
            return Result.fail("更新分类失败");
        }

    }
}
