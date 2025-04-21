package avito.backendassignment.service;

import avito.backendassignment.controller.response.PvzGet200ResponseInner;
import avito.backendassignment.model.PVZ;
import avito.backendassignment.repository.PvzRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PvzService {

    private final PvzRepository pvzRepository;

    public List<PvzGet200ResponseInner> getPvzList(OffsetDateTime startDate, 
                                                  OffsetDateTime endDate, 
                                                  int page, 
                                                  int limit) {
        PageRequest pageable = PageRequest.of(page - 1, limit);
        
        return pvzRepository.findAllByRegistrationDateBetween(startDate, endDate, pageable)
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    public PVZ createPvz(PVZ pvz) {
        pvz.setRegistrationDate(OffsetDateTime.now());
        return pvzRepository.save(pvz);
    }

    private PvzGet200ResponseInner convertToResponse(PVZ pvz) {
        return new PvzGet200ResponseInner()
                .pvz(pvz)
                .receptions(List.of());
    }
}