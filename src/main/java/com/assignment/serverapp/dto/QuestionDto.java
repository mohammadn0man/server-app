package com.assignment.serverapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {
    private int questionId;
    private int userId;
    private int productId;
    private String title;
    private String subject;
    private String text;
    private int replyCount;
    private Date creationDate;
    private Date closedDate;
    private int acceptedAnswerId;
}
