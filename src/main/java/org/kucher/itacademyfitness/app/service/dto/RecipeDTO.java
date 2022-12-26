package org.kucher.itacademyfitness.app.service.dto;


import org.kucher.itacademyfitness.app.dao.entity.Composition;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class RecipeDTO {

    private UUID id;
    private LocalDateTime dtCreate;
    private LocalDateTime dtUpdate;
    private String title;
    private List<Composition> composition;

    public RecipeDTO() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Composition> getComposition() {
        return composition;
    }

    public void setComposition(List<Composition> composition) {
        this.composition = composition;
    }
}
