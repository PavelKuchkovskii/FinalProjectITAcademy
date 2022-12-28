package org.kucher.itacademyfitness.app.service.api;

import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

public interface IService <DTO, ENTITY>{

    DTO create(DTO dto);
    DTO read(long id);
    Page<DTO> get(int page, int itemsPerPage);
    DTO update(long id, LocalDateTime dtUpdate, DTO dto);
    void delete(long id, LocalDateTime dtUpdate);
    boolean validate(DTO dto);
    DTO mapToDTO(ENTITY entity);
    ENTITY mapToEntity(DTO entity);
}
