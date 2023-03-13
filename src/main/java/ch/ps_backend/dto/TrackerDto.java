package ch.ps_backend.dto;

import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link ch.ps_backend.model.Tracker} entity
 */
@Data
@NoArgsConstructor
public class TrackerDto implements Serializable {
    private UserDto user;
    private AddictionDto addiction;
    private Integer id;
    private String name;

    public TrackerDto(UserDto user, AddictionDto addiction, Integer id, String name) {
        this.user = user;
        this.addiction = addiction;
        this.id = id;
        this.name = name;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TrackerDto;
    }

}