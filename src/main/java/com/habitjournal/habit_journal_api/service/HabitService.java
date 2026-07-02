package com.habitjournal.habit_journal_api.service;

import com.habitjournal.habit_journal_api.repository.HabitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HabitService {

    private final HabitRepository habitRepository;

}
