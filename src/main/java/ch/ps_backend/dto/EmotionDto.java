package ch.ps_backend.dto;

import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link ch.ps_backend.model.Emotion} entity
 */
@Data
@NoArgsConstructor
public class EmotionDto implements Serializable {
    private Integer id;
    private String name;
    private String color;
    private String description;

    public EmotionDto(Integer id, String name, String color, String description) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.description = description;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof EmotionDto;
    }

}