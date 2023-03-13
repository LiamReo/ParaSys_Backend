package ch.ps_backend.service;

import ch.ps_backend.dto.SignUpDto;
import ch.ps_backend.dto.UserDto;
import ch.ps_backend.mapper.UserMapper;
import ch.ps_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserDto> getAll() {
        List<UserDto> tempUser = new ArrayList<>();
        userRepository.findAll().forEach(user -> {
            tempUser.add(userMapper.ToDTO(user));
        });
        return tempUser;
    }

    public UserDto getById(int id) {
        return userMapper.ToDTO(userRepository.getById(id));
    }

    public void createUser(SignUpDto userDto) {
        userRepository.save(userMapper.FromDTO(userDto));
    }

    public void updateUser(UserDto userDto) {
        userRepository.save(userMapper.FromDTO(userDto));
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public void login(UserDto userDto) {
        userRepository.save(userMapper.FromDTO(userDto));
    }
}
