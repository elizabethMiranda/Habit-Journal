package com.habitjournal.habit_journal_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.habitjournal.habit_journal_api.model.Habit;


@Repository
public interface HabitRepository extends JpaRepository<Habit, Long> {
}
