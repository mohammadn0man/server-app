package com.assignment.serverapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LikeReplyDto {
    private int likeId;
    private int userId;
    private int replyId;
}
