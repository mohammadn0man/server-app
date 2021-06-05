package com.assignment.serverapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatsDto {
    private long userCount;
    private long questionCount;
    private long responseCount;
}
