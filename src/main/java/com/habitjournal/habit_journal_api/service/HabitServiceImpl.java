package com.habitjournal.habit_journal_api.service;

import com.habitjournal.habit_journal_api.controller.dto.HabitRequestDTO;
import com.habitjournal.habit_journal_api.controller.dto.HabitResponseDTO;
import com.habitjournal.habit_journal_api.controller.dto.resultDTO;

import java.util.List;

public interface HabitServiceImpl {

    HabitResponseDTO createNewHabit(HabitRequestDTO habitRequestDTO);
    List<HabitResponseDTO> findAllHabits();
    public resultDTO getMaxLongToSubstring(String data);


}
