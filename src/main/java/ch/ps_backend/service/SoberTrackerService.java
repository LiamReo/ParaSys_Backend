package ch.ps_backend.service;

import ch.ps_backend.dto.SoberTrackerDto;
import ch.ps_backend.mapper.SoberTrackerMapper;
import ch.ps_backend.repository.SoberTrackerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SoberTrackerService {

    private final SoberTrackerRepository soberTrackerRepository;
    private final SoberTrackerMapper soberTrackerMapper;

    public SoberTrackerService(SoberTrackerRepository soberTrackerRepository, SoberTrackerMapper soberTrackerMapper) {
        this.soberTrackerRepository = soberTrackerRepository;
        this.soberTrackerMapper = soberTrackerMapper;
    }

    public List<SoberTrackerDto> getAll() {
        List<SoberTrackerDto> tempSoberTracker = new ArrayList<>();
        soberTrackerRepository.findAll().forEach(soberTracker -> {
            tempSoberTracker.add(soberTrackerMapper.ToDTO(soberTracker));
        });
        return tempSoberTracker;
    }

    public SoberTrackerDto getById(int id) {
        return soberTrackerMapper.ToDTO(soberTrackerRepository.getById(id));
    }

    public void createOrUpdateSoberTracker(SoberTrackerDto soberTrackerDto) {
        soberTrackerRepository.save(soberTrackerMapper.FromDTO(soberTrackerDto));
    }

    public void deleteById(int id) {
        soberTrackerRepository.deleteById(id);
    }
}
