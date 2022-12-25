package org.kucher.itacademyfitness.app.dao.entity;

import org.kucher.itacademyfitness.app.dao.entity.api.IComposition;
import org.kucher.itacademyfitness.app.dao.entity.api.IProduct;

public class Composition implements IComposition {

    private IProduct product;
    private int weight;

    @Override
    public IProduct getProduct() {
        return this.product;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

}
