package org.kucher.itacademyfitness.app.dao.entity;

import org.kucher.itacademyfitness.app.dao.entity.api.IRecipe;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "recipe")
public class Recipe implements IRecipe {

    @Id
    private UUID id;
    @Column(name = "dt_create")
    private LocalDateTime dtCreate;
    @Column(name = "dt_update")
    private LocalDateTime dtUpdate;
    @Column(name = "title")
    private String title;

    @OneToMany
    @JoinColumn(name = "recipe_id")
    private List<Composition> composition;

    public Recipe() {
    }

    public Recipe(UUID id, LocalDateTime dtCreate, LocalDateTime dtUpdate, String title, List<Composition> composition) {
        this.id = id;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.title = title;
        this.composition = composition;
    }

    @Override
    public UUID getId() {
        return this.id;
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
