package ch.ps_backend.mapper;

import ch.ps_backend.dto.AddictionDto;
import ch.ps_backend.dto.EmotionDto;
import ch.ps_backend.model.Addiction;
import ch.ps_backend.model.Emotion;
import org.springframework.stereotype.Service;

@Service
public class EmotionMapper {

    public final Emotion FromDTO(EmotionDto dto) {
        Emotion entity = new Emotion();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setColor(dto.getColor());
        return entity;
    }

    public final EmotionDto ToDTO(Emotion entity) {
        EmotionDto dto = new EmotionDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setColor(entity.getColor());
        return dto;
    }
}
