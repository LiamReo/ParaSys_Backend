package ch.ps_backend.dto;

import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link ch.ps_backend.model.User} entity
 */
@Data
@NoArgsConstructor
public class SignUpDto extends UserDto {
    private String password;

    public SignUpDto(Integer id, String username, String password) {
        this.password = password;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof SignUpDto;
    }

}