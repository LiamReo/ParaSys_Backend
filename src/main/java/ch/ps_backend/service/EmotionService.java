package ch.ps_backend.service;

import ch.ps_backend.dto.EmotionDto;
import ch.ps_backend.mapper.EmotionMapper;
import ch.ps_backend.repository.EmotionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmotionService {

    private final EmotionRepository emotionRepository;
    private final EmotionMapper emotionMapper;

    public EmotionService(EmotionRepository emotionRepository, EmotionMapper emotionMapper) {
        this.emotionRepository = emotionRepository;
        this.emotionMapper = emotionMapper;
    }

    public List<EmotionDto> getAll() {
        List<EmotionDto> tempEmotion = new ArrayList<>();
        emotionRepository.findAll().forEach(emotion -> {
            tempEmotion.add(emotionMapper.ToDTO(emotion));
        });
        return tempEmotion;
    }

    public EmotionDto getById(int id) {
        return emotionMapper.ToDTO(emotionRepository.getById(id));
    }

    public void createOrUpdateEmotion(EmotionDto emotionDto) {
        emotionRepository.save(emotionMapper.FromDTO(emotionDto));
    }

    public void deleteById(int id) {
        emotionRepository.deleteById(id);
    }
}
