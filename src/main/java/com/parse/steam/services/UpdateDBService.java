package com.parse.steam.services;

import com.parse.steam.dtos.OutputItemDto;
import com.parse.steam.entities.MonitorStatEntity;
import com.parse.steam.repo.MonitorStatRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
@RequiredArgsConstructor
public class UpdateDBService {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final MonitorStatRepo monitorStatRepo;

    public void insertToDB(OutputItemDto dto) {
        MonitorStatEntity entity = new MonitorStatEntity();
        entity.setMonitorMarketId(dto.getId());
        entity.setMoment(LocalDateTime.parse(dto.getTimeChecking(), formatter));
        entity.setPrice(dto.getPrice());
        monitorStatRepo.save(entity);
    }
}
