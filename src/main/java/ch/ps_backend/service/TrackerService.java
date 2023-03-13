package ch.ps_backend.service;

import ch.ps_backend.dto.TrackerDto;
import ch.ps_backend.mapper.TrackerMapper;
import ch.ps_backend.repository.TrackerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrackerService {

    private final TrackerRepository trackerRepository;
    private final TrackerMapper trackerMapper;

    public TrackerService(TrackerRepository trackerRepository, TrackerMapper trackerMapper) {
        this.trackerRepository = trackerRepository;
        this.trackerMapper = trackerMapper;
    }

    public List<TrackerDto> getAll() {
        List<TrackerDto> tempTracker = new ArrayList<>();
        trackerRepository.findAll().forEach(tracker -> {
            tempTracker.add(trackerMapper.ToDTO(tracker));
        });
        return tempTracker;
    }

    public TrackerDto getById(int id) {
        return trackerMapper.ToDTO(trackerRepository.getById(id));
    }

    public void createOrUpdateTracker(TrackerDto trackerDto) {
        trackerRepository.save(trackerMapper.FromDTO(trackerDto));
    }

    public void deleteById(int id) {
        trackerRepository.deleteById(id);
    }
}
