package org.kucher.itacademyfitness.app.dao.entity;

import org.kucher.itacademyfitness.app.dao.entity.api.IUser;

import java.time.LocalDateTime;
import java.util.UUID;

public class User implements IUser {

    private UUID uuid;
    private LocalDateTime dtCreate;
    private LocalDateTime dtUpdate;

    @Override
    public UUID getUuid() {
        return this.uuid;
    }

    @Override
    public LocalDateTime getDtCreate() {
        return this.dtCreate;
    }

    @Override
    public LocalDateTime getDtUpdate() {
        return this.dtUpdate;
    }
}
