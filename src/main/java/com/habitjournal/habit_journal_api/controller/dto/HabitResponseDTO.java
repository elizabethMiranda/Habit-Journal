package com.habitjournal.habit_journal_api.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class HabitResponseDTO {

    private Long Id;
    private String name;
    private List<LocalDateTime> logs;

}
