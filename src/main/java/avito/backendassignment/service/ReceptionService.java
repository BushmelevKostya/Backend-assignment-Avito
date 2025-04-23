package avito.backendassignment.service;

import avito.backendassignment.exceptions.ActiveReceptionExistsException;
import avito.backendassignment.exceptions.NoActiveReceptionException;
import avito.backendassignment.exceptions.PvzNotFoundException;
import avito.backendassignment.model.Reception;
import avito.backendassignment.model.StatusEnum;
import avito.backendassignment.repository.PvzRepository;
import avito.backendassignment.repository.ReceptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class ReceptionService {

    private final ReceptionRepository receptionRepository;
    private final PvzRepository pvzRepository;

    @Transactional
    public Reception createReception(Long pvzId) {
        if (!pvzRepository.existsById(pvzId)) {
            throw new PvzNotFoundException("PVZ not found with id: " + pvzId);
        }

        receptionRepository.findByPvzIdAndStatus(pvzId, StatusEnum.IN_PROGRESS)
            .ifPresent(r -> {
                throw new ActiveReceptionExistsException("Active reception already exists for PVZ: " + pvzId);
            });
        
        Reception reception = new Reception();
        reception.setPvzId(pvzId);
        reception.setStatus(StatusEnum.IN_PROGRESS);

        return receptionRepository.save(reception);
    }

    @Transactional
    public Reception closeLastReception(Long pvzId) {
        Reception reception = receptionRepository
            .findFirstByPvzIdAndStatusOrderByDateTimeDesc(pvzId, StatusEnum.IN_PROGRESS)
            .orElseThrow(() -> new NoActiveReceptionException("No active reception found for PVZ: " + pvzId));
        
        reception.setStatus(StatusEnum.CLOSE);
        return receptionRepository.save(reception);
    }
}