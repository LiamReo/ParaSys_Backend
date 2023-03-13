package ch.ps_backend.mapper;

import ch.ps_backend.dto.EmotionLogDto;
import ch.ps_backend.dto.SoberTrackerDto;
import ch.ps_backend.model.EmotionLog;
import ch.ps_backend.model.SoberTracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoberTrackerMapper {

    private final TrackerMapper trackerMapper;

    public SoberTrackerMapper(TrackerMapper trackerMapper) {
        this.trackerMapper = trackerMapper;
    }

    public final SoberTracker FromDTO(SoberTrackerDto dto) {
        SoberTracker entity = new SoberTracker();
        entity.setId(dto.getId());
        entity.setSoberLog(dto.getSoberLog());
        entity.setTracker(trackerMapper.FromDTO(dto.getTracker()));
        entity.setDatetime(dto.getDatetime());
        return entity;
    }

    public final SoberTrackerDto ToDTO(SoberTracker entity) {
        SoberTrackerDto dto = new SoberTrackerDto();
        dto.setId(entity.getId());
        dto.setSoberLog(entity.getSoberLog());
        dto.setTracker(trackerMapper.ToDTO(entity.getTracker()));
        dto.setDatetime(entity.getDatetime());
        return dto;
    }
}
