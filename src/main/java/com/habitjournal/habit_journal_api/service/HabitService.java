package com.habitjournal.habit_journal_api.service;

import com.habitjournal.habit_journal_api.controller.dto.HabitRequestDTO;
import com.habitjournal.habit_journal_api.controller.dto.HabitResponseDTO;
import com.habitjournal.habit_journal_api.controller.dto.resultDTO;
import com.habitjournal.habit_journal_api.exceptions.DuplicatedHabitException;
import com.habitjournal.habit_journal_api.model.Habit;
import com.habitjournal.habit_journal_api.model.LogEntry;
import com.habitjournal.habit_journal_api.repository.HabitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HabitService implements HabitServiceImpl{

    private final HabitRepository habitRepository;

    @Override
    public HabitResponseDTO createNewHabit(HabitRequestDTO habitRequestDTO) {

        habitRepository.findByName(habitRequestDTO.getName()).ifPresent(habit -> {
            throw new DuplicatedHabitException("Habit already exists");
        });


        Habit habit = new Habit();
        habit.setName(habitRequestDTO.getName());
        if(habitRequestDTO.getLogs() != null) {
        System.out.println("Insertando registros");
            habitRequestDTO.getLogs().forEach(fecha -> {
                System.out.println(fecha.toString());
                LogEntry logEntry = new LogEntry();
                logEntry.setEntryDate(fecha);
                logEntry.setHabit(habit);
                habit.getLogEntries().add(logEntry);
            });
        }
        System.out.println("servicio: Mapeando de DTO a Habit");
        System.out.println("Habito ingresado correctamente");
        Habit result = habitRepository.save(habit);
        return new HabitResponseDTO(result.getId(), result.getName(),habitRequestDTO.getLogs());


    }

    @Override
    public List<HabitResponseDTO> findAllHabits() {
        List<Habit> habits = habitRepository.findAllWithLogs();
        //return habits.

        return habits.stream().map(
                habit -> {
                    List<LocalDateTime> logDates = habit.getLogEntries().stream()
                            .map(LogEntry::getEntryDate).toList();
                    return new HabitResponseDTO(habit.getId(), habit.getName(), logDates);
                })
                .toList();
    }

    @Override
    public resultDTO getMaxLongToSubstring(String data) {
        int longSubstring = data.length();
        int maxLogSubstring =0;
        int left=0;
        int rigth=0;
        List<Integer> maxlong = new ArrayList<>();
        List<String> values = new ArrayList<>();
        String window = "";
        for(int i=0;i<longSubstring;i++) {
            char ch = data.charAt(i);
            if(window.indexOf(ch) == -1){
                window += ch;
                maxLogSubstring++;
            }else{
                maxlong.add(maxLogSubstring);
                values.add(window);
                int posicion = window.indexOf(ch);
                System.out.println("palabra repetida: "+ ch + "- en posicion: " + posicion);
                window = window.substring(posicion+1);
                window += ch;
                left++;
            }

            System.out.println("Posicion:" + i + "->" + ch);
            for(int j=0;j<maxlong.size();j++){
                System.out.println(maxlong.get(j));
            }
        }
        resultDTO resultDTO = new resultDTO(values,maxlong);
        return resultDTO;
    }

}
