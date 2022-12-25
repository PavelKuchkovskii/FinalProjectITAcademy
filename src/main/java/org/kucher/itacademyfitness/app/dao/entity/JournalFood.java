package org.kucher.itacademyfitness.app.dao.entity;

import org.kucher.itacademyfitness.app.dao.entity.api.IJournalFood;
import org.kucher.itacademyfitness.app.dao.entity.api.IProduct;
import org.kucher.itacademyfitness.app.dao.entity.api.IRecipe;

import java.time.LocalDateTime;
import java.util.UUID;

public class JournalFood implements IJournalFood {

    private UUID uuid;
    private LocalDateTime dtCreate;
    private LocalDateTime dtUpdate;
    private LocalDateTime dtSupply;
    private IRecipe recipe;
    private IProduct product;
    private int weight;

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
    public LocalDateTime getDtSupply() {
        return this.dtSupply;
    }

    @Override
    public IRecipe getRecipe() {
        return this.recipe;
    }

    @Override
    public IProduct getProduct() {
        return this.product;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }
}
