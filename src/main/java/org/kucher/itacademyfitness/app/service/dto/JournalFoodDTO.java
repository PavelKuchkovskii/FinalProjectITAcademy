package org.kucher.itacademyfitness.app.service.dto;

import org.kucher.itacademyfitness.app.dao.entity.Product;
import org.kucher.itacademyfitness.app.dao.entity.Recipe;

import java.time.LocalDateTime;
import java.util.UUID;

public class JournalFoodDTO {


    private UUID id;
    private LocalDateTime dtCreate;
    private LocalDateTime dtUpdate;
    private LocalDateTime dtSupply;
    private Recipe recipe;
    private Product product;
    private int weight;


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

    public LocalDateTime getDtSupply() {
        return dtSupply;
    }

    public void setDtSupply(LocalDateTime dtSupply) {
        this.dtSupply = dtSupply;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
