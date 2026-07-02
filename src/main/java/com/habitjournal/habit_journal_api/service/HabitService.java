package com.habitjournal.habit_journal_api.service;

import com.habitjournal.habit_journal_api.controller.dto.HabitRequestDTO;
import com.habitjournal.habit_journal_api.controller.dto.HabitResponseDTO;
import com.habitjournal.habit_journal_api.model.Habit;
import com.habitjournal.habit_journal_api.repository.HabitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HabitService implements HabitServiceImpl{

    private final HabitRepository habitRepository;

    @Override
    public void createNewHabit(HabitRequestDTO habitRequestDTO) {
        if(habitRequestDTO.getName() == null ||  habitRequestDTO.getName().trim().isEmpty()) {
            System.out.println("Error de la logica de negocios");
            return;
        }

        Habit habit = new Habit();
        habit.setName(habitRequestDTO.getName());
        habitRepository.save(habit);
        System.out.println("servicio: Mapeando de DTO a Habit");
        System.out.println("Habito ingresado correctamente");
    }

    @Override
    public List<HabitResponseDTO> findAllHabits() {
        return habitRepository.findAll().stream().map(
                habit -> new HabitResponseDTO(
                        habit.getId(), habit.getName())).toList();
    }

}
