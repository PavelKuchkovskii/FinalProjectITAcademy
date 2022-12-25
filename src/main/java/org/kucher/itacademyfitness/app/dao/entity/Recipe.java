package org.kucher.itacademyfitness.app.dao.entity;

import org.kucher.itacademyfitness.app.dao.entity.api.IRecipe;
import org.kucher.itacademyfitness.app.dao.entity.api.IComposition;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Recipe implements IRecipe {

    private UUID uuid;
    private LocalDateTime dtCreate;
    private LocalDateTime dtUpdate;
    private String title;
    private List<Composition> composition;

    public Recipe() {
    }

    public Recipe(UUID uuid, LocalDateTime dtCreate, LocalDateTime dtUpdate, String title, List<Composition> composition) {
        this.uuid = uuid;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.title = title;
        this.composition = composition;
    }

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

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public List<Composition> getComposition() {
        return this.composition;
    }
}
