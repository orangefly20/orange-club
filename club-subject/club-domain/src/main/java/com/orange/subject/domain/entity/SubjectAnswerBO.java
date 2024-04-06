package com.orange.subject.domain.entity;


import lombok.Data;

import java.io.Serializable;

/**
 * 题目答案DTO
 *
 * @author makejava
 * @since 2024-04-06 17:15:04
 */
@Data
public class SubjectAnswerBO implements Serializable {
    private static final long serialVersionUID = 704758617868486062L;
    /**
     * 答案选项标识
     */
    private Integer optionType;
    /**
     * 答案
     */
    private String optionContent;
    /**
     * 是否正确
     */
    private Integer isCorrect;



}

