package ch.ps_backend.service;

import ch.ps_backend.dto.AddictionDto;
import ch.ps_backend.mapper.AddictionMapper;
import ch.ps_backend.repository.AddictionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddictionService {

    private final AddictionRepository addictionRepository;
    private final AddictionMapper addictionMapper;

    public AddictionService(AddictionRepository addictionRepository, AddictionMapper addictionMapper) {
        this.addictionRepository = addictionRepository;
        this.addictionMapper = addictionMapper;
    }

    public List<AddictionDto> getAll() {
        List<AddictionDto> tempAddiction = new ArrayList<>();
        addictionRepository.findAll().forEach(addiction -> {
            tempAddiction.add(addictionMapper.ToDTO(addiction));
        });
        return tempAddiction;
    }

    public AddictionDto getById(int id) {
        return addictionMapper.ToDTO(addictionRepository.getById(id));
    }

    public void createOrUpdateAddiction(AddictionDto addictionDto) {
        addictionRepository.save(addictionMapper.FromDTO(addictionDto));
    }

    public void deleteById(int id) {
        addictionRepository.deleteById(id);
    }
}
