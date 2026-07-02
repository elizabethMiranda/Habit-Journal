package com.habitjournal.habit_journal_api.model;

import lombok.Data;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="habits")
public class Habit {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;

    @OneToMany(mappedBy = "habit", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<LogEntry> logEntries=new ArrayList<>();
}
