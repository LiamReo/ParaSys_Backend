package ch.ps_backend.mapper;

import ch.ps_backend.dto.SignUpDto;
import ch.ps_backend.dto.UserDto;
import ch.ps_backend.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public final User FromDTO(UserDto dto) {
        User entity = new User();
        entity.setId(dto.getId());
        entity.setUsername(dto.getUsername());

        if (dto instanceof SignUpDto signUpDto) {
            entity.setPassword(signUpDto.getPassword());
        }

        return entity;
    }

    public final UserDto ToDTO(User entity) {
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        return dto;
    }
}
