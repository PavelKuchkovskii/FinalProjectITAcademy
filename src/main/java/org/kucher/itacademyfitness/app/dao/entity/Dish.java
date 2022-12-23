package org.kucher.itacademyfitness.app.dao.entity;

import org.kucher.itacademyfitness.app.dao.entity.api.IDish;
import org.kucher.itacademyfitness.app.dao.entity.api.IDishComposition;

import java.time.LocalDateTime;
import java.util.UUID;

public class Dish implements IDish {

    private UUID uuid;
    private LocalDateTime dtCreate;
    private LocalDateTime dtUpdate;

    private String title;

    private IDishComposition composition;

    @Override
    public UUID getUuid() {
        return this.uuid;
    }

    @Override
    public LocalDateTime dtCreate() {
        return this.dtCreate;
    }

    @Override
    public LocalDateTime dtUpdate() {
        return this.dtUpdate;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public IDishComposition getComposition() {
        return this.composition;
    }
}
