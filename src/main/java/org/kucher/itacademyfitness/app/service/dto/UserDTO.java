package org.kucher.itacademyfitness.app.service.dto;


import java.time.LocalDateTime;
import java.util.UUID;

public class UserDTO {

    private UUID uuid;
    private LocalDateTime dtCreate;
    private LocalDateTime dtUpdate;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(LocalDateTime dtCreate) {
        this.dtCreate = dtCreate;
    }

    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
    }
}
