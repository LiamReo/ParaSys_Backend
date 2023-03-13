package ch.ps_backend.mapper;

import ch.ps_backend.dto.AddictionDto;
import ch.ps_backend.dto.EmotionLogDto;
import ch.ps_backend.model.Addiction;
import ch.ps_backend.model.EmotionLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmotionLogMapper {

    private final TrackerMapper trackerMapper;

    private final EmotionMapper emotionMapper;

    public EmotionLogMapper(EmotionMapper emotionMapper, TrackerMapper trackerMapper) {
        this.emotionMapper = emotionMapper;
        this.trackerMapper = trackerMapper;
    }

    public final EmotionLog FromDTO(EmotionLogDto dto) {
        EmotionLog entity = new EmotionLog();
        entity.setId(dto.getId());
        entity.setEmotion(emotionMapper.FromDTO(dto.getEmotion()));
        entity.setTracker(trackerMapper.FromDTO(dto.getTracker()));
        entity.setDatetime(dto.getDatetime());
        return entity;
    }

    public final EmotionLogDto ToDTO(EmotionLog entity) {
        EmotionLogDto dto = new EmotionLogDto();
        dto.setId(entity.getId());
        dto.setEmotion(emotionMapper.ToDTO(entity.getEmotion()));
        dto.setTracker(trackerMapper.ToDTO(entity.getTracker()));
        dto.setDatetime(entity.getDatetime());
        return dto;
    }
}
