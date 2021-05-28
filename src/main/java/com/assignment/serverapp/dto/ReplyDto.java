package com.assignment.serverapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDto {
    private int replyId;
    private int questionId;
    private int userId;
    private String text;
}
