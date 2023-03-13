package ch.ps_backend.service;

import ch.ps_backend.dto.EmotionLogDto;
import ch.ps_backend.mapper.EmotionLogMapper;
import ch.ps_backend.repository.EmotionLogRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmotionLogService {

    private final EmotionLogRepository emotionLogRepository;
    private final EmotionLogMapper emotionLogMapper;

    public EmotionLogService(EmotionLogRepository emotionLogRepository, EmotionLogMapper emotionLogMapper) {
        this.emotionLogRepository = emotionLogRepository;
        this.emotionLogMapper = emotionLogMapper;
    }

    public List<EmotionLogDto> getAll() {
        List<EmotionLogDto> tempEmotionLog = new ArrayList<>();
        emotionLogRepository.findAll().forEach(emotionLog -> {
            tempEmotionLog.add(emotionLogMapper.ToDTO(emotionLog));
        });
        return tempEmotionLog;
    }

    public EmotionLogDto getById(int id) {
        return emotionLogMapper.ToDTO(emotionLogRepository.getById(id));
    }

    public void createOrUpdateEmotionLog(EmotionLogDto emotionLogDto) {
        emotionLogRepository.save(emotionLogMapper.FromDTO(emotionLogDto));
    }

    public void deleteById(int id) {
        emotionLogRepository.deleteById(id);
    }
}
