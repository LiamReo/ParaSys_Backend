package ch.ps_backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link ch.ps_backend.model.Addiction} entity
 */
@Data
@NoArgsConstructor
public class AddictionDto implements Serializable {
    private Integer id;
    private String name;

    public AddictionDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AddictionDto;
    }

}