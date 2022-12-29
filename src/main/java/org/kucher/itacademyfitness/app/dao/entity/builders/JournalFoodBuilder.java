package org.kucher.itacademyfitness.app.dao.entity.builders;

import org.kucher.itacademyfitness.app.dao.entity.JournalFood;
import org.kucher.itacademyfitness.app.dao.entity.Product;
import org.kucher.itacademyfitness.app.dao.entity.Recipe;

import java.time.LocalDateTime;
import java.util.UUID;

public class JournalFoodBuilder {

    private UUID uuid;
    private LocalDateTime dtCreate;
    private LocalDateTime dtUpdate;
    private LocalDateTime dtSupply;
    private Recipe recipe;
    private Product product;
    private int weight;

    private JournalFoodBuilder() {

    }

    public static JournalFoodBuilder create() {
        return new JournalFoodBuilder();
    }

    public JournalFoodBuilder setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public JournalFoodBuilder setDtCreate(LocalDateTime dtCreate) {
        this.dtCreate = dtCreate;
        return this;
    }

    public JournalFoodBuilder setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
        return this;
    }

    public JournalFoodBuilder setDtSupply(LocalDateTime dtSupply) {
        this.dtSupply = dtSupply;
        return this;
    }

    public JournalFoodBuilder setRecipe(Recipe recipe) {
        this.recipe = recipe;
        return this;
    }

    public JournalFoodBuilder setProduct(Product product) {
        this.product = product;
        return this;
    }

    public JournalFoodBuilder setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public JournalFood build() {
        return new JournalFood(uuid, dtCreate,dtUpdate,dtSupply, recipe, product, weight);
    }
}
