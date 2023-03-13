package ch.ps_backend.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * A DTO for the {@link ch.ps_backend.model.Figure} entity
 */
@Data
public class FigureDto implements Serializable {
    private Integer id;
    private String name;
    private byte[] picture;

    public FigureDto(Integer id, String name, byte[] picture) {
        this.id = id;
        this.name = name;
        this.picture = picture;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof FigureDto;
    }

}