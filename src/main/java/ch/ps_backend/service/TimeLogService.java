package ch.ps_backend.service;

import ch.ps_backend.dto.TimeLogDto;
import ch.ps_backend.mapper.TimeLogMapper;
import ch.ps_backend.repository.TimeLogRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeLogService {

    private final TimeLogRepository timeLogRepository;
    private final TimeLogMapper timeLogMapper;

    public TimeLogService(TimeLogRepository timeLogRepository, TimeLogMapper timeLogMapper) {
        this.timeLogRepository = timeLogRepository;
        this.timeLogMapper = timeLogMapper;
    }

    public List<TimeLogDto> getAll() {
        List<TimeLogDto> tempTimeLog = new ArrayList<>();
        timeLogRepository.findAll().forEach(timeLog -> {
            tempTimeLog.add(timeLogMapper.ToDTO(timeLog));
        });
        return tempTimeLog;
    }

    public TimeLogDto getById(int id) {
        return timeLogMapper.ToDTO(timeLogRepository.getById(id));
    }

    public void createOrUpdateTimeLog(TimeLogDto timeLogDto) {
        timeLogRepository.save(timeLogMapper.FromDTO(timeLogDto));
    }

    public void deleteById(int id) {
        timeLogRepository.deleteById(id);
    }
}
