package ch.ps_backend.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * A DTO for the {@link ch.ps_backend.model.CharacterTraits} entity
 */
@Data
public class CharacterTraitsDto implements Serializable {
    private Long id;
    private String name;
    private String description;

    public CharacterTraitsDto(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CharacterTraitsDto;
    }

}