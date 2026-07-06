package com.habitjournal.habit_journal_api.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class resultDTO {

    private List<String> substrings;
    private List<Integer> longSubstring;

}
