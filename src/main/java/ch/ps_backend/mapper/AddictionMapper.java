package ch.ps_backend.mapper;

import ch.ps_backend.dto.AddictionDto;
import ch.ps_backend.model.Addiction;
import org.springframework.stereotype.Service;

@Service
public class AddictionMapper {

    public final Addiction FromDTO(AddictionDto dto) {
        Addiction entity = new Addiction();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    public final AddictionDto ToDTO(Addiction entity) {
        AddictionDto dto = new AddictionDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
