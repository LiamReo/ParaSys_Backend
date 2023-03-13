package ch.ps_backend.dto;

import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link ch.ps_backend.model.User} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer id;
    private String username;

    protected boolean canEqual(final Object other) {
        return other instanceof UserDto;
    }

}