package org.kucher.itacademyfitness.app.dao.entity.api;

import java.time.LocalDateTime;
import java.util.UUID;

public interface IEssence {

    UUID getUuid();

    LocalDateTime dtCreate();

    LocalDateTime dtUpdate();
}
