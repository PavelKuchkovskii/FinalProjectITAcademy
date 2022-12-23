package org.kucher.itacademyfitness.app.dao.entity;

import org.kucher.itacademyfitness.app.dao.entity.api.IProduct;

import java.time.LocalDateTime;
import java.util.UUID;

public class Product implements IProduct {

    private UUID uuid;
    private LocalDateTime dtCreate;
    private LocalDateTime dtUpdate;
    private String title;
    private int calories;
    private int fats;
    private int carbohydrates;
    private int weight;


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
    public int getCalories() {
        return this.calories;
    }

    @Override
    public int getFats() {
        return this.fats;
    }

    @Override
    public int getCarbohydrates() {
        return this.carbohydrates;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }
}
