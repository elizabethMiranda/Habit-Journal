package com.habitjournal.habit_journal_api.exceptions;

public class DuplicatedHabitException extends RuntimeException {

    public DuplicatedHabitException(String message) {
        super(message);
    }
}
