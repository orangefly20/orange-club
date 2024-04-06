package com.orange.subject.domain.entity;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 题目DTO
 *
 * @author makejava
 * @since 2024-04-06 17:15:04
 */
@Data
public class SubjectInfoBO implements Serializable {
    private static final long serialVersionUID = 704758617868486062L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 题目名称
     */
    private String subjectName;
    /**
     * 题目难度
     */
    private Integer subjectDifficult;
    /**
     * 出题人名
     */
    private String settleName;
    /**
     * 题目类型 1单选 2多选 3判断 4简答
     */
    private Integer subjectType;
    /**
     * 题目分数
     */
    private Integer subjectScore;
    /**
     * 题目解析
     */
    private String subjectParse;
    /**
     * 题目答案
     */
    private String subjectAnswer;
    /**
     * 分类id
     */
    private List<Integer> categoryIds;
    /**
     * 标签id
     */
    private List<Integer> labelIds;
    /**
     * 答案选项
     */
    private List<SubjectAnswerBO> optionList;


}

