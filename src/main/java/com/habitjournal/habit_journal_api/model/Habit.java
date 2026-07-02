package com.habitjournal.habit_journal_api.model;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name="habits")
public class Habit {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
}
