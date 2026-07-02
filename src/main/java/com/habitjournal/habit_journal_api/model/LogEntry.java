package com.habitjournal.habit_journal_api.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import lombok.Data;



@Data
@Entity
@Table(name="log_entries")
public class LogEntry {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime entryDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="habit_id")
    private Habit habit;

}
