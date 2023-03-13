package ch.ps_backend.service;

import ch.ps_backend.dto.AmountLogDto;
import ch.ps_backend.mapper.AmountLogMapper;
import ch.ps_backend.repository.AmountLogRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AmountLogService {

    private final AmountLogRepository amountLogRepository;
    private final AmountLogMapper amountLogMapper;

    public AmountLogService(AmountLogRepository amountLogRepository, AmountLogMapper amountLogMapper) {
        this.amountLogRepository = amountLogRepository;
        this.amountLogMapper = amountLogMapper;
    }

    public List<AmountLogDto> getAll() {
        List<AmountLogDto> tempAmountLog = new ArrayList<>();
        amountLogRepository.findAll().forEach(amountLog -> {
            tempAmountLog.add(amountLogMapper.ToDTO(amountLog));
        });
        return tempAmountLog;
    }

    public AmountLogDto getById(int id) {
        return amountLogMapper.ToDTO(amountLogRepository.getById(id));
    }

    public void createOrUpdateAmountLog(AmountLogDto amountLogDto) {
        amountLogRepository.save(amountLogMapper.FromDTO(amountLogDto));
    }

    public void deleteById(int id) {
        amountLogRepository.deleteById(id);
    }
}
