package com.habitjournal.habit_journal_api.service;

import com.habitjournal.habit_journal_api.controller.dto.HabitRequestDTO;
import com.habitjournal.habit_journal_api.controller.dto.HabitResponseDTO;

import java.util.List;

public interface HabitServiceImpl {

    public void createNewHabit(HabitRequestDTO habitRequestDTO);
    List<HabitResponseDTO> findAllHabits();


}
