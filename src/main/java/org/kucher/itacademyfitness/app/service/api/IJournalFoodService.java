package org.kucher.itacademyfitness.app.service.api;

import org.kucher.itacademyfitness.app.dao.entity.JournalFood;
import org.kucher.itacademyfitness.app.service.dto.JournalFoodDTO;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface IJournalFoodService extends IService<JournalFoodDTO, JournalFood> {

    JournalFoodDTO create(JournalFoodDTO dto, UUID profileUuid);

    Page<JournalFoodDTO> get(int page, int itemsPerPage, UUID profileUuid);
}
