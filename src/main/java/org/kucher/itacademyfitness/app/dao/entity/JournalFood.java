package org.kucher.itacademyfitness.app.dao.entity;

import org.kucher.itacademyfitness.app.dao.entity.api.IJournalFood;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name ="journal_food")
public class JournalFood implements IJournalFood {

    @Id
    private UUID id;
    @Column(name = "dt_create")
    private LocalDateTime dtCreate;
    @Column(name = "dt_update")
    private LocalDateTime dtUpdate;
    @Column(name = "dt_supply")
    private LocalDateTime dtSupply;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "weight")
    private int weight;

    public JournalFood() {
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
    public LocalDateTime getDtSupply() {
        return this.dtSupply;
    }

    @Override
    public Recipe getRecipe() {
        return this.recipe;
    }

    @Override
    public Product getProduct() {
        return this.product;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }
}
