package ch.ps_backend.mapper;

import ch.ps_backend.dto.SoberTrackerDto;
import ch.ps_backend.dto.TimeLogDto;
import ch.ps_backend.model.SoberTracker;
import ch.ps_backend.model.TimeLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeLogMapper {

    private final TrackerMapper trackerMapper;

    public TimeLogMapper(TrackerMapper trackerMapper) {
        this.trackerMapper = trackerMapper;
    }

    public final TimeLog FromDTO(TimeLogDto dto) {
        TimeLog entity = new TimeLog();
        entity.setId(dto.getId());
        entity.setStart(dto.getStart());
        entity.setEnd(dto.getEnd());
        entity.setDate(dto.getDate());
        entity.setResult(dto.getResult());
        entity.setTracker(trackerMapper.FromDTO(dto.getTracker()));
        return entity;
    }

    public final TimeLogDto ToDTO(TimeLog entity) {
        TimeLogDto dto = new TimeLogDto();
        dto.setId(entity.getId());
        dto.setStart(entity.getStart());
        dto.setEnd(entity.getEnd());
        dto.setDate(entity.getDate());
        dto.setResult(entity.getResult());
        dto.setTracker(trackerMapper.ToDTO(entity.getTracker()));
        return dto;
    }
}
