package org.kucher.itacademyfitness.app.service.api;

import java.time.LocalDateTime;
import java.util.List;

public interface IService <DTO>{

    DTO create(DTO dto);
    DTO read(long id);
    List<DTO> get();
    DTO update(long id, LocalDateTime dtUpdate, DTO dto);
    void delete(long id, LocalDateTime dtUpdate);

}
