package ch.ps_backend.mapper;

import ch.ps_backend.dto.TrackerDto;
import ch.ps_backend.model.Tracker;
import ch.ps_backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;

@Service
public class TrackerMapper {

    private final AddictionMapper addictionMapper;

    private final UserMapper userMapper;

    public TrackerMapper(AddictionMapper addictionMapper, UserMapper userMapper) {
        this.addictionMapper = addictionMapper;
        this.userMapper = userMapper;
    }

    public final Tracker FromDTO(TrackerDto dto) {
        Tracker entity = new Tracker();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setUser(userMapper.FromDTO(dto.getUser()));
        entity.setAddiction(addictionMapper.FromDTO(dto.getAddiction()));
        return entity;
    }

    public final TrackerDto ToDTO(Tracker entity) {
        TrackerDto dto = new TrackerDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setUser(userMapper.ToDTO(entity.getUser()));
        dto.setAddiction(addictionMapper.ToDTO(entity.getAddiction()));
        return dto;
    }
}
