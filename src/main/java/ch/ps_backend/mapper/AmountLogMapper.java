package ch.ps_backend.mapper;

import ch.ps_backend.dto.AmountLogDto;
import ch.ps_backend.model.AmountLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AmountLogMapper {

    private final TrackerMapper trackerMapper;

    public AmountLogMapper(TrackerMapper trackerMapper) {
        this.trackerMapper = trackerMapper;
    }

    public final AmountLog FromDTO(AmountLogDto dto) {
        AmountLog entity = new AmountLog();
        entity.setId(dto.getId());
        entity.setAmount(dto.getAmount());
        entity.setDatetime(dto.getDatetime());
        entity.setTracker(trackerMapper.FromDTO(dto.getTracker()));
        return entity;
    }

    public final AmountLogDto ToDTO(AmountLog entity) {
        AmountLogDto dto = new AmountLogDto();
        dto.setId(entity.getId());
        dto.setAmount(entity.getAmount());
        dto.setDatetime(entity.getDatetime());
        dto.setTracker(trackerMapper.ToDTO(entity.getTracker()));
        return dto;
    }
}
